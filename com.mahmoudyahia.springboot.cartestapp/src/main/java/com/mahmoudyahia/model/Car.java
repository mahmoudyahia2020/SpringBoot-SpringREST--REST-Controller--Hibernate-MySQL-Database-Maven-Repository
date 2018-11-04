package com.mahmoudyahia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "car")
public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "car_id")
	private Integer id;
	@Column(name = "car_name")
	private String carName;
	@Column(name = "car_model")
	private String carModel;
	@Column(name = "year_of_production")
	@Temporal(TemporalType.DATE)
	private Date prodYear;
	@Column(name = "model_details")
	private String modelDetails;

	public Car(String carName, String carModel, Date prodYear, String modelDetails) {
		this.id = id;
		this.carName = carName;
		this.carModel = carModel;
		this.prodYear = prodYear;
		this.modelDetails = modelDetails;
	}

	public Car() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the carName
	 */
	public String getCarName() {
		return carName;
	}

	/**
	 * @param carName the carName to set
	 */
	public void setCarName(String carName) {
		this.carName = carName;
	}

	/**
	 * @return the carModel
	 */
	public String getCarModel() {
		return carModel;
	}

	/**
	 * @param carModel the carModel to set
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	/**
	 * @return the prodYear
	 */
	public Date getProdYear() {
		return prodYear;
	}

	/**
	 * @param prodYear the prodYear to set
	 */
	public void setProdYear(Date prodYear) {
		this.prodYear = prodYear;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
