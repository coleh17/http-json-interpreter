import java.io.*;
import java.net.*;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class HTTPRequest {

	public static String getHTML(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		String[] test = new String[50];
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		int i = 0;
		while ((line = rd.readLine()) != null) {
			result.append(line);
			test[i] = line;
			i++;
		}
		rd.close();
		
		JSONObject mr = new JSONObject(result.toString());
		JSONArray y = mr.getJSONArray("richest");
		String res = "";
		
		for (int ii = 0; ii < y.length(); ii++) {
			JSONObject z = y.getJSONObject(ii);
			res += (ii+1) + ". " + z.get("name") + " $" + z.get("tacos") + '\n';
		}
		
		//return result.toString();
		return res;
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(getHTML("http://tacoshack.online:4041/richest"));
	}

}