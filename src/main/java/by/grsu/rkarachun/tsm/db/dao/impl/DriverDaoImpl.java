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
import by.grsu.rkarachun.tsm.db.model.Client;
import by.grsu.rkarachun.tsm.db.model.Driver;
import by.grsu.rkarachun.tsm.web.dto.SortDto;
import by.grsu.rkarachun.tsm.web.dto.TableStateDto;

public class DriverDaoImpl extends AbstractDao implements IDao<Integer, Driver> {
	public static final DriverDaoImpl INSTANCE = new DriverDaoImpl();

	private DriverDaoImpl() {
		super();
	}

	@Override
	public void insert(Driver entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("insert into driver(driver_name, phone_number) values(?,?)");
			pstmt.setString(1, entity.getDriverName());
			pstmt.setString(2, entity.getPhoneNumber());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "driver"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Driver entity", e);
		}
	}

	@Override
	public void update(Driver entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update driver set driver_name=?, phone_number=? where id=?");
			pstmt.setString(1, entity.getDriverName());
			pstmt.setString(2, entity.getPhoneNumber());
			pstmt.setInt(3, entity.getId());
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
		entity.setPhoneNumber(rs.getString("phone_number"));
		return entity;
	}
	
	@Override
	public List<Driver> find(TableStateDto tableStateDto) {
		List<Driver> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			StringBuilder sql = new StringBuilder("select * from driver");

			final SortDto sortDto = tableStateDto.getSort();
			if (sortDto != null) {
				sql.append(String.format(" order by %s %s", sortDto.getColumn(), resolveSortOrder(sortDto)));
			}

			sql.append(" limit " + tableStateDto.getItemsPerPage());
			sql.append(" offset " + resolveOffset(tableStateDto));

			System.out.println("searching Drivers using SQL: " + sql);
			ResultSet rs = c.createStatement().executeQuery(sql.toString());
			while (rs.next()) {
				Driver entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Driver entities", e);
		}
		return entitiesList;
	}

	@Override
	public int count() {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select count(*) as c from driver");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");
		} catch (SQLException e) {
			throw new RuntimeException("can't get drivers count", e);
		}
	}

}
