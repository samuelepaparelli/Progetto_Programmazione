package com.esame.Progetto_POO.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/**
 * Classe per la lettura del JSON da file o da URL
 * @author Samuele Paparelli
 * @author Lei Chen
 */


public class ReaderJSON {

/**
 * Metodo per la lettura del JSON da API 
 * @param url passiamo l'URL come stringa
 * @return ritorna una stringa contenente i dati JSON
 */
	public static String readFromURL(String url) {
		
		String data="";
		String line="";
		
		try {
			HttpURLConnection openConnection = (HttpURLConnection)new URL(url).openConnection();
			InputStream in;
			if(openConnection.getResponseCode()>=400)
				in= openConnection.getErrorStream();
			else in= openConnection.getInputStream();
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
	/**
	 *Metodo per leggere JSON da file locale 
	 * @param nomeFile passiamo una stringa con il nome del file
	 * @return ritorna una stringa contenente i dati del JSON
	 */
	public static String readFromFile(String nomeFile) {
		String data="";
		String line="";
		try {
			BufferedReader in=new BufferedReader(new FileReader(nomeFile));
			while((data=in.readLine())!=null) {
				line+=data;
			}
			in.close();
			
		}catch(IOException e) {
		 System.out.println("ERRORE di I/O");
		 System.out.println(e);
		}
	    return line;
	}
}
