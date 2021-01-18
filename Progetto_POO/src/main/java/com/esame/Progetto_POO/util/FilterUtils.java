package com.esame.Progetto_POO.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Vector;

/**
 * FilterUtils classe per filtrare una collezione di oggetti in base ai
 * paramatri
 * 
 * @author Samuele Paparelli
 * @author Chen Lei
 * @param <T> tipo di oggetto che la classe può analizzare e convertire
 */
public class FilterUtils<T> {

	// AVAILABLE operators: eq(==) , and(&&) or(||) , not(!)
	/**
	 * metodo per effettuare il controllo, se l'attributo dell'oggetto rispetta le
	 * condizioni richieste
	 * 
	 * @param budget   valore candidato
	 * @param operator comparatore, condizione di filtro; AVAILABLE operators:
	 *                 eq(==) , and(&&) or(||) , not(!)
	 * @param request  valore richiesto dall'utente
	 * @return true se il valore candidato e' qualificato , altrimenti false
	 */
	public static boolean check(Object budget, String operator, Object request) {
		if (request instanceof String[] && budget instanceof String) {
			if (operator.equals("and")) {
				int index = ((String[]) request).length;
				for (int i = 0; i < index; i++) {
					if (!((String) budget).contains(((String[]) request)[i].toLowerCase()))
						return false;
				}
				return true;
			} else if (operator.equals("or")) {
				int index = ((String[]) request).length;
				for (int i = 0; i < index; i++) {
					if (((String) budget).contains(((String[]) request)[i].toLowerCase()))
						return true;
				}
				return false;
			} else
				return false;
		} else if (request instanceof String && budget instanceof String) {
			if (operator.equals("eq"))
				return ((String) budget).contains((String) request);
			if (operator.equals("not"))
				return !((String) budget).contains((String) request);
			return false;
		} else if ((request instanceof String || request instanceof Boolean) && budget instanceof Boolean) {
			boolean boolrequest = false;
			if (request instanceof String)
				boolrequest = (boolean) Boolean.parseBoolean((String) request);
			if (request instanceof Boolean)
				boolrequest = (boolean) request;
			if (operator.equals("eq"))
				return ((Boolean) budget ^ !boolrequest);
			if (operator.equals("not"))
				return ((Boolean) budget ^ boolrequest);
			return false;
		}

		return false;
	}

	/**
	 * metodo che prende una collezione di oggetti e restituisce la parte filtrata.
	 * 
	 * @param src       sorgente, una collezione di oggetti di tipo <T>
	 * @param fieldName nome dell'attributo che contiene il valore
	 * @param operator  comparatore
	 * @param value     valore richiesto
	 * @return collezione di oggetti filtrati
	 */

	public Collection<T> select(Collection<T> src, String fieldName, String operator, Object value) {
		Collection<T> out = new Vector<T>();
		for (T item : src) {
			try {
				Method m = item.getClass()
						.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
				try {
					Object tmp = m.invoke(item);
					if (FilterUtils.check(tmp, operator.toLowerCase(), value))
						out.add(item);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return out;
	}
}
