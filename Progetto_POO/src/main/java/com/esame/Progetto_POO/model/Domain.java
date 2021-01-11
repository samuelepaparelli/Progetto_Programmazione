package com.esame.Progetto_POO.model;
/**
 * Classe per la modellazione dei metadati di un dominio.
 * @author Samuele Paparelli
 * @author Chen Lei
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
 * @param isDead        parametro contenente la stringa che restituisce true se il sito è inattivo e false se è attivo 
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
	 * @return il dominio
	 */
	public String getDomain() {
		return this.domain;
	}
	/**
	 * Metodo che ritorna il tipo ovvero TLD
	 * @return il tipo ovvero TLD 
	 */
	public String getType() {
		return this.domain.split("\\.")[1];
	}
	/**
	 * Metodo che modifica la data di creazione
	 * @param create_date
	 */
	public void setCreateDate(String create_date) {
		this.create_date=create_date;
	}
	/**
	 * Metodo che ritorna la data di creazione del sito
	 * @return data di creazione del sito
	 */
	public String getCreateDate() {
		return this.create_date;
	}
	/**
	 * Metodo che modifica la data di aggiornamento
	 * @param update_date
	 */
	public void setUpdateDate(String update_date) {
		this.update_date=update_date;
	}
	/**
	 * Metodo che ritorna la data di aggiornamento
	 * @return ultima data aggiornata
	 */
	public String getUpdateDate() {
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
	 * @return la nazione di hosting
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
	 * Metodo che ritorna il contrario di IsDead
	 * @return il valore di Alive
	 */
	public boolean getAlive() {
		return !this.isDead;
	}
	/**
	 * Metodo toString dell'oggetto Domain in formato JSONObject
	 */
	public String toString() {
		return "{\"domain\":\""+getDomain()+"\",\"createDate\":\""+getCreateDate()+
				"\",\"updateDate\":\""+getUpdateDate()+"\",\"country\":\""+getCountry()+"\",\"isDead\":\""+getIsDead()+"\"}";   
	}
	/**
	 * Metodo equals della classe Domain
	 * @param o un'altro oggetto Domain da confrontare
	 * @return true se i due oggetti Domain hanno gli stessi attributi
	 */
	public boolean equals(Domain o) {
		if(o==null) return false;
		if(!(o instanceof Domain)) return false;
		if(this.domain.equals(o.domain)&&this.country.equals(o.country)&&this.create_date.equals(o.create_date))
			return true;
		else return false;
	}

}
