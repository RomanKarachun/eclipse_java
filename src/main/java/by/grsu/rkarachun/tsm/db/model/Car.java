package by.grsu.rkarachun.tsm.db.model;

public class Car {
	private Integer id;

	private String carName;

	private Integer driverId;

	private String comfortLevel;

	private Integer numberSeats;

	private Boolean free;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getComfortLevel() {
		return comfortLevel;
	}

	public void setComfortLevel(String comfortLevel) {
		this.comfortLevel = comfortLevel;
	}

	public Integer getNumberSeats() {
		return numberSeats;
	}

	public void setNumberSeats(Integer numberSeats) {
		this.numberSeats = numberSeats;
	}

	public Boolean getFree() {
		return free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", driverId=" + driverId + ", comfortLevel=" + comfortLevel
				+ ", numberSeats=" + numberSeats + ", free=" + free + "]";
	}

}
