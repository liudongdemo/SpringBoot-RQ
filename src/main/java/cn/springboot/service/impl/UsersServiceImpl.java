package cn.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springboot.dao.UsersDao;
import cn.springboot.domain.CZRY;
import cn.springboot.domain.ServiceStation;
import cn.springboot.domain.Users;
import cn.springboot.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;

	@Override
	public List<cn.springboot.domain.Pt_dm_zzjg> selectAll(String zzjg) {
		Map<String, Object> map = new HashMap<>();
		map.put("zzjg_dm", zzjg);
		return usersDao.selectAll(map);
	}

	@Override
	public List<CZRY> selectByJbdm(String jbdm) {
		Map<String, Object> map = new HashMap<>();
		map.put("JBDM", jbdm);
		return usersDao.selectByJbdm(map);
	}

	/*@Override
	public int insertServiceStation(String userNa, String core) {
		Map<String, Object> map = new HashMap<>();
		map.put("userNa", userNa);
		map.put("core", core);
		int i= usersDao.insertServiceStation(map);
		return i;
	}*/

}
