package by.grsu.rkarachun.tsm.db.model;

public class car {
	private Integer id;

	private Integer owner_id;

	private String comfort_level;

	private Integer number_of_seats;
	
	private Boolean free;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public String getComfort_level() {
		return comfort_level;
	}

	public void setComfort_level(String comfort_level) {
		this.comfort_level = comfort_level;
	}

	public Integer getNumber_of_seats() {
		return number_of_seats;
	}

	public void setNumber_of_seats(Integer number_of_seats) {
		this.number_of_seats = number_of_seats;
	}

	public Boolean getFree() {
		return free;
	}

	public void setFree(Boolean i) {
		this.free = i;
	}

	@Override
	public String toString() {
		return "car [id=" + id + ", owner_id=" + owner_id + ", comfort_level=" + comfort_level + ", number_of_seats="
				+ number_of_seats + ", free=" + free + "]";
	}
}
