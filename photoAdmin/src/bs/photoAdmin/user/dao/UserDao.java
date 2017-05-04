package bs.photoAdmin.user.dao;

import java.util.List;

import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;

public interface UserDao {
	//用户注册	
	public void registerUser(UserInfo userInfo);
	//用户注销
	public void logoffUser(UserInfo userInfo);
	//更新用户
	public UserInfo updateUser(UserInfo user);
	//登陆验证
	public UserInfo checkUser(UserInfo user);
	//查询用户byID
	public UserInfo queryById(int userId);
	//查询用户byName
	public UserInfo queryByName(String userName);
	//查询用户byNickname
	public List<UserInfo> queryByNickname(String userNickname);
	//查询用户byEmail
	public UserInfo queryByEmail(String userEmail);
	
	//新建头像
	public void addIcon(UsericonInfo iconInfo);
	//修改头像
	public void updateIcon(UsericonInfo iconInfo);
	//查找头像byId
	public UsericonInfo queryIconById(Integer iconId);
	//查找头像byUser
	public UsericonInfo queryIconByUser(UserInfo userInfo);
	//获得所有头像
	public List<UsericonInfo> queryIcons();
}
