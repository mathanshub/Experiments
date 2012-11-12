package com;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.cgi.entities.UserReportDTO;
import com.cgi.logging.AppLog;
import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;

public class UserInfo {

	public ArrayList<UserReportDTO> userReport = new ArrayList();

	public ArrayList<UserReportDTO> getUserInfo() {

		File file = new File(ConfigHelper
				.getApplicationProperty(ApplicationConstants.USER_FILE_DIR));

		try {
			Scanner sc = new Scanner(new FileReader(file));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String record[] = line.split("\\s+");
				UserReportDTO report = new UserReportDTO(record[0], record[1],
						record[2]);
				userReport.add(report);
				// UserInfo userInfo = new UserInfo();
				// userInfo.setUserName(sc.next());

			}

		} catch (Exception e) {
			AppLog.logError("Exception occured : " + AppLog.getStackTrace(e),
					e, DealerDataHandler.class.getName());
		}
		return userReport;
	}

}
