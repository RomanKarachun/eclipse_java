package by.grsu.rkarachun.tsm.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Driver;

public class DriverDaoTest extends AbstractTest{
	private static final IDao<Integer, Driver> dao = DriverDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Driver entity = new  Driver();
		entity.setDriverName("Kunickiy");
		entity.setPhoneNumber("375299003564");
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Driver entity = new Driver();
		entity.setDriverName("Kunickiy");
		entity.setPhoneNumber("375299003564");
		dao.insert(entity);

		String newDriverName = "Kunickiy_NEW";
		entity.setDriverName(newDriverName);
		dao.update(entity);

		Driver updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals(newDriverName, updatedEntity.getDriverName());
		Assertions.assertNotNull(updatedEntity);
	}

	@Test
	public void testDelete() {
		Driver entity = new  Driver();
		entity.setDriverName("Kunickiy");
		entity.setPhoneNumber("375299003564");
		dao.insert(entity);

		dao.delete(entity.getId());

		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Driver entity = new  Driver();
		entity.setDriverName("Kunickiy");
		entity.setPhoneNumber("375299003564");
		dao.insert(entity);

		Driver selectedEntity = dao.getById(entity.getId());

		Assertions.assertEquals(entity.getDriverName(), selectedEntity.getDriverName());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Driver entity = new  Driver();
			entity.setDriverName("Kunickiy"+ i);
			entity.setPhoneNumber("375299003564");
			dao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
}
