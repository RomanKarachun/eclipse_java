package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.db.model.Ord;
import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Driver;

public class OrdDaoTest extends AbstractTest {
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;
	private static final IDao<Integer, Ord> orderDao = OrdDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Driver> driverDao = DriverDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Ord entity = new  Ord();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(saveCar("Audi 100").getId());
		entity.setPrice(5);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Ord entity = new Ord();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(saveCar("Audi 100").getId());
		entity.setPrice(5);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);

		Client newClient = saveClient("new_Karachun");
		Car newCar = saveCar("new_Audi 100");
		entity.setPrice(6);
		entity.setDistance(12);
		entity.setCarId(newCar.getId());
		entity.setClientId(newClient.getId());
		entity.setOrderFinish(getCurrentTime());
		orderDao.update(entity);

		Ord updatedEntity = orderDao.getById(entity.getId());
		Assertions.assertEquals(newClient.getId(), updatedEntity.getClientId());;
		Assertions.assertEquals(newCar.getId(), updatedEntity.getCarId());;
		Assertions.assertNotEquals(updatedEntity.getOrderFinish(), updatedEntity.getOrderTime());
	}

	@Test
	public void testDelete() {
		Ord entity = new  Ord();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(saveCar("Audi 100").getId());
		entity.setPrice(5);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);

		orderDao.delete(entity.getId());

		Assertions.assertNull(orderDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Ord entity = new  Ord();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(saveCar("Audi 100").getId());
		entity.setPrice(5);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);

		Ord selectedEntity = orderDao.getById(entity.getId());

		Assertions.assertEquals(entity.getClientId(), selectedEntity.getClientId());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Ord entity = new  Ord();
			entity.setClientId(saveClient("Karachun" +i).getId());
			entity.setCarId(saveCar("Audi 100" +i).getId());
			entity.setPrice(5);
			entity.setDistance(12);
			entity.setOrderTime(getCurrentTime());
			entity.setArrivalTime(getCurrentTime());
			entity.setOrderFinish(getCurrentTime());
			orderDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, orderDao.getAll().size());
	}
	private Client saveClient(String client_name) {
		Client clientEntity = new Client();
		clientEntity.setClientName(client_name);
		clientEntity.setPhoneNumber("375298009031");
		clientDao.insert(clientEntity);
		return clientEntity;
	}
	
	private Car saveCar(String car_name) {
		Driver driverEntity = new Driver();
		driverEntity.setDriverName("Kunickiy");
		driverEntity.setPhoneNumber("375299003564");
		driverDao.insert(driverEntity);
		
		
		Car carEntity = new Car();
		carEntity.setCarName(car_name);
		carEntity.setDriverId(driverEntity.getId());
		carEntity.setComfortLevel("Comfort");
		carEntity.setNumberSeats(4);
		carEntity.setFree(true);
		carDao.insert(carEntity);
		return carEntity;
	}

}
