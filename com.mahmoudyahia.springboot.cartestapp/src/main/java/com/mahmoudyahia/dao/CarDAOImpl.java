package com.mahmoudyahia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mahmoudyahia.model.Car;

@Repository
@Transactional
public class CarDAOImpl implements CarDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CarDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer save(Object o) {
		Integer carId = null;
		Session session = this.sessionFactory.getCurrentSession();
		carId = (Integer) session.save(o);
		return carId;
	}

	@Override
	public void delete(Object o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(o);
	}

	@Override
	public List<Car> getAllObjects() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(Car.class);
		List<Car> list = cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Override
	public Car getObjectById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		List carObjects = session.createCriteria(Car.class).add(Restrictions.eq("id", id)).setMaxResults(1000)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		Car car = new Car();
		if (carObjects != null && !carObjects.isEmpty()) {
			car = (Car) carObjects.get(0);
		}
		return car;
	}

	@Override
	public void update(Object o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
	}
}