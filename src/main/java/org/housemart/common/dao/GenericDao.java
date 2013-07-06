package org.housemart.common.dao;

import java.util.List;

public interface GenericDao<T> {	
	
	List<T> select(String statementid, Object para);
	
	int add(String statementid, Object para);
	
	T load(String statementid, int id);
	
	int delete(String statementid, int id);
	
	int deletePhysical(String statementid, Object args);
	int deletePhysical(String statementid, int id);
	
	int update(String statementid, Object para);
	
	int count(String statementid, Object para);
	
	<S> List<S> selectByType(String statementid, Object args);
	
}


