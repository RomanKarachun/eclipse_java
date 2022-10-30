package by.grsu.rkarachun.tsm.db.model;

public class client {
	private Integer id;

	private String client_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	@Override
	public String toString() {
		return "client [id=" + id + ", client_name=" + client_name + "]";
	}

}
