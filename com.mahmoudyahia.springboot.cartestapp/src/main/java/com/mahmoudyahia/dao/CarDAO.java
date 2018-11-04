package com.mahmoudyahia.dao;

import java.util.List;

import com.mahmoudyahia.model.Car;

public interface CarDAO {

	public Integer save(Object o);

	public void update(Object o);

	public void delete(Object o);

	public List<Car> getAllObjects();

	public Car getObjectById(Integer id);
}
