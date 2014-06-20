package internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MonConnecteur {
	
	private URL url1;
	private HttpURLConnection conn;
	private BufferedReader rd;
	private String line;

	public String accederA(String urlToRead1){
		String result = "";
		try {

			url1 = new URL("http://www.google.com");
			conn = (HttpURLConnection) url1.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result=result+"\n" + line;

			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
