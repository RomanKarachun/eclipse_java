package by.grsu.rkarachun.tsm.db.model;

public class Client {
	private Integer id;

	private String clientName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientName=" + clientName + "]";
	}

}
