package com.esame.Progetto_POO.exception;
/**
 * Classe eccezione quando non trovo l'oggetto interessato
 * @author ChenLei SamuelePaparelli
 *
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
