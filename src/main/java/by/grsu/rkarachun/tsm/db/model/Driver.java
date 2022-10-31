package by.grsu.rkarachun.tsm.db.model;

public class Driver {
	private Integer id;

	private String driver_name;

	private String Car;

	private String phone_number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getCar() {
		return Car;
	}

	public void setCar(String car) {
		Car = car;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "driver [id=" + id + ", driver_name=" + driver_name + ", Car=" + Car + ", phone_number=" + phone_number
				+ "]";
	}
}
