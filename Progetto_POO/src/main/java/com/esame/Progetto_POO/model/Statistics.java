package com.esame.Progetto_POO.model;

import java.util.Vector;

/**
 * Interfaccia per ottenere statistiche su una collezione di domini
 * @author ChenLei SamuelePaparelli 
 *
 */
public interface Statistics {

	/**
	 * Metodo per ottenere tutte le statistiche su una collezione di domini
	 * @return in stringa formato JSON di tutte le statistiche
	 */
	public abstract String viewStats();

}
