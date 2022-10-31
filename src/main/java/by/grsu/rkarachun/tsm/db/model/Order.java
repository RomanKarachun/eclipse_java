package by.grsu.rkarachun.tsm.db.model;

import java.sql.Timestamp;

public class Order {
	private Integer id;

	private Integer client_id;
	
	private Integer car_id;

	private Integer price;

	private Integer distance;

	private Timestamp order_time;

	private Timestamp arrival_time;
	
	private Timestamp order_finish;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public Integer getCar_id() {
		return car_id;
	}

	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Timestamp getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}

	public Timestamp getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Timestamp arrival_time) {
		this.arrival_time = arrival_time;
	}

	public Timestamp getOrder_finish() {
		return order_finish;
	}

	public void setOrder_finish(Timestamp order_finish) {
		this.order_finish = order_finish;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", client_id=" + client_id + ", car_id=" + car_id + ", price=" + price
				+ ", distance=" + distance + ", order_time=" + order_time + ", arrival_time=" + arrival_time
				+ ", order_finish=" + order_finish + "]";
	}
}
