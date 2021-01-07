package com.esame.Progetto_POO.model;

import java.util.Collection;

/**
 * Classe usata per convertire una stringa in un oggetto JSON-Simple
 * @author ChenLei
 * @author SamuelePaparelli 
 *
 * @param <T> tipo di oggetto che la classe può analizzare e convertire
 */
public interface ParsebleTo<T> {
	
	/**
	 * Metodo astratto la cui impementazione andrà ad analizzare la Stringa in formato JSON e convertirlo in oggetti di tipo T
	 * @param source Stringa in formato JSON
	 * @return collezione di oggetti di tipo T 
	 */
	public abstract Collection<T> filterField(String source);
}
