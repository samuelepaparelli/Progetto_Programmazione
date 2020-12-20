package com.esame.Progetto_POO.service;

import java.util.Vector;

import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.model.Filtrable;
import com.esame.Progetto_POO.util.FilterUtils;
/**
 * Classe figlia di DomainService, effettua il filtro su un dato vettore di domini.
 * @author ChenLei SamuelePaparelli
 *
 */
public class Filter extends DomainService implements Filtrable<Domain, Object> {
	/**
	 * oggetto FilterUtils che consente il filtraggio multiplo.
	 */
	private FilterUtils<Domain> futils;
	/**
	 * Metodo per filtrare il vettore di domini in base alla tipologia esempi: net,org,com,it,us,etc..
	 * @param tipologia ovvero il Top-level domain  
	 * @return vettore di domini filtrato
	 */
	public Vector<Domain> filterByType(String tipologia){
		if(!tipologia.substring(0,1).equals("."))tipologia="."+tipologia;
		Vector<Domain> out = new Vector<Domain>();
		for(Domain item:super.getDomains()){
			try {
			if(item.getDomain().contains(tipologia.toLowerCase()))out.add(item);
			}catch(NullPointerException e) {
				
			}
		}
		return out;
	}
	/**
	 * Metodo per filtrare il vettore di domini in base alla nazione esempi: IT,US,FR,UK,etc..
	 * @param nazione di hosting 
	 * @return vettore di domini filtrato
	 */
	public Vector<Domain> filterByNations(String nazione){
		Vector<Domain> out = new Vector<Domain>();
		for(Domain item:super.getDomains()){
			try {
			if(item.getCountry().contains(nazione.toUpperCase()))out.add(item);
			}catch(NullPointerException e){
				
			}
		}
		return out;
	}
	/**
	 * Metodo per filtrare il vettore di domini selezionando quelli attivi/inattivi
	 * @param alive true=attivo false=inattivo
	 * @return vettore di domini filtrato
	 */
	public Vector<Domain> filterByAlive(Boolean alive){
		Vector<Domain> out = new Vector<Domain>();
		for(Domain item:super.getDomains()){
			try {
			if(item.getIsDead()!=alive)out.add(item);
			}catch(NullPointerException e){
				
			}
		}
		return out;
	}
	
	
	
	
	@Override
	public Vector<Domain> MultipleFilter(String fieldName, String operator, Object value) {
		// TODO Auto-generated method stub
		return (Vector<Domain>) futils.select(this.getDomains(), fieldName, operator, value);
	}

}
