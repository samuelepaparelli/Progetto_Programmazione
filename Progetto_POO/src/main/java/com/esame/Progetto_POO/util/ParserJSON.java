package com.esame.Progetto_POO.util;

import java.util.Iterator;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.esame.Progetto_POO.exception.NoResultException;
import com.esame.Progetto_POO.model.Domain;
/**
 * Classe per il parsing dei file JSON
 * @author Samuele Paparelli
 * @author Lei Chen
 */

public class ParserJSON {
	
	
/**
 * Metodo che fa il parsing di una stringa e restituisce un oggetto JSON
 * @param jsonString viene passata una stringa JSON
 * @return ritorna un JSON Object
 * @throws NoResultException gestisce l'eccezione 
 *  
 */
	
	public static JSONObject parse(String jsonString) throws NoResultException {
		JSONObject jo=null;
		try {
			jo=(JSONObject) JSONValue.parseWithException(jsonString);
			if(jo.containsKey("message")) throw new NoResultException("Any domain found");
			
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
	public static Vector<Domain> parseTo(JSONObject jo){
		 Vector<Domain> domains = new Vector<Domain>();
		try {
			String jsonString= jo.toJSONString();
			JSONParser parser= new JSONParser();
			JSONObject obj;
			obj=(JSONObject) parser.parse(jsonString);
			JSONArray dom=(JSONArray) obj.get("domains");
			if(dom==null)return domains;
			Iterator i=dom.iterator();
			while(i.hasNext()) {
				JSONObject oj=(JSONObject) i.next();
	    		String domain= (String) oj.get("domain");
	    		String country= (String) oj.get("country");
	    		String create_date=(String) oj.get("create_date");
	    		String update_date=(String) oj.get("update_date");
	    		boolean isDead= (boolean) Boolean.parseBoolean((String) oj.get("isDead"));
	    		domains.add(new Domain(domain, create_date, update_date, country, isDead));
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
			return domains;
		
	}
	/**
	 * Metodo che decodifica dati stringa in formato JSON e li inserisce in vettore
	 * @param string viene passato una stringa formato JSON
	 * @return ritorna un vettore di oggetti Domain
	 * @throws NoResultException gestisce l'eccezione 
	 *  
	 */
	public static Vector<Domain> parseTo(String string) throws NoResultException {
		return parseTo(parse(string));
	}
		

}
