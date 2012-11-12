package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cgi.entities.UDRDTO;
import com.cgi.logging.AppLog;
import com.cgi.parser.AlcatelUDRParser;
import com.cgi.parser.CiscoUDRParser;
import com.cgi.parser.ErricsonUDRParser;
import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;

public class DealerDataHandler {
	List<UDRDTO> udrs = new ArrayList();

	public List<UDRDTO> process() throws IOException {

		AppLog.log("Entering DealerDataHandler::processData", this.getClass()
				.getName());
		String inputDIR = ConfigHelper
				.getApplicationProperty(ApplicationConstants.INPUT_FILE_DIR);
		File folder = new File(inputDIR);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles == null)
			AppLog.log("Invalid directory", this.getClass().getName());
		else {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {

					AppLog.log("UDR FILE:" + listOfFiles[i].getName(), this
							.getClass().getName());
					String filename = listOfFiles[i].getName();
					mapData(filename, listOfFiles[i].getAbsolutePath());
				}
			}
			AppLog.log("Exiting ProcessDealerData::processData", this
					.getClass().getName());

		}

		return udrs;
	}

	private List<UDRDTO> mapData(String filename, String absPath) {
		AppLog.log("Entering DealerDataHandler::Map Data", this.getClass()
				.getName());
		UDRDTO udrDTO;
		if (filename.startsWith("Alcatel")) {
			try {
				udrDTO = new AlcatelUDRParser().parseAlcatelUDR(new File(
						absPath));
				if(udrDTO.getAcct_Session_Time()==null || udrDTO.getAccnt_output_octets()==null){
					//ErrorReport.errorReport(udrDTO,filename);
					}
				else{
					CFG.CFGenrator(udrDTO,filename);
					udrs.add(udrDTO);
				}
				
			} catch (Exception e) {
				AppLog
						.logError("Exception in Alcatel Parser"
								+ AppLog.getStackTrace(e), e, this.getClass()
								.getName());
			}

		} else if (filename.startsWith("Cisco")) {

			try {
				udrDTO = new CiscoUDRParser().parseCiscoUDR(new File(absPath));
				if(udrDTO.getAcct_Session_Time()==null || udrDTO.getAccnt_output_octets()==null){
					ErrorReport.errorReport(udrDTO,filename);
					}
				else{
					CFG.CFGenrator(udrDTO,filename);
					udrs.add(udrDTO);
				}
			} catch (Exception e) {
				AppLog.logError("Exception occured : "
						+ AppLog.getStackTrace(e), e, DealerDataHandler.class
						.getName());

			}
			
		} else if (filename.startsWith("Erricson")) {
			try {
				udrDTO = new ErricsonUDRParser().parseErricsonUDR(new File(
						absPath));
			//	CFG.CFGenrator(udrDTO,filename);
				if(udrDTO.getAcct_Session_Time()==null || udrDTO.getAccnt_output_octets()==null){
					ErrorReport.errorReport(udrDTO,filename);
					}
				else{
					CFG.CFGenrator(udrDTO,filename);
					udrs.add(udrDTO);
				}
			} catch (Exception e) {
				AppLog.logError("Exception occured : "
						+ AppLog.getStackTrace(e), e, DealerDataHandler.class
						.getName());

			}
			
		}

		AppLog.log("Exiting DealerDataHandler::Map Data", this.getClass()
				.getName());
		return udrs;
	}
}
