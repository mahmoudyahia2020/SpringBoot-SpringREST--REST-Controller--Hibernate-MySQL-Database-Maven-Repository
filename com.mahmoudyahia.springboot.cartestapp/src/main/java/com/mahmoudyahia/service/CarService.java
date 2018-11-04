package com.mahmoudyahia.service;

import java.util.List;

import com.mahmoudyahia.model.Car;

public interface CarService {

	public Integer save(Car o);

	public void delete(Car o);

	public List<Car> getAllObjects();

	public Car getObjectById(Integer id);

	public void update(Car o);

}
