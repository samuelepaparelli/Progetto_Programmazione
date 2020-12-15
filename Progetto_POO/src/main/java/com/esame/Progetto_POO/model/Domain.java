package com.esame.Progetto_POO.model;
/**
 * 
 * @author Samuele Paparelli Chen Lei
 *
 */
public class Domain {
	private String domain;
	private String create_date;
	private String update_date;
	private String country;
	private boolean isDead;
/**
 * Costruttore della classe Domain
 * @param domain        parametro contenente la stringa del dominio
 * @param create_date   parametro contenente la stringa della data di creazione del dominio
 * @param update_date   parametro contenente la stringa della data di aggiornamento del dominio
 * @param country       parametro contenente la stringa della nazione di hosting
 * @param isDead        parametro contenente il booleano che restituisce true se il sito è inattivo 
 */
	public Domain(String domain,String create_date,String update_date,String country,boolean isDead) {
		this.domain=domain;
		this.create_date=create_date;
		this.update_date=update_date;
		this.country=country;
		this.isDead=isDead;
	}
	/**
	 * Metodo che modifica il dominio
	 * @param domain
	 */
	public void setDomain(String domain) {
		this.domain=domain;
	}
	/**
	 * Metodo che ritorna il dominio
	 * @return
	 */
	public String getDomain() {
		return this.domain;
	}
	/**
	 * Metodo che modifica la data di creazione
	 * @param create_date
	 */
	public void setCreate_date(String create_date) {
		this.create_date=create_date;
	}
	/**
	 * Metodo che ritorna la data di creazione del sito
	 * @return 
	 */
	public String getCreate_date() {
		return this.create_date;
	}
	/**
	 * Metodo che modifica la data di aggiornamento
	 * @param update_date
	 */
	public void setUpdate_date(String update_date) {
		this.update_date=update_date;
	}
	/**
	 * Metodo che ritorna la data di aggiornamento
	 * @return
	 */
	public String getUpdate_date() {
		return this.update_date;
	}
	/**
	 * Metodo che modifica la nazione di hosting
	 * @param country
	 */
	public void setCountry(String country) {
		this.country=country;
	}
	/**
	 * Metodo che ritorna la nazione di hosting
	 * @return
	 */
	public String getCountry() {
		return this.country;
	}
	/**
	 * Metodo che modifica il valore di isDead
	 * @param isDead
	 */
	public void setIsDead(boolean isDead) {
		this.isDead=isDead;
	}
	/**
	 * Metodo che ritorna il valore di isDead
	 * @return  il valore di isDead
	 */
	public boolean getIsDead() {
		return this.isDead;
	}
	/**
	 * Metodo toString dell'oggetto Domain
	 */
	 
	public String toString() {
		return "Parametri del dominio: domain="+getDomain()+"create_date: "+getCreate_date()+
				"update_date: "+getUpdate_date()+"country: "+getCountry()+"isDead: "+getIsDead();   
	}
	/**
	 * Metodo equals della classe Domain
	 * @param o
	 * @return
	 */
	public boolean equals(Domain o) {
		if(o==null) return false;
		if(!(o instanceof Domain)) return false;
		if(this.domain.equals(o.domain)&&this.country.equals(o.country)&&this.create_date.equals(o.create_date))
			return true;
		else return false;
	}

}
