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
import by.grsu.rkarachun.tsm.db.model.Ord;
import by.grsu.rkarachun.tsm.web.dto.SortDto;
import by.grsu.rkarachun.tsm.web.dto.TableStateDto;

public class OrdDaoImpl extends AbstractDao implements IDao<Integer, Ord> {

	// single instance of this class to be used by the all consumers
	public static final OrdDaoImpl INSTANCE = new OrdDaoImpl();

	// private constructor disallows instantiation of this class ('Singleton'
	// pattern) outside of current class
	private OrdDaoImpl() {
		super();
	}

	@Override
	public void insert(Ord entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"insert into ord(client_id, car_id, price, distance, order_time, arrival_time, order_finish) values(?,?,?,?,?,?,?)");
			pstmt.setObject(1, entity.getClientId());
			pstmt.setObject(2, entity.getCarId());
			pstmt.setInt(3, entity.getPrice());
			pstmt.setInt(4, entity.getDistance());
			pstmt.setTimestamp(5, entity.getOrderTime());
			pstmt.setTimestamp(6, entity.getArrivalTime());
			pstmt.setTimestamp(7, entity.getOrderFinish());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "ord"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Ord entity", e);
		}
	}

	@Override
	public void update(Ord entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update ord set client_id=?, car_id=?, price=?, distance=?, order_time=?, arrival_time==?, order_finish=? where id=?");
			pstmt.setObject(1, entity.getClientId());
			pstmt.setObject(2, entity.getCarId());
			pstmt.setInt(3, entity.getPrice());
			pstmt.setInt(4, entity.getDistance());
			pstmt.setTimestamp(5, entity.getOrderTime());
			pstmt.setTimestamp(6, entity.getArrivalTime());
			pstmt.setTimestamp(7, entity.getOrderFinish());
			pstmt.setInt(8, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Ord entity", e);
		}
	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from ord where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Ord entity", e);
		}

	}

	@Override
	public Ord getById(Integer id) {
		Ord entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from ord where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Ord entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Ord> getAll() {
		List<Ord> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from ord");
			while (rs.next()) {
				Ord entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Ord entities", e);
		}

		return entitiesList;
	}

	private Ord rowToEntity(ResultSet rs) throws SQLException {
		Ord entity = new Ord();
		entity.setId(rs.getInt("id"));
		entity.setClientId(rs.getInt("client_id"));
		entity.setCarId(rs.getInt("car_id"));
		entity.setPrice(rs.getInt("price"));
		entity.setDistance(rs.getInt("distance"));
		entity.setOrderTime(rs.getTimestamp("order_time"));
		entity.setArrivalTime(rs.getTimestamp("arrival_time"));
		entity.setOrderFinish(rs.getTimestamp("order_finish"));
		return entity;
	}
	
	@Override
	public List<Ord> find(TableStateDto tableStateDto) {
		List<Ord> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			StringBuilder sql = new StringBuilder("select * from ord");

			final SortDto sortDto = tableStateDto.getSort();
			if (sortDto != null) {
				sql.append(String.format(" order by %s %s", sortDto.getColumn(), resolveSortOrder(sortDto)));
			}

			sql.append(" limit " + tableStateDto.getItemsPerPage());
			sql.append(" offset " + resolveOffset(tableStateDto));

			System.out.println("searching Cars using SQL: " + sql);
			ResultSet rs = c.createStatement().executeQuery(sql.toString());
			while (rs.next()) {
				Ord entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Ord entities", e);
		}
		return entitiesList;
	}

	@Override
	public int count() {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select count(*) as c from ord");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("c");
		} catch (SQLException e) {
			throw new RuntimeException("can't get ords count", e);
		}
	}
}
