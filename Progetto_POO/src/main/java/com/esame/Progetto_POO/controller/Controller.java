package com.esame.Progetto_POO.controller;

import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.service.Filter;
import com.esame.Progetto_POO.service.Stats;
import com.esame.Progetto_POO.util.ParserJSON;
import com.esame.Progetto_POO.util.ReaderJSON;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller che fornisce tutte le rotte del REST API
 * 
 * @author ChenLei SamuelePaparelli
 *
 */
@RestController
public class Controller {

	/**
	 * un pezzo di URL per accedere all'API
	 */
	private static final String searchURL = "https://api.domainsdb.info/v1/domains/search?domain=";

	/**
	 * nome del file salvato nel PC
	 */
	private static final String fileName = "api.txt";

	/**
	 * Rotta per visualizzare statistiche su una collezione di domini(fornito
	 * dall'API di domainsdb.info) che soddisfano il parametro
	 * 
	 * @param cognome o la parola che e' contenuta nel nome del dominio
	 * @return stringa delle statistiche dei siti in standard JSON
	 */
	@GetMapping("/{cognome}/stats")
	public String getDomainGiveStats(@PathVariable("cognome") String cognome) {

		Stats stats = new Stats(ParserJSON.parseTo(ReaderJSON.readFromURL(searchURL + cognome)));
		return stats.viewStats();
	}

	/**
	 * Rotta per visualizzare collezione di domini(fornito dall'API di
	 * domainsdb.info) filtrati in base ai parametri
	 * 
	 * @param cognome o la parola che e' contenuta nel nome del dominio
	 * @param type    , filtro per il TLD del dominio
	 * @param nation  , filtro per la nazione di hosting
	 * @param alive   , filtro per domini ancora attivi
	 * @return stringa in standard JSON (JSONArray) della collezione di domini
	 *         filtrati
	 */
	@GetMapping("/{cognome}/filter")
	public String getDomainAndFilter(@PathVariable("cognome") String cognome,
			@RequestParam(name = "type", defaultValue = "") String type,
			@RequestParam(name = "nation", defaultValue = "") String nation,
			@RequestParam(name = "alive", defaultValue = "undefined") String alive) {

		Filter filter = new Filter(ParserJSON.parseTo(ReaderJSON.readFromURL(searchURL + cognome)));
		filter = new Filter(filter.filterByType(type));
		filter = new Filter(filter.filterByNations(nation));
		if (!alive.equals("undefined"))
			filter = new Filter(filter.filterByAlive(Boolean.parseBoolean(alive)));
		return filter.getDomains().toString();
	}

	/**
	 * Rotta per visuallizare collezione di domini(fornito dall'API di
	 * domainsdb.info) contenente la parola(cognome)
	 * 
	 * @param cognome o la parola che e' contenuta nel nome del dominio
	 * @return stringa in standard JSON (JSONArray) della collezione di domini
	 */
	@GetMapping("/{cognome}")
	public String getDomain(@PathVariable("cognome") String cognome) {

		Vector<Domain> domains = ParserJSON.parseTo(ReaderJSON.readFromURL(searchURL + cognome));
		return domains.toString();
	}

	/**
	 * Rotta per visualizzare statistiche su una collezione di domini salvati nel
	 * computer
	 * 
	 * @return stringa delle statistiche dei siti in standard JSON
	 */
	@GetMapping("/localstats")
	public String getStatsOfFileLocale() {

		Stats stats = new Stats(ParserJSON.parseTo(ReaderJSON.readFromFile(fileName)));
		return stats.viewStats();
	}

	/**
	 * Rotta per filtrare i domini(fornito dall'API di domainsdb.info) per i campi
	 * disponibili dall'oggetto Domain, usando una richiesta POST
	 * 
	 * @param cognome o la parola che e' contenuta nel nome del dominio
	 * @param body    , body della richiesta POST inserito dall'utente con una
	 *                struttura precisa
	 * @return stringa in standard JSON (JSONArray) della collezione di domini
	 *         filtrati
	 */
	@PostMapping(path = "/{cognome}/filter")
	public String MultipleFilterWithPOST(@PathVariable("cognome ") String cognome, @RequestBody String body) {

		Filter filter = new Filter(ParserJSON.parseTo(ReaderJSON.readFromURL(searchURL + cognome)));
		Vector<Domain> domainsOK = new Vector<Domain>();
		JSONObject bodyjson = ParserJSON.parse(body);
		if ("or".equals(bodyjson.get("logica"))) {
			bodyjson.remove("logica");
			Set<String> keys = bodyjson.keySet();
			for (String key : keys) {
				Object[] param = POSTBodyToParams(key, (JSONObject) bodyjson.get(key));
				domainsOK.addAll(filter.MultipleFilter((String) param[0], (String) param[1], param[2]));
				Vector<Domain> temp = filter.getDomains();
				temp.removeAll(domainsOK);
				filter = new Filter(temp);
			}
		} else {
			bodyjson.remove("logica");
			Set<String> keys = bodyjson.keySet();
			for (String key : keys) {
				Object[] param = POSTBodyToParams(key, (JSONObject) bodyjson.get(key));
				domainsOK = filter.MultipleFilter((String) param[0], (String) param[1], param[2]);
				filter = new Filter(domainsOK);
			}
		}
		return domainsOK.toString();

	}

	/**
	 * metodo per interfacciare i attributi del JSONObject con i parametri del
	 * filtro multiplo
	 * 
	 * @param key   l'attributo del JSONObject
	 * @param value valore del rispettivo key
	 * @return array di Object di lunghezza 3 : campo , comparatore , valore
	 */
	private Object[] POSTBodyToParams(String key, JSONObject value) {
		Object[] params = new Object[3];
		params[0] = key;
		Iterator iter = value.keySet().iterator();
		params[1] = iter.next();
		params[2] = value.get(params[1]);
		if (params[2] instanceof JSONArray) {
			JSONArray jarray = (JSONArray) params[2];
			String[] temp = new String[jarray.size()];
			for (int i = 0; i < jarray.size(); i++) {
				temp[i] = (String) jarray.get(i);
			}
			params[2] = temp;
		}
		return params;
	}
}
