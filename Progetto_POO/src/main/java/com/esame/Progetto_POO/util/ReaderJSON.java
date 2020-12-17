package com.esame.Progetto_POO.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
/**
 * 
 * @author Samuele Paparelli
 * @author Lei Chen
 */


public class ReaderJSON {
/**
 * Metodo per la lettura del JSON da API 
 * @param url passiamo l'URL come stringa
 * @return un parametro di tipo stringa dove è contenuto il JSON
 */
	public String readFromURL(String url) {
		
		String data=" ";
		String line=" ";
		
		try {
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in= openConnection.getInputStream();
			try {
				InputStreamReader inR= new InputStreamReader(in);
				BufferedReader buf= new BufferedReader(inR);
				while((line= buf.readLine())!=null) {
					data+=line;
				}
			}finally {
				in.close();
			}
		}catch(IOException e) {
			e.getStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return data;
	}
	
	/*public String readFromFile() {
		
	}*/
}
