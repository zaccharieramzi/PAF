package internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MonConnecteur mc = new MonConnecteur();
		System.out.println(mc.accederA("http://www.koreus.com"));
	}

}
