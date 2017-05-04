package bs.photoAdmin.photo.service;

import java.util.List;

import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;


public interface PhotoService {
	//上传图片
	public PhotoInfo uploadPhoto(UserInfo u, Integer albumId,String str);
	//更新相片
	public boolean updatePhoto(PhotoInfo photoInfo);
	//显示图片
	public List<PhotoInfo> showPhotos(AlbumInfo albumInfo);
	//查找图片byId
	public PhotoInfo queryPhotoById(Integer id);
	//查找图片byD
	public List<PhotoInfo> queryPhotoByD(UserInfo u, String searchCon);
	//查找album
	public List<AlbumInfo> queryAlbum(UserInfo u, String searchCon);
	//显示图片byTime
	public List<PhotoInfo> listPhotoByTime(UserInfo userInfo);
	//显示图片byUser
	public List<PhotoInfo> listPhotoByUser(UserInfo userInfo);
	//查找图片byPath
	public PhotoInfo queryPhotoByPath(String pPath);
	//查找图片byColor
	public List<PhotoInfo> queryPhotoByColor(Integer colorNo);
}
