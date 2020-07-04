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
	
//	    JsonParser jp = new JsonParser(); //from gson
//	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
//	    String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
		
		String resp = result.toString();
		Object a = resp;
		//System.out.println(a);
		
		JSONObject mr = new JSONObject(result.toString());
		//System.out.println(mr);
		//System.out.println(mr.getJSONArray("richest"));
		JSONArray y = mr.getJSONArray("richest");
		JSONObject zzz = y.getJSONObject(0);
		//System.out.println(zzz.get("name"));
		//String[] x = new String[25];
		
		String res = "";
		
		for (int ii = 0; ii < y.length(); ii++) {
			JSONObject z = y.getJSONObject(ii);
			//System.out.println((ii+1) + ". " + z.get("name") + " $" + z.get("tacos"));
			res += (ii+1) + ". " + z.get("name") + " $" + z.get("tacos") + '\n';
		}
		
		//return result.toString();
		return res;
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(getHTML("http://tacoshack.online:4041/richest"));
	}

}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.URL;
//import java.nio.charset.Charset;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class HTTPRequest {
//
//  private static String readAll(Reader rd) throws IOException {
//    StringBuilder sb = new StringBuilder();
//    int cp;
//    while ((cp = rd.read()) != -1) {
//      sb.append((char) cp);
//    }
//    return sb.toString();
//  }
//
//  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
//    InputStream is = new URL(url).openStream();
//    try {
//      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//      String jsonText = readAll(rd);
//      JSONObject json = new JSONObject(jsonText);
//      return json;
//    } finally {
//      is.close();
//    }
//  }
//
//  public static void main(String[] args) throws IOException, JSONException {
//    JSONObject json = readJsonFromUrl("http://tacoshack.online:4041/richest");
//    System.out.println(json.toString());
//    System.out.println(json.get("id"));
//  }
//}