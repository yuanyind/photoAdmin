package bs.photoAdmin.user.service.impl;

import java.sql.Timestamp;
import java.util.List;




















import bs.photoAdmin.album.dao.AlbumDao;
import bs.photoAdmin.friend.dao.FriendDao;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.FgroupInfo;
import bs.photoAdmin.model.UserHasAlbumInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.model.UsericonInfo;
import bs.photoAdmin.user.dao.UserDao;
import bs.photoAdmin.user.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private FriendDao friendDao;
	private AlbumDao albumDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	public AlbumDao getAlbumDao() {
		return albumDao;
	}

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	//用户注册
	public boolean RegisterUser(UserInfo userInfo){
		try {
			System.out.print("\n1");
			Timestamp time = new Timestamp(System.currentTimeMillis());
			userInfo.setUserCreatetime(time);
			System.out.print("\n2");
			userDao.registerUser(userInfo);
			
			System.out.print("\n3");
			FgroupInfo fgroupInfo=new FgroupInfo();
			System.out.print("\n4");
			fgroupInfo.setFgName("moren");
			System.out.print("\n5");
			fgroupInfo.setUserInfo(userInfo);
			System.out.print("\n6");
			friendDao.addFgroup(fgroupInfo);
						
			System.out.print("\n8");
			AlbumInfo albumInfo=new AlbumInfo();
			System.out.print("\n9");
			albumInfo.setAName("moren");
			System.out.print("\n10");
			albumInfo.setUserInfo(userInfo);
			albumInfo.setANumber(0);
			System.out.print("\n11");
			albumDao.addAlbum(albumInfo);
			
			System.out.print("\n13");
			UserHasAlbumInfo userHasAlbumInfo=new UserHasAlbumInfo();
			System.out.print("\n14");
			userHasAlbumInfo.setAlbumInfo(albumInfo);
			System.out.print("\n15");
			userHasAlbumInfo.setUserInfo(userInfo);
			System.out.print("\n16");
			albumDao.addUserHasAlbum(userHasAlbumInfo);
			
			UsericonInfo userIcon=new UsericonInfo();
			userIcon.setIconCreatetime(time);
			userIcon.setIconImage("person.jpg");
			userIcon.setUserInfo(userInfo);
			userDao.addIcon(userIcon);
			
			System.out.print("\n17");
			
		} catch (Exception e) {
			System.out.print("sf\n");
			return false;
		}
		
		return true;
	}
	//用户注销
	public boolean LogoffUser(int userId){
		UserInfo userInfo = userDao.queryById(userId);
		try{
			
			userDao.logoffUser(userInfo);
			
		}catch(Exception e){
			
			return false;
		}
		return true;
	}
	//用户信息更新
	public UserInfo updateUser(UserInfo userInfo){
		System.out.print("\nupdateid:");
		int i=userInfo.getUserId();
		
		System.out.print(i);
		UserInfo u=userDao.queryById(userInfo.getUserId());
		
		u.setUserCity(userInfo.getUserCity());
		u.setUserProvince(userInfo.getUserProvince());
		u.setUserNickname(userInfo.getUserNickname());
		u.setUserPhone(userInfo.getUserPhone());
		UserInfo u1 = userDao.updateUser(u);
		return u1;
		
	}
	//登陆验证
	public UserInfo checkUser(UserInfo user){
		UserInfo u=userDao.checkUser(user);
		return u;
	}
	//查询用户byID
	public UserInfo queryById(int userId){
		System.out.print("\nserqueryId:"+userId);
		return userDao.queryById(userId);
	}
	//查询用户byNickname
	public List<UserInfo> queryByNickname(String userNickname){
		return userDao.queryByNickname(userNickname);
	}
	//查询用户byEmail
	public UserInfo queryByEmail(String userEmail){
		return userDao.queryByEmail(userEmail);
	}
	//查询用户byName
		public UserInfo queryByName(String userName){
			return userDao.queryByName(userName);
	}
		
	//上传头像
	public UsericonInfo uploadIcon(UserInfo u, String str){
		UsericonInfo userIcon=userDao.queryIconByUser(u);
		
		Timestamp time = new Timestamp(System.currentTimeMillis());	
		userIcon.setIconCreatetime(time);
		userIcon.setIconImage(str);
		System.out.print("\nid:"+u.getUserId());
		System.out.print("\nstr:"+str);
		userIcon.setUserInfo(u);
		System.out.print("\nuiconu:");
		userDao.updateIcon(userIcon);
		return userIcon;
	}
	//更新头像
	public boolean updateIcon(UsericonInfo iconInfo){
		try{
			userDao.updateIcon(iconInfo);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	//查找头像byId
	public UsericonInfo queryIconById(Integer id){
		return userDao.queryIconById(id);
	}
	//查找头像byUser
	public UsericonInfo queryIconByUser(UserInfo u){
		return userDao.queryIconByUser(u);
	}
	
	//获得所有头像
	public List<UsericonInfo> queryIcons(){
		return userDao.queryIcons();
	}
}
