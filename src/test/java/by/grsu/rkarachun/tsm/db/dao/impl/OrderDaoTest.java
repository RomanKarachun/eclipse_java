package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.db.model.Order_object;

public class OrderDaoTest extends AbstractTest {
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;
	private static final IDao<Integer, Order_object> orderDao = OrderDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Order_object entity = new  Order_object();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(1);
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
		Order_object entity = new Order_object();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(1);
		entity.setPrice(12);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);

		Integer newCarId = 2;
		entity.setCarId(newCarId);
		orderDao.update(entity);

		Order_object updatedEntity = orderDao.getById(entity.getId());
		Assertions.assertEquals(newCarId, updatedEntity.getCarId());
		Assertions.assertNotNull(updatedEntity);
	}

	@Test
	public void testDelete() {
		Order_object entity = new  Order_object();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(1);
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
		Order_object entity = new  Order_object();
		entity.setClientId(saveClient("Karachun").getId());
		entity.setCarId(1);
		entity.setPrice(12);
		entity.setDistance(12);
		entity.setOrderTime(getCurrentTime());
		entity.setArrivalTime(getCurrentTime());
		entity.setOrderFinish(getCurrentTime());
		orderDao.insert(entity);

		Order_object selectedEntity = orderDao.getById(entity.getId());

		Assertions.assertEquals(entity.getClientId(), selectedEntity.getClientId());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Order_object entity = new  Order_object();
			entity.setClientId(saveClient("Karachun"+ i).getId());
			entity.setCarId(1+ i);
			entity.setPrice(12);
			entity.setDistance(12);
			entity.setOrderTime(getCurrentTime());
			entity.setArrivalTime(getCurrentTime());
			entity.setOrderFinish(getCurrentTime());
			orderDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, orderDao.getAll().size());
	}
	private Client saveClient(String name) {
		Client entity = new Client();
		entity.setName(name);
		clientDao.insert(entity);
		return entity;
	}

}
