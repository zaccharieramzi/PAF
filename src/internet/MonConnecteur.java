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
	private String name;
	private String authorName;
	private String date;
	private String type;

	public void accederA(String urlToRead){
		int cpt =0;
		try {

			url1 = new URL(urlToRead);
			conn = (HttpURLConnection) url1.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
				if(line.startsWith("    <td>")){
					cpt++;
					switch(cpt)
					{
					
					case 1: authorName=line;break;
					case 2: name = line; break;
					case 3: type=line;break;
					case 4: date =line;break;

					}
				}

			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getDate(){
		return this.date;
	}
	public String getAuthorName(){
		return this.authorName;
	}
	public String getName(){
		return this.name;
	}
	public String getType(){
		return this.type;
	}
}
