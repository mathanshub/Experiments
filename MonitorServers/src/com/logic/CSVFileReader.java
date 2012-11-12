package com.logic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.entities.ColorCodeTypes;

import com.entities.QueryConstants;
import com.search.DTOs.ServerDTO;

public class CSVFileReader {

	public Map<String, List<ServerDTO>> processFile(List<String> Servers)
			throws IOException {

		String ServerSelected;

		Map<String, List<ServerDTO>> map = new HashMap<String, List<ServerDTO>>();

		File file = new File("D:\\TechCouncil Projects\\dummy_topoMAP.txt");
		Scanner sc = new Scanner(new FileReader(file));
		String records[];

		Iterator iterator = Servers.iterator();

		while (sc.hasNextLine()) {
			String data = sc.nextLine();
			if (!(data.trim().equals(" "))) {
				records = data.split("\\t+");
				if (records.length > 4) {

					ServerDTO tempServerDTO = new ServerDTO();
					ServerSelected = records[1];
					// System.out.println(records[0]);
					tempServerDTO.setHost_name(records[0]);
					tempServerDTO.setType(records[1]);
					tempServerDTO.setRegion(records[2]);
					tempServerDTO.setIp_address(records[3]);

					ColorCodeTypes value = ColorCodeTypes
							.getByAppCode(records[4].trim());

					if (value != null) {
						if (value.getAppColor().equalsIgnoreCase(
								QueryConstants.red)) {
							tempServerDTO.setNode_state(records[4]);
						} else if (value.getAppColor().equalsIgnoreCase(
								QueryConstants.green)) {
							tempServerDTO.setNode_state(records[4]);
						} else if (value.getAppColor().equalsIgnoreCase(
								QueryConstants.grey)) {
							tempServerDTO.setNode_state(records[4]);
						} else if (value.getAppColor().equalsIgnoreCase(
								QueryConstants.blue)) {
							tempServerDTO.setNode_state(records[4]);
						} else if (value.getAppColor().equalsIgnoreCase(
								QueryConstants.yellow)) {
							tempServerDTO.setNode_state(records[4]);
						}
					}

					List<ServerDTO> serverDTO = new ArrayList<ServerDTO>();
					if (map.containsKey(ServerSelected)) {

						Iterator it = map.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry pairs = (Map.Entry) it.next();
							if (pairs.getKey().equals(ServerSelected)) {
								serverDTO = (List<ServerDTO>) pairs.getValue();
								serverDTO.add(tempServerDTO);
							}

						}

					} else {
						serverDTO.add(tempServerDTO);
					}
					map.put(ServerSelected, serverDTO);
				}

			}

		}
		return map;
	}
}
