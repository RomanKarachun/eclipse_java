package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.db.model.Ord;
import by.grsu.rkarachun.tsm.db.model.Car;

public class OrdDaoTest extends AbstractTest {
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;
	private static final IDao<Integer, Ord> orderDao = OrdDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Ord entity = new  Ord();
		entity.setClientId(saveClient("Karachun", "375298009031").getId());
		entity.setCarId(saveCar(1).getId());
		entity.setPrice(12);
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
		entity.setClientId(saveClient("Karachun", "375298009031").getId());
		entity.setCarId(saveCar(1).getId());
		entity.setPrice(12);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);

		Integer newCarId = 2;
		entity.setCarId(newCarId);
		orderDao.update(entity);

		Ord updatedEntity = orderDao.getById(entity.getId());
		Assertions.assertEquals(newCarId, updatedEntity.getCarId());;
		Assertions.assertNotNull(updatedEntity);
	}

	@Test
	public void testDelete() {
		Ord entity = new  Ord();
		entity.setClientId(saveClient("Karachun", "375298009031").getId());
		entity.setCarId(saveCar(1).getId());
		entity.setPrice(12);
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
		entity.setClientId(saveClient("Karachun", "375298009031").getId());
		entity.setCarId(saveCar(1).getId());
		entity.setPrice(12);
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
			entity.setClientId(saveClient("Karachun" +i, "375298009031" +i).getId());
			entity.setCarId(saveCar(1).getId());
			entity.setPrice(12);
			entity.setDistance(12);
			entity.setOrderTime(getCurrentTime());
			entity.setArrivalTime(getCurrentTime());
			entity.setOrderFinish(getCurrentTime());
			orderDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, orderDao.getAll().size());
	}
	private Client saveClient(String client_name, String phone_number) {
		Client entity = new Client();
		entity.setClientName(client_name);
		entity.setPhoneNumber(phone_number);
		clientDao.insert(entity);
		return entity;
	}
	
	private Car saveCar(Integer driver_id) {
		Car entity = new Car();
		entity.setDriverId(driver_id);
		carDao.insert(entity);
		return entity;
	}

}
