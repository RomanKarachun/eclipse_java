package by.grsu.rkarachun.tsm.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.rkarachun.tsm.db.dao.AbstractDao;
import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Car;

public class CarDaoImpl extends AbstractDao implements IDao<Integer, Car> {
	public static final CarDaoImpl INSTANCE = new CarDaoImpl();

	private CarDaoImpl() {
		super();
	}

	@Override
	public void insert(Car entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into car(number_id, owner_id, comfort_level, number_of_seats, free) values(?,?,?,?,?)");
			pstmt.setInt(1, entity.getNumberId());
			pstmt.setInt(2, entity.getOwnerId());
			pstmt.setString(3, entity.getComfortLevel());
			pstmt.setInt(4, entity.getNumberSeats());
			pstmt.setBoolean(5, entity.getFree());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "car"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Car entity", e);
		}

	}

	@Override
	public void update(Car entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("update car set number_id=?, owner_id=?, comfort_level=?,  number_of_seats=?, free=?, where id=?");
			pstmt.setInt(1, entity.getNumberId());
			pstmt.setInt(2, entity.getOwnerId());
			pstmt.setString(3, entity.getComfortLevel());
			pstmt.setInt(4, entity.getNumberSeats());
			pstmt.setBoolean(5, entity.getFree());
			pstmt.setInt(6, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Car entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from car where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Car entity", e);
		}
	}

	@Override
	public Car getById(Integer id) {
		Car entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from car where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Car entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Car> getAll() {
		List<Car> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from car");
			while (rs.next()) {
				Car entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Car entities", e);
		}

		return entitiesList;
	}

	private Car rowToEntity(ResultSet rs) throws SQLException {
		Car entity = new Car();
		entity.setId(rs.getInt("id"));
		entity.setNumberId(rs.getInt("number_id"));
		entity.setOwnerId(rs.getInt("owner_id"));
		entity.setComfortLevel(rs.getString("comfort_Level"));
		// getObject() is unsupported by current JDBC driver. We will get "0" if field is NULL in DB
		entity.setNumberSeats(rs.getInt("number_of_seats"));
		entity.setFree(rs.getBoolean("free"));
		return entity;
	}
}
