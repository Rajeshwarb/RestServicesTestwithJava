package tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDatafromSite {
	private final String USER_AGENT = "Mozilla/5.0";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GetDatafromSite http = new GetDatafromSite();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
	}

	
	private void sendGet() throws Exception {

		//String url = "https://cloud.google.com/speech/";
		String url="https://api.openweathermap.org/data/2.5/forecast?id=1269843&APPID=b03d8c52a4c7774ef6cc35e82b7165e0";
		//"http://del.icio.us/api/:username/bookmarks/";
		//String url = "http://globalweather.asmx/GetWeather?CityName=string&CountryName=string HTTP/1.1";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		System.out.println(con.getInputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
}
