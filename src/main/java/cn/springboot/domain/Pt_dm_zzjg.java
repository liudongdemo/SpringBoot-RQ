package cn.springboot.domain;

public class Pt_dm_zzjg {
	private String ZZJG_MC;
	private String ZZJG_DM;
	private String JBDM;
	private String ZZJGLX_MC;
	private String ZZJGLX_DM;
	private String SJ_ZZJG_DM;
	public String getZZJG_MC() {
		return ZZJG_MC;
	}
	public void setZZJG_MC(String zZJG_MC) {
		ZZJG_MC = zZJG_MC;
	}
	public String getJBDM() {
		return JBDM;
	}
	public void setJBDM(String jBDM) {
		JBDM = jBDM;
	}
	public String getZZJGLX_MC() {
		return ZZJGLX_MC;
	}
	public void setZZJGLX_MC(String zZJGLX_MC) {
		ZZJGLX_MC = zZJGLX_MC;
	}
	public String getZZJG_DM() {
		return ZZJG_DM;
	}
	public void setZZJG_DM(String zZJG_DM) {
		ZZJG_DM = zZJG_DM;
	}
	public String getZZJGLX_DM() {
		return ZZJGLX_DM;
	}
	public void setZZJGLX_DM(String zZJGLX_DM) {
		ZZJGLX_DM = zZJGLX_DM;
	}
	
	public String getSJ_ZZJG_DM() {
		return SJ_ZZJG_DM;
	}
	public void setSJ_ZZJG_DM(String sJ_ZZJG_DM) {
		SJ_ZZJG_DM = sJ_ZZJG_DM;
	}
	@Override
	public String toString() {
		return "平台代码组织机构 [ZZJG_MC=" + ZZJG_MC + ", ZZJG_DM=" + ZZJG_DM + ", JBDM=" + JBDM + ", ZZJGLX_MC=" + ZZJGLX_MC
				+ "]";
	}
	

}
