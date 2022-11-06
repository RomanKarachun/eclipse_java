package by.grsu.rkarachun.tsm.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.rkarachun.tsm.db.dao.AbstractDao;
import by.grsu.rkarachun.tsm.db.dao.IDao;
import by.grsu.rkarachun.tsm.db.model.Order_object;

public class OrderDaoImpl extends AbstractDao implements IDao<Integer, Order_object>{

	// single instance of this class to be used by the all consumers
		public static final OrderDaoImpl INSTANCE = new OrderDaoImpl();

		// private constructor disallows instantiation of this class ('Singleton'
		// pattern) outside of current class
		private OrderDaoImpl() {
			super();
		}

		@Override
		public void insert(Order_object entity) {
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("insert into order_object(client_id, car_id, price, distance, order_time, arrival_time, order_finish) values(?,?,?,?,?,?,?)");
				pstmt.setInt(1, entity.getClientId());
				pstmt.setInt(2, entity.getCarId());
				pstmt.setInt(3, entity.getPrice());
				pstmt.setInt(4, entity.getDistance());
				pstmt.setTimestamp(5, entity.getOrderTime());
				pstmt.setTimestamp(6, entity.getArrivalTime());
				pstmt.setTimestamp(7, entity.getOrderFinish());
				pstmt.executeUpdate();
				entity.setId(getGeneratedId(c, "order_object"));
			} catch (SQLException e) {
				throw new RuntimeException("can't insert Order_object entity", e);
			}
		}

		@Override
		public void update(Order_object entity) {
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("update order_object set client_id=?, car_id=?, price=?, distance?, order_time=?, arrival_time=?, order_finish=? where id=?");
				pstmt.setInt(1, entity.getClientId());
				pstmt.setInt(2, entity.getCarId());
				pstmt.setInt(3, entity.getPrice());
				pstmt.setInt(4, entity.getDistance());
				pstmt.setTimestamp(5, entity.getOrderTime());
				pstmt.setTimestamp(6, entity.getArrivalTime());
				pstmt.setTimestamp(7, entity.getOrderFinish());
				pstmt.setInt(8, entity.getId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("can't update Order_object entity", e);
			}
		}

		@Override
		public void delete(Integer id) {
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("delete from order_object where id=?");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("can't delete Order_object entity", e);
			}

		}

		@Override
		public Order_object getById(Integer id) {
			Order_object entity = null;
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("select * from order_object where id=?");
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					entity = rowToEntity(rs);
				}
			} catch (SQLException e) {
				throw new RuntimeException("can't get Order_object entity by id", e);
			}

			return entity;
		}

		@Override
		public List<Order_object> getAll() {
			List<Order_object> entitiesList = new ArrayList<>();
			try (Connection c = createConnection()) {
				ResultSet rs = c.createStatement().executeQuery("select * from order_object");
				while (rs.next()) {
					Order_object entity = rowToEntity(rs);
					entitiesList.add(entity);
				}
			} catch (SQLException e) {
				throw new RuntimeException("can't select Order_object entities", e);
			}

			return entitiesList;
		}

		private Order_object rowToEntity(ResultSet rs) throws SQLException {
			Order_object entity = new Order_object();
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
}
