package by.grsu.rkarachun.tsm.db.model;

public class Car {
	private Integer id;
	
	private Integer driverId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", driverId=" + driverId + "]";
	}


}
