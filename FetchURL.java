package com.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class FetchURL {

	public void fetch() {

		try {
			String path = "https://github.com/HackerNews/API";
			URL url = new URL(path);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			int responseCode = con.getResponseCode();
			if (responseCode == 200) {
				System.out.println("Connection is ready! 200..");
			} else {
				System.out.println("Connection failed with response code " + responseCode);
			}

			in.close();

//		            ObjectMapp mapper = new ObjectMapper();
//		            Object jsonObject = mapper.readValue(response.toString(), Object.class);
//		            String jsonFormatted = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
//		            System.out.println(jsonFormatted);

//		            JSONObject jsonObject = new JSONObject(response.toString());
//		            JSONArray articles = jsonObject.getJSONArray("{articles");
//
//		            JSONArray headlines = new JSONArray();
//		            for (int i = 0; i < articles.length(); i++) {
//		                JSONObject article = articles.getJSONObject(i);
//		                JSONObject headline = new JSONObject();
//		                headline.put("title", article.getString("title"));
//		                headline.put("url", article.getString("url"));
//		                headline.put("source", article.getJSONObject("source").getString("name"));
//		                headlines.put(headline);
//		            }
//
//		            System.out.println(headlines.toString(4));
//		            

			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FetchURL fetchURL = new FetchURL();
		fetchURL.fetch();
	}

}
