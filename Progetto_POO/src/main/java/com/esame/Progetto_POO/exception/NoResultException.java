package com.esame.Progetto_POO.exception;
/**
 * Classe per gestire l'eccezione nel caso in cui l'oggetto richiesto non è esistente
 * @author Chen Lei 
 * @author Samuele Paparelli
 * @see Ecxeption
 */
public class NoResultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoResultException() {
		super();
	}
	public NoResultException(String msg) {
		super(msg);
	}

}
