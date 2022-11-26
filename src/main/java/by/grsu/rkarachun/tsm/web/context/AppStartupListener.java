package by.grsu.rkarachun.tsm.web.context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.grsu.rkarachun.tsm.db.dao.AbstractDao;
import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.dao.impl.ClientDaoImpl;
import by.grsu.rkarachun.tsm.db.dao.impl.CarDaoImpl;
import by.grsu.rkarachun.tsm.db.dao.impl.DriverDaoImpl;
import by.grsu.rkarachun.tsm.db.dao.impl.OrdDaoImpl;

import by.grsu.rkarachun.tsm.db.model.Car;
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.db.model.Driver;
import by.grsu.rkarachun.tsm.db.model.Ord;

public class AppStartupListener implements ServletContextListener {
	private static final IDao<Integer, Client> clientDao = ClientDaoImpl.INSTANCE;
	private static final IDao<Integer, Driver> driverDao = DriverDaoImpl.INSTANCE;
	private static final IDao<Integer, Car> carDao = CarDaoImpl.INSTANCE;
	private static final IDao<Integer, Ord> ordDao = OrdDaoImpl.INSTANCE;

	private static final String DB_NAME = "production-db";

	private void initDb() throws SQLException {
		AbstractDao.init(DB_NAME);
		if (!AbstractDao.isDbExist()) {
			System.out.println(String.format("DB '%s' doesn't exist and will be created", DB_NAME));
			AbstractDao.createDbSchema();
			loadInitialData();
		} else {
			System.out.println(String.format("DB '%s' exists", DB_NAME));
		}
	}

	private void loadInitialData() {
		
		Driver driverEntity = new Driver();
		driverEntity.setDriverName("Kunickiy");
		driverEntity.setPhoneNumber("375299003564");
		driverDao.insert(driverEntity);
		System.out.println("created: " + driverEntity);

		Car carEntity = new Car();
		carEntity.setCarName("Audi 100");
		carEntity.setDriverId(driverEntity.getId());
		carEntity.setComfortLevel("Comfort");
		carEntity.setNumberSeats(4);
		carEntity.setFree(true);
		carDao.insert(carEntity);
		System.out.println("created: " + carEntity);

		Client clientEntity = new Client();
		clientEntity.setClientName("Karachun");
		clientEntity.setPhoneNumber("375298009031");
		clientDao.insert(clientEntity);
		System.out.println("created: " + clientEntity);
		
		Ord ordEntity = new Ord();
		ordEntity.setClientId(clientEntity.getId());
		ordEntity.setCarId(carEntity.getId());
		ordEntity.setPrice(5);
		ordEntity.setDistance(12);
		ordEntity.setOrderTime(getCurrentTime());
		ordEntity.setArrivalTime(getCurrentTime());
		ordEntity.setOrderFinish(getCurrentTime());
		ordDao.insert(ordEntity);
		System.out.println("created: " + ordEntity);

		
		System.out.println("initial data created");
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		try {
			initDb();
		} catch (SQLException e) {
			throw new RuntimeException("can't init DB", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}