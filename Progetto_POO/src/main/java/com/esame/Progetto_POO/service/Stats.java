package com.esame.Progetto_POO.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.json.simple.JSONObject;

import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.model.Statistics;
/**
 * classe statistics per ottenere statistiche su un insieme di domini
 * @author ChenLei 
 * @author SamuelePaparelli
 * @see DomainService
 * @see Statistics
 *
 */
public class Stats extends DomainService implements Statistics {
	
	/**
	 * modello per il formato data
	 */
	private static final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

	public Stats(Vector<Domain> domains) {
		super(domains);
		// TODO Auto-generated constructor stub
	}
	/**
	 * metodo per ottenere la quantita di domini analizzati
	 * @return quantita in intero
	 */
	public int quantity() {
		return this.domains.size();
	}
	/**
	 * metodo per ottenere quantita di domini ancora vivi
	 * @return quantita di domini vivi in intero
	 */
	public int quantityOfAlive() {
		int count = 0;
		for(Domain element:domains) {
			try{if(!element.getIsDead())count++;
			}catch(NullPointerException e){}
		}
		return count;
	}
	/**
	 * metodo per ottenere il tempo medio di update tra elementi del vettore
	 * @return tempo medio di update in stringa; esempio:5Y10D , con Y=Years e D=Days
	 */
	public String averageUpdateTime() {
		//String updateDate = "2020-12-29T18:00:55.935544";
		long sum=0;
		int size=this.quantity();
		if(size>1) {
		long[] updateDateInSeconds=new long[domains.size()];
		for(int i=0;i<size;i++){
			//trasformo updateTime in secondi trascorsi dal 1970
			updateDateInSeconds[i] = LocalDateTime.parse(domains.get(i).getUpdateDate(),pattern).toEpochSecond(ZoneOffset.UTC);
		}
		Arrays.sort(updateDateInSeconds);
		for(int i=1;i<size;i++) {
			// differenza in secondi
			sum+=updateDateInSeconds[i]-updateDateInSeconds[i-1];
		}
		sum=(sum/(size-1))/86400; // media in giorni
		return (sum/365)+"Y"+(sum%365)+"D";
		}else return null;
	}
	/**
	 * metodo per ottenere un elenco sul numero di domini per ciascuna nazione presente nel vettore
	 * @return HashMap di tipo <String,Integer>, con Key l'abbreviazione della nazione e value la quantita.
	 */
	public Map<String, Integer> hostingNations() {
		Map<String,Integer> nazioni = new HashMap<String, Integer>();
		String nazione;
		for(Domain element:domains) {
			nazione = element.getCountry();
			if(nazioni.containsKey(nazione)) {
				nazioni.replace(nazione, 1+nazioni.get(nazione));
			}else nazioni.put(nazione, 1);
		}
		return nazioni;
	}
	/**
	 * metodo per ottenere un elenco sul numero di domini per ogni TOP_LEVEL_DOMAIN presente nel vettore
	 * @return HashMap di tipo <String,Integer>, con Key il TLD e value la quantita.
	 */
	public Map<String, Integer> type() {
		Map<String,Integer> tipologie = new HashMap<String, Integer>();
		String tipo;
		for(Domain element:domains) {
			tipo = element.getType();
			if(tipologie.containsKey(tipo)) {
				tipologie.replace(tipo, 1+tipologie.get(tipo));
			}else tipologie.put(tipo, 1);
		}
		return tipologie;
	}
	/**
	 * metodo per ottenere un elenco sul numero di domini per ogni mese presente nel vettore
	 * @return HashMap di tipo <String,Integer>, con Key anno-mese e value la quantita.
	 */
	public Map<String, Integer> createdDate() {
		Map<String,Integer> elencoPerMesi = new HashMap<String, Integer>();
		String data;
		for(Domain element:domains) {
			try{data = element.getCreateDate().substring(0,7);
			if(elencoPerMesi.containsKey(data)) {
				elencoPerMesi.replace(data, 1+elencoPerMesi.get(data));
			}else elencoPerMesi.put(data, 1);
			}catch(NullPointerException e) {}
		}
		return elencoPerMesi;
	}
	

	@Override
	public String viewStats() {
		return "{\"quantity\":"+quantity()+
				",\"quantityOfAlive\":"+quantityOfAlive()+
				",\"averageUpdateTime\":"+averageUpdateTime()+
				",\"hostingNations\":"+(new JSONObject(hostingNations()))+
				",\"type\":"+(new JSONObject(type()))+
				",\"createdDate\":"+(new JSONObject(createdDate()))+"}";
	}
	
	@Override
	public String toString() {
		return viewStats();
	}

}
