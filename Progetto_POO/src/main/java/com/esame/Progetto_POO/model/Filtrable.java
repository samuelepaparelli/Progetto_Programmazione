package com.esame.Progetto_POO.model;

import java.util.Collection;

/**
 * Interfaccia per l'implementazione del filtro multiplo
 * @author ChenLei
 * @author SamuelePaparelli 
 *
 */
public interface Filtrable<E,T> {
	public abstract Collection<E> MultipleFilter(String fieldName, String operator, T value);
}