package com.kienvu.IDAO;

import java.util.List;

public interface I_CRUD<T> {
	List<T> getAll();
	
	int save(T t);
	void update(T t);
	boolean delete(int id );
	
}
