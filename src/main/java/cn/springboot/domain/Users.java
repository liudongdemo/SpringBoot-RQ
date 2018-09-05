package cn.springboot.domain;

public class Users {
	private int id;
	private String userNam;
	private String passWor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserNam() {
		return userNam;
	}
	public void setUserNam(String userNam) {
		this.userNam = userNam;
	}
	public String getPassWor() {
		return passWor;
	}
	public void setPassWor(String passWor) {
		this.passWor = passWor;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userNam=" + userNam + ", passWor=" + passWor + "]";
	}
	
	
}
