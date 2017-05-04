package bs.photoAdmin.user.service;

import java.util.List;

import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;


public interface UserService {
	//用户注册
	public boolean RegisterUser(UserInfo userInfo);
	//用户注销
	public boolean LogoffUser(int userId);
	//用户信息更新
	public UserInfo updateUser(UserInfo userInfo);
	//登陆验证
	public UserInfo checkUser(UserInfo userInfo);
	//查询用户byID
	public UserInfo queryById(int userId);
	//查询用户byNickame
	public List<UserInfo> queryByNickname(String userNickname);
	//查询用户byName
	public UserInfo queryByName(String userName);
	//查询用户byEmail
	public UserInfo queryByEmail(String userEmail);
	
	//上传头像
	public UsericonInfo uploadIcon(UserInfo u,String str);
	//更新头像
	public boolean updateIcon(UsericonInfo iconInfo);
	//查找头像byId
	public UsericonInfo queryIconById(Integer id);
	//查找头像byUser
	public UsericonInfo queryIconByUser(UserInfo u);
	//获得所有头像
	public List<UsericonInfo> queryIcons();
}
