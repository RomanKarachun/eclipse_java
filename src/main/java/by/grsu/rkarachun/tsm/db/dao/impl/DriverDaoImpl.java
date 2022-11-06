package by.grsu.rkarachun.tsm.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.rkarachun.tsm.db.dao.AbstractDao;
import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Driver;

public class DriverDaoImpl extends AbstractDao implements IDao<Integer, Driver> {
	public static final DriverDaoImpl INSTANCE = new DriverDaoImpl();

	private DriverDaoImpl() {
		super();
	}

	@Override
	public void insert(Driver entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("insert into driver(driver_name, car, phone_number) values(?,?,?)");
			pstmt.setString(1, entity.getDriverName());
			pstmt.setString(2, entity.getCar());
			pstmt.setString(3, entity.getPhoneNumber());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "driver"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Driver entity", e);
		}
	}

	@Override
	public void update(Driver entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update driver set driver_name=?, car=?, phone_number=? where id=?");
			pstmt.setString(1, entity.getDriverName());
			pstmt.setString(2, entity.getCar());
			pstmt.setString(3, entity.getPhoneNumber());
			pstmt.setInt(4, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Driver entity", e);
		}
	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from driver where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Driver entity", e);
		}

	}

	@Override
	public Driver getById(Integer id) {
		Driver entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from driver where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Driver entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Driver> getAll() {
		List<Driver> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from driver");
			while (rs.next()) {
				Driver entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Driver entities", e);
		}

		return entitiesList;
	}

	private Driver rowToEntity(ResultSet rs) throws SQLException {
		Driver entity = new Driver();
		entity.setId(rs.getInt("id"));
		entity.setDriverName(rs.getString("driver_name"));
		entity.setCar(rs.getString("car"));
		entity.setPhoneNumber(rs.getString("phone_number"));
		return entity;
	}

}
