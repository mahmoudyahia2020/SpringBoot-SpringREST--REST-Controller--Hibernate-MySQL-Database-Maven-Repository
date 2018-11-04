package com.mahmoudyahia.restwebservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmoudyahia.DTO.CarDTO;
import com.mahmoudyahia.model.Car;
import com.mahmoudyahia.service.CarService;
import com.mahmoudyahia.util.CommonDateUtil;

@RestController
@RequestMapping("/myCRUD")
public class CarRestFunc {

	private CommonDateUtil commonDateUtil = new CommonDateUtil();
	private String globalStringFormat = "yyyy-MM-dd";

	@Autowired
	private CarService carService;

	@GetMapping("/getAllCars")
	public List<Car> retrieveAllCars() {
		List<Car> carList = carService.getAllObjects();
		return carList;
	}

	@GetMapping("/getCar/{id}")
	public ResponseEntity<Car> retrieveCarById(@PathVariable(value = "id") Integer id) {
		Car car = carService.getObjectById(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(car);
	}

	@PostMapping("/insertNewCar")
	public ResponseEntity<Object> insertNewCar(@RequestBody CarDTO carDto) {

		Date prodDate = commonDateUtil.convertStringToDate(carDto.getProdYear(), globalStringFormat);
		String carModel = carDto.getCarModel();
		String carName = carDto.getCarName();
		String modelDetails = carDto.getModelDetails();

		Car car = new Car(carName, carModel, prodDate, modelDetails);

		Integer savedCarId = carService.save(car);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCarId)
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/updateCar/{id}")
	public ResponseEntity<Object> updateCar(@RequestBody CarDTO carDto, @PathVariable Integer id) {

		Car upatedCar = carService.getObjectById(id);

		Date prodDate = commonDateUtil.convertStringToDate(carDto.getProdYear(), globalStringFormat);
		String carModel = carDto.getCarModel();
		String carName = carDto.getCarName();
		String modelDetails = carDto.getModelDetails();

		if (upatedCar == null) {
			return ResponseEntity.notFound().build();
		}

		upatedCar.setCarModel(carModel);
		upatedCar.setCarName(carName);
		upatedCar.setModelDetails(modelDetails);
		upatedCar.setProdYear(prodDate);

		carService.update(upatedCar);

		return ResponseEntity.ok().body(upatedCar);
	}

	@DeleteMapping("/deleteCarById/{id}")
	public ResponseEntity<Car> deleteCarById(@PathVariable(value = "id") Integer id) {
		Car deletedCar = carService.getObjectById(id);
		if (deletedCar == null) {
			return ResponseEntity.notFound().build();
		}
		carService.delete(deletedCar);
		return ResponseEntity.ok().body(deletedCar);
	}
}