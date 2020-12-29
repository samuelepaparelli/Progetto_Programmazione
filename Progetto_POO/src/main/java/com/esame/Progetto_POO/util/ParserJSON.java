package com.esame.Progetto_POO.util;

import java.util.Iterator;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.esame.Progetto_POO.model.Domain;
/**
 * Classe per il parsing dei file JSON
 * @author Samuele Paparelli
 * @author Lei Chen
 */

public class ParserJSON extends ReaderJSON{
	static final String URL= " ";
	public Vector<Domain> domains;
/**
 * Metodo per il parsing da file o da URL	
 * @param isURL parametro passato per chiedere al metodo se fare il parsing da file o URL
 * @return ritorna una JSON String 
 */
	
	public String parse(boolean isURL) {
		String jsonString= " ";
		try {
			JSONObject jo;
			if(isURL) {
				jo=(JSONObject) JSONValue.parseWithException(readFromURL(URL));
				jsonString= jo.toJSONString();
			}else {
				jo=(JSONObject) JSONValue.parseWithException(readFromFile("localJSON.json"));
				jsonString= jo.toJSONString();
			}	
		}catch (ParseException e) {
		 e.printStackTrace();
		}
		return jsonString;
	}
	/**
	 * Metodo per la decodifica della stringa json e inserimento dei dati nel vettore domains
	 * @param isURL parametro passato per chiedere al metodo se lavorare con la stringa presa dal file o con la stringa presa dall'API
	 * @return ritorna un vettore di oggetti Domain
	 */
	public Vector<Domain> parseTo(boolean isURL){
		try {
			Domain d=null;
			JSONParser parser= new JSONParser();
			JSONObject obj;
			if(isURL) {
				obj=(JSONObject) parser.parse(parse(true));
			}else obj=(JSONObject) parser.parse(parse(false));
			JSONArray dom=(JSONArray) obj.get("domains");
			Iterator i=dom.iterator();
			while(i.hasNext()) {
				JSONObject oj=(JSONObject) i.next();
	    		String domain= (String) oj.get("domain");
	    		String country= (String) oj.get("country");
	    		String create_date=(String) oj.get("create_date");
	    		String update_date=(String) oj.get("update_date");
	    		boolean isDead= (boolean) Boolean.parseBoolean((String) oj.get("isDead"));
	    		domains.add(d=new Domain(domain, create_date, update_date, country, isDead));
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
			return domains;
		
	}
		

}
