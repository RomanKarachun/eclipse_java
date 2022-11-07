package by.grsu.rkarachun.tsm.db.model;

public class Car {
	private Integer id;
	
	private Integer numberId;

	private Integer ownerId;

	private String comfortLevel;

	private Integer numberSeats;
	
	private Boolean free;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberId() {
		return numberId;
	}

	public void setNumberId(Integer numberId) {
		this.numberId = numberId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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
		return "Car [id=" + id + ", numberId=" + numberId + ", ownerId=" + ownerId + ", comfortLevel=" + comfortLevel
				+ ", numberSeats=" + numberSeats + ", free=" + free + "]";
	}


	

}
