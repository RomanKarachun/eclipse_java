package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Client;

public class ClientDaoTest extends AbstractTest{
	private static final IDao<Integer, Client> dao = ClientDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		 Client entity = new  Client();
		entity.setClientName("Karachun");
		entity.setPhoneNumber("375298009031");
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Client entity = new Client();
		entity.setClientName("Karachun");
		entity.setPhoneNumber("375298009031");
		dao.insert(entity);

		String newName = "Karachun_NEW";
		entity.setClientName(newName);
		dao.update(entity);

		Client updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals(newName, updatedEntity.getClientName());
		Assertions.assertNotNull(updatedEntity);
	}

	@Test
	public void testDelete() {
		 Client entity = new  Client();
		entity.setClientName("Karachun");
		entity.setPhoneNumber("375298009031");
		dao.insert(entity);

		dao.delete(entity.getId());

		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		 Client entity = new  Client();
		entity.setClientName("Karachun");
		entity.setPhoneNumber("375298009031");
		dao.insert(entity);

		 Client selectedEntity = dao.getById(entity.getId());

		Assertions.assertEquals(entity.getClientName(), selectedEntity.getClientName());
		Assertions.assertEquals(entity.getPhoneNumber(), selectedEntity.getPhoneNumber());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			 Client entity = new  Client();
			entity.setClientName("Karachun" + i);
			entity.setPhoneNumber("375298009031");// generate some random meaningless name as it is just a test (the data can be unreal)
			dao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
}