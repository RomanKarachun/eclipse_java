package by.grsu.rkarachun.tsm.db.model;

public class Driver {
	private Integer id;

	private String driverName;

	private String phoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", driverName=" + driverName + ", phoneNumber=" + phoneNumber + "]";
	}

}
