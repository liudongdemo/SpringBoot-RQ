package cn.springboot.domain;

public class ServiceStation {
	private int id;
	private String userNa;
	private String core;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNa() {
		return userNa;
	}

	public void setUserNa(String userNa) {
		this.userNa = userNa;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	@Override
	public String toString() {
		return "服务站 [id=" + id + ", userNa=" + userNa + ", core=" + core + "]";
	}
	
}
