package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Driver;
import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Ord;
import by.grsu.rkarachun.tsm.db.model.Client;

public class CarDaoTest extends AbstractTest{
	private static final IDao<Integer, Driver> driverDao = DriverDaoImpl.INSTANCE;
	private static final IDao<Integer, Ord> ordDao = OrdDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Car entity = new Car();
		entity.setNumberId(saveOrd("audi", 7846).getCarId());
		entity.setComfortLevel("Comfort");
		entity.setOwnerId(saveDriver().getId());
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testInsertWithoutOwner() {
		Car entity = new Car();
		entity.setNumberId(saveOrd("audi", 7846).getCarId());
		entity.setComfortLevel("Comfort");
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Car entity = new Car();
		entity.setNumberId(saveOrd("audi", 7846).getCarId());
		entity.setComfortLevel("Comfort");
		entity.setOwnerId(saveDriver().getId());
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);
		Assertions.assertNotNull(entity.getId());

		Ord newOrd = saveOrd("skoda", 5764);
		entity.setNumberId(newOrd.getId());
		carDao.update(entity);

		Car updatedEntity = carDao.getById(entity.getId());
		Assertions.assertEquals(newOrd.getCarId(), updatedEntity.getNumberId());
	}

	@Test
	public void testDelete() {
		Car entity = new Car();
		entity.setNumberId(saveOrd("audi", 7846).getCarId());
		entity.setComfortLevel("Comfort");
		entity.setOwnerId(saveDriver().getId());
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);

		carDao.delete(entity.getId());

		Assertions.assertNull(carDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Car entity = new Car();
		entity.setNumberId(saveOrd("audi", 7846).getCarId());
		entity.setComfortLevel("Comfort");
		entity.setOwnerId(saveDriver().getId());
		entity.setNumberSeats(4);
		entity.setFree(true);
		carDao.insert(entity);

		Car selectedEntity = carDao.getById(entity.getId());

		
		Assertions.assertEquals(entity.getNumberId(), selectedEntity.getNumberId());
		Assertions.assertEquals(0, selectedEntity.getOwnerId());
		Assertions.assertEquals(entity.getComfortLevel(), selectedEntity.getComfortLevel());
		Assertions.assertEquals(entity.getNumberSeats(), selectedEntity.getNumberSeats());
		Assertions.assertEquals(entity.getFree(), selectedEntity.getFree());

	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Car entity = new Car();
			entity.setNumberId(saveOrd("audi"+i, 7846+i).getId());
			entity.setComfortLevel("Comfort"+i);
			entity.setOwnerId(saveDriver().getId());
			entity.setNumberSeats(4+i);
			entity.setFree(true);
			carDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, carDao.getAll().size());
	}

	private Driver saveDriver() {
		Driver entity = new Driver();
		entity.setDriverName("Kunickiy");
		entity.setCar("Audi");
		entity.setPhoneNumber("375299003564");
		driverDao.insert(entity);
		return entity;
	}

	private Ord saveOrd(String client, Integer ord) {
		Client clientEntity = new Client();
		clientEntity.setName(client);
		clientDao.insert(clientEntity);

		Ord ordEntity = new Ord();
		
		ordEntity.setClientId(1);
		ordEntity.setCarId(ord);
		ordEntity.setPrice(12);
		ordEntity.setDistance(12);
		ordEntity.setOrderTime(getCurrentTime());
		ordEntity.setArrivalTime(getCurrentTime());
		ordEntity.setOrderFinish(getCurrentTime());
		ordDao.insert(ordEntity);

		return ordEntity;
	}
}
