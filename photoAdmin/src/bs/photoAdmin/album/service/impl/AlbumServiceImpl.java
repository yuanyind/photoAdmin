package bs.photoAdmin.album.service.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Action;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import bs.photoAdmin.album.service.AlbumService;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserHasAlbumInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.user.dao.UserDao;
import bs.photoAdmin.album.dao.AlbumDao;

public class AlbumServiceImpl implements AlbumService {
	
	private AlbumDao albumDao;
	private UserDao userDao;
	
	
	public AlbumDao getAlbumDao() {
		return albumDao;
	}
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//创建相册
	public boolean addAlbum(UserInfo u, AlbumInfo albumInfo, TagInfo tagInfo){
		try{
			UserHasAlbumInfo uhaInfo=new UserHasAlbumInfo();
			
			albumDao.addAlbum(albumInfo);
			albumDao.addUserHasAlbum(uhaInfo);
			
			uhaInfo.setAlbumInfo(albumInfo);
			uhaInfo.setUserInfo(u);
			
			albumInfo.setTagInfo(tagInfo);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			albumInfo.setACreatetime(time);
			albumInfo.setANumber(0);
			
			albumDao.updateAlbum(albumInfo);
			albumDao.updateUserHasAlbum(uhaInfo);
			
			return true;
		}catch(Exception e){
			return false;
		}
		
		
		
		
	}
	//删除相册
	public boolean deleteAlbum(UserInfo u, int[] albums){
		try{
			for(int i=0;i<albums.length;i++){
				AlbumInfo albumInfo=albumDao.queryAlbumById(albums[i]);
				UserHasAlbumInfo uhaInfo=albumDao.getUserHasAlbumInfo(u, albumInfo);
				albumDao.deleteUserHasAlbum(uhaInfo);
				
				}
			}catch(Exception e){
				return false;
				
		}
		return true;
	}
	//更新相册
	public boolean updateAlbum(AlbumInfo albumInfo){
		try{
			albumDao.updateAlbum(albumInfo);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//更新相册2
	public boolean updateAlbum2(AlbumInfo albumInfo, boolean ifModify){
		try{
			albumDao.updateAlbum2(albumInfo,ifModify);
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//查找相册byId
	public AlbumInfo queryAlbumById(Integer albumId){
		return albumDao.queryAlbumById(albumId);
	}
	//显示所有相册
	public List<AlbumInfo> listAllAlbum(UserInfo u){
		return albumDao.listAllAlbum(u);
	}
	//添加userHasAlbum纪录
	public boolean addUserHasAlbum(AlbumInfo albumInfo, int[] userIds){
		try{
			for(int i=0;i<userIds.length;i++){
				UserInfo userInfo= userDao.queryById(userIds[i]);  //获取共享用户userInfo
				UserHasAlbumInfo uhaInfo=new UserHasAlbumInfo(); 
				albumDao.addUserHasAlbum(uhaInfo);
				uhaInfo.setAlbumInfo(albumInfo);
				uhaInfo.setUserInfo(userInfo);
				albumDao.updateUserHasAlbum(uhaInfo);
				}
			return true;
			}catch(Exception e){
				return false;		
		}
	}
}
