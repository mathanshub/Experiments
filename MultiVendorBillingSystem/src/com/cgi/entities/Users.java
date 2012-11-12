package com.cgi.entities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {

	public ArrayList<String> users;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getUsers() throws IOException {

		File file = new File("D:\\Mahacoder\\MultiVendor\\users.txt");
		Scanner sc = new Scanner(new FileReader(file));
		while (sc.hasNext()) {
			users.add(sc.next());
			//UserInfo userInfo = new UserInfo();
			//userInfo.setUserName(sc.next());

		}
		return users;
	}

}