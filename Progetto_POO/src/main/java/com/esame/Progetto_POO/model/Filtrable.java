package com.esame.Progetto_POO.model;

import java.util.Collection;

/**
 * Interfaccia per avere un filtro multiplo
 * @author ChenLei SamuelePaparelli 
 *
 */
public interface Filtrable<E,T> {
	public abstract Collection<E> MultipleFilter(String fieldName, String operator, T value);
}