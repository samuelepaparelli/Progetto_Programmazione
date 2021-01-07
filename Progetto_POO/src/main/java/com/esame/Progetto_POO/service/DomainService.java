package com.esame.Progetto_POO.service;

import java.util.Vector;

import com.esame.Progetto_POO.model.Domain;

/**
 * Classe astratta contenente elementi utili per servizi 
 * @author ChenLei
 * @author SamuelePaparelli 
 *
 */
public abstract class DomainService {
	/**
	 * vettore di Domini che verrà usato dai servizi 
	 */
	protected Vector<Domain> domains;
	/**
	 * Costruttore del filtro
	 * @param domains vettore di domini
	 */
	public DomainService(Vector<Domain> domains) {
		this.domains=domains;
	}
	/**
	 * Getter del vettore di Domini
	 * @return collezione di oggetti di tipo Domain sottoforma di vettore
	 */
	public Vector<Domain> getDomains() {
		return domains;
	}
}
