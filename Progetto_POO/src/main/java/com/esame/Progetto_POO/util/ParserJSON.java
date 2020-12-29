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

public class ParserJSON {
	
	public Vector<Domain> domains;
	
/**
 * Metodo che fa il parsing di una stringa e restituisce un oggetto JSON
 * @param jsonString viene passata una stringa JSON
 * @return ritorna un JSON Object
 */
	
	public JSONObject parse(String jsonString) {
		JSONObject jo=null;
		try {
			jo=(JSONObject) JSONValue.parseWithException(jsonString);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return jo;
	}
	/**
	 * Metodo che decodifica dati dal JSON e li inserisce in vettore
	 * @param jo viene passato un JSON object
	 * @return ritorna un vettore di oggetti Domain
	 */
	public Vector<Domain> parseTo(JSONObject jo){
		try {
			Domain d=null;
			String jsonString= jo.toJSONString();
			JSONParser parser= new JSONParser();
			JSONObject obj;
			obj=(JSONObject) parser.parse(jsonString);
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
