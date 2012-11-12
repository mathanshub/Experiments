package com.web.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.web.actions.BaseAction;
import com.entities.ColorCodeTypes;
import com.entities.QueryConstants;
import com.entities.ToggleColorCodes;
import com.logic.CSVFileReader;
import com.search.DTOs.ServerDTO;

public class SelectionCriteria extends BaseAction {

	public List<String> Servers = new ArrayList<String>();
	Map<String, List<ServerDTO>> map;

	public String init() {

		String forward = "SUCCESS";

		addServerInfo();

		return forward;
	}

	public String queryServer() throws IOException {
		String forward = "SUCCESS";

		// List<ServerDTO> serverDTO=new
		// CSVFileReader().processFile(getServers());
		// setServers((List<String>)getSessionAttribute(QueryConstants.RESULTS_SERVER));

		/*
		 * Iterator iterator=getServers().iterator(); while(iterator.hasNext())
		 * System.out.println(iterator.next());
		 */

		if (getSessionAttribute("MAP_INFO") == null) {

			System.out.println("MAp is null now......");
			map = new CSVFileReader().processFile(getServers());
			setMap(map);
			setSessionAttribute("MAP_INFO", map);
		} else {

			map = (Map<String, List<ServerDTO>>) getSessionAttribute("MAP_INFO");
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();
				List<ServerDTO> temp = (List<ServerDTO>) pairs.getValue();
				Iterator iterat = temp.iterator();
				while (iterat.hasNext()) {
					ServerDTO tempServ = (ServerDTO) iterat.next();

					if (tempServ.getNode_state() != null) {
						ToggleColorCodes values;
						values = ToggleColorCodes.getByAppCode(tempServ
								.getNode_state().trim());
						tempServ.setNode_state(values.getAppToggle());
					}
				}
			}

			setSessionAttribute("MAP_INFO", map);

		}

		/*
		 * System.out.println("Printing output from processor logic"); Iterator
		 * it=map.entrySet().iterator(); while(it.hasNext()){ Map.Entry
		 * pairs=(Map.Entry)it.next();
		 * System.out.println("Server:::::::::::"+pairs.getKey());
		 * 
		 * List<ServerDTO> temp=(List<ServerDTO>)pairs.getValue(); Iterator
		 * iterat=temp.iterator(); while(iterat.hasNext()){ ServerDTO
		 * tempServ=(ServerDTO)iterat.next(); System.out.println("HostName:" +
		 * tempServ.getHost_name()+"\t\tType:"+tempServ.getType()+"\t\tNode
		 * Status"+ tempServ.getNode_state()); } }
		 */

		return forward;

	}

	public void addServerInfo() {

		Servers.add("network analyzer");
		Servers.add("Netcool server");
		Servers.add("LADP server");
		Servers.add("WebSeal server");
		setSessionAttribute(QueryConstants.RESULTS_SERVER, Servers);
		setServers(Servers);

	}

	public List<String> getServers() {
		return Servers;
	}

	public void setServers(List<String> servers) {
		Servers = servers;
	}

	public Map<String, List<ServerDTO>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<ServerDTO>> map) {
		this.map = map;
	}

}
