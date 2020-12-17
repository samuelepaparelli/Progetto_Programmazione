package com.esame.Progetto_POO.model;

import java.util.Collection;

/**
 * Interfaccia per avere un filtro multiplo
 * @author ChenLei SamuelePaparelli 
 *
 */
public interface Filtrable<T> {
	/**
	 * Metodo astratto la cui impementazione andrà a filtrare la collezione in base alle richieste DAFARE
	 * @return collezione di oggetti di tipo T filtrato
	 */
	public abstract Collection<T> MultipleFilter();
}
