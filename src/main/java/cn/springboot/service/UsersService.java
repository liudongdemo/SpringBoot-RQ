package cn.springboot.service;

import java.util.List;
import java.util.Map;

import cn.springboot.domain.CZRY;
import cn.springboot.domain.Pt_dm_zzjg;
import cn.springboot.domain.ServiceStation;
import cn.springboot.domain.Users;

public interface UsersService {

	public List<Pt_dm_zzjg> selectAll(String zzjg);
	public List<CZRY> selectByJbdm(String jbdm);

	/*public int insertServiceStation(String userNa, String core);*/

}
