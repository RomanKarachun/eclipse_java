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
import by.grsu.rkarachun.tsm.web.dto.SortDto;
import by.grsu.rkarachun.tsm.web.dto.TableStateDto;

public class CarDaoImpl extends AbstractDao implements IDao<Integer, Car> {
	public static final CarDaoImpl INSTANCE = new CarDaoImpl();

	private CarDaoImpl() {
		super();
	}

	@Override
	public void insert(Car entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"insert into car(driver_id, car_name, comfort_level, number_seats, free) values(?,?,?,?,?)");
			pstmt.setObject(1, entity.getDriverId());
			pstmt.setString(2, entity.getCarName());
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
			PreparedStatement pstmt = c.prepareStatement(
					"update car set driver_id=?, car_name=?, comfort_level=?, number_seats=?, free=? where id=?");
			pstmt.setObject(1, entity.getDriverId());
			pstmt.setString(2, entity.getCarName());
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
		entity.setCarName(rs.getString("car_name"));
		entity.setDriverId(rs.getInt("driver_id"));
		entity.setComfortLevel(rs.getString("comfort_level"));
		entity.setNumberSeats(rs.getInt("number_seats"));
		entity.setFree(rs.getBoolean("free"));
		// getObject() is unsupported by current JDBC driver. We will get "0" if field
		// is NULL in DB
		return entity;
	}
	
	@Override
	public List<Car> find(TableStateDto tableStateDto) {
		List<Car> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			StringBuilder sql = new StringBuilder("select * from car");

			final SortDto sortDto = tableStateDto.getSort();
			if (sortDto != null) {
				sql.append(String.format(" order by %s %s", sortDto.getColumn(), resolveSortOrder(sortDto)));
			}

			sql.append(" limit " + tableStateDto.getItemsPerPage());
			sql.append(" offset " + resolveOffset(tableStateDto));

			System.out.println("searching Cars using SQL: " + sql);
			ResultSet rs = c.createStatement().executeQuery(sql.toString());
			while (rs.next()) {
				Car entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Car entities", e);
		}
		return entitiesList;
	}

	@Override
	public int count() {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select count(*) as c from car");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");
		} catch (SQLException e) {
			throw new RuntimeException("can't get cars count", e);
		}
	}
}
