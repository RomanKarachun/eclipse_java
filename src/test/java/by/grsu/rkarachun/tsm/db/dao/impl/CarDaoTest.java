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
		entity.setDriverId(saveDriver().getId());
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Car entity = new Car();
		entity.setDriverId(saveDriver().getId());
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());

		carDao.update(entity);

		Car updatedEntity = carDao.getById(entity.getId());
	}

	@Test
	public void testDelete() {
		Car entity = new Car();
		entity.setDriverId(saveDriver().getId());
		carDao.insert(entity);

		carDao.delete(entity.getId());

		Assertions.assertNull(carDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Car entity = new Car();
		entity.setDriverId(saveDriver().getId());
		carDao.insert(entity);

		Car selectedEntity = carDao.getById(entity.getId());

		Assertions.assertNotEquals(0, selectedEntity.getDriverId());

	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Car entity = new Car();
			entity.setDriverId(saveDriver().getId());
			carDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, carDao.getAll().size());
	}

	private Driver saveDriver() {
		Driver entity = new Driver();
		entity.setDriverName("Kunickiy");
		entity.setPhoneNumber("375299003564");
		driverDao.insert(entity);
		return entity;
	}

}
