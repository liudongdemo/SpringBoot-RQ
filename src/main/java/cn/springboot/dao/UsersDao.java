package cn.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.springboot.domain.CZRY;
import cn.springboot.domain.Pt_dm_zzjg;
import cn.springboot.domain.ServiceStation;
import cn.springboot.domain.Users;

@Mapper
public interface UsersDao {

	public List<Pt_dm_zzjg> selectAll(Map<String, Object> map);
	public List<CZRY> selectByJbdm(Map<String, Object> map);

	/*public int insertServiceStation(Map<String, Object> map);*/
	

}
