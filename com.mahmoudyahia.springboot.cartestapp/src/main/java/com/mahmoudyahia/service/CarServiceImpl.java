package com.mahmoudyahia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.mahmoudyahia.dao.CarDAO;
import com.mahmoudyahia.model.Car;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDAO carDAO;

	@Override
	public Integer save(Car o) {
		return this.carDAO.save(o);
	}

	@Override
	public void delete(Car o) {
		this.carDAO.delete(o);
	}

	@Override
	public List<Car> getAllObjects() {
		return this.carDAO.getAllObjects();
	}

	@Override
	public Car getObjectById(Integer id) {
		return this.carDAO.getObjectById(id);
	}

	@Override
	public void update(Car o) {
		this.carDAO.update(o);

	}

}
