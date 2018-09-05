package cn.springboot.domain;

public class AccessToken {
	private String token;
	private int ExpiresIn;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return ExpiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		ExpiresIn = expiresIn;
	}
	

}
