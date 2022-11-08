package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Driver;
import by.grsu.rkarachun.tsm.db.model.Car;

public class CarDaoTest extends AbstractTest{
	private static final IDao<Integer, Driver> driverDao = DriverDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Car entity = new Car();
		entity.setCarName("Audi 100");
		entity.setDriverId(saveDriver("Kunickiy").getId());
		entity.setComfortLevel("Comfort");
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Car entity = new Car();
		entity.setCarName("Audi 100");
		entity.setDriverId(saveDriver("Kunickiy").getId());
		entity.setComfortLevel("Comfort");
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);
		
		String newCarName = "Audi 80";
		entity.setCarName(newCarName);
		Driver newDriver = saveDriver("new_Kunickiy");
		String newComfortLevel = "Business";
		entity.setComfortLevel(newComfortLevel);
		entity.setNumberSeats(5);
		entity.setFree(false);
		carDao.update(entity);

		Car updatedEntity = carDao.getById(entity.getId());
		Assertions.assertEquals(newCarName, updatedEntity.getCarName());
		Assertions.assertEquals(newComfortLevel, updatedEntity.getComfortLevel());
		Assertions.assertNotEquals(newDriver.getId(), updatedEntity.getDriverId());
		Assertions.assertEquals(5, updatedEntity.getNumberSeats());
		Assertions.assertEquals(false, updatedEntity.getFree());
	}

	@Test
	public void testDelete() {
		Car entity = new Car();
		entity.setCarName("Audi 100");
		entity.setDriverId(saveDriver("Kunickiy").getId());
		entity.setComfortLevel("Comfort");
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);

		carDao.delete(entity.getId());

		Assertions.assertNull(carDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Car entity = new Car();
		entity.setCarName("Audi 100");
		entity.setDriverId(saveDriver("Kunickiy").getId());
		entity.setComfortLevel("Comfort");
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);

		Car selectedEntity = carDao.getById(entity.getId());

		Assertions.assertNotEquals(0, selectedEntity.getDriverId());

	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Car entity = new Car();
			entity.setCarName("Audi 100" +i);
			entity.setDriverId(saveDriver("Kunickiy" +i).getId());
			entity.setComfortLevel("Comfort" +i);
			entity.setNumberSeats(4);
			entity.setFree(true);
			carDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, carDao.getAll().size());
	}

	private Driver saveDriver(String driver_name) {
		Driver entity = new Driver();
		entity.setDriverName(driver_name);
		entity.setPhoneNumber("375299003564");
		driverDao.insert(entity);
		return entity;
	}

}
