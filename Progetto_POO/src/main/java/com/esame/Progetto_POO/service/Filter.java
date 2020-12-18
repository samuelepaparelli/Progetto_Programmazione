package com.esame.Progetto_POO.service;

import java.util.Vector;

import com.esame.Progetto_POO.model.Domain;
import com.esame.Progetto_POO.model.Filtrable;
import com.esame.Progetto_POO.util.FilterUtils;

public class Filter extends DomainService implements Filtrable<Domain, Object> {
	
	private FilterUtils<Domain> futils;

	
	
	
	
	
	@Override
	public Vector<Domain> MultipleFilter(String fieldName, String operator, Object value) {
		// TODO Auto-generated method stub
		return (Vector<Domain>) futils.select(this.getDomains(), fieldName, operator, value);
	}

}
