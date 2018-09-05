package cn.springboot.domain;

public class CZRY {
	private String czry_dm;
	private String czry_mc;
	public String getCzry_dm() {
		return czry_dm;
	}
	public void setCzry_dm(String czry_dm) {
		this.czry_dm = czry_dm;
	}
	public String getCzry_mc() {
		return czry_mc;
	}
	public void setCzry_mc(String czry_mc) {
		this.czry_mc = czry_mc;
	}
	@Override
	public String toString() {
		return "操作人员 [czry_dm=" + czry_dm + ", czry_mc=" + czry_mc + "]";
	}
	

}
