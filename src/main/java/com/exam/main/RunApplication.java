package com.exam.main;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.exam.controller.AccountManageController;

public class RunApplication {

	private static Logger log = Logger.getLogger(AccountManageController.class);
	
	public static void main(String[] args) {
		try {
			runApp();
		} catch (ClientProtocolException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void runApp() throws ClientProtocolException, IOException {
		
		String visitUrl = "http://localhost:8080/AccountManagement/home";
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(visitUrl);
		client.execute(httpGet);
		System.out.println("加载成功...");
	}
}
