package bs.photoAdmin.photo.dao;

import java.util.List;

import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;


public interface PhotoDao {
	//保存图片
	public void addPhoto(PhotoInfo photoInfo);
	//更新图片
	public void updatePhoto(PhotoInfo photoInfo);
	//显示照片
	public List<PhotoInfo> showPhoto(AlbumInfo albumInfo);
	//查找照片byId
	public PhotoInfo queryById(Integer PId);
	//查找照片byDes
	public List<PhotoInfo> queryByD(AlbumInfo albumInfo, String searchCon);
	//查找照片byTag
	public List<PhotoInfo> queryByTag(TagInfo tagInfo);
	//显示图片byTime
	public List<PhotoInfo> listPhotoByTime();
	//查找照片bypPath
	public PhotoInfo queryByPath(String pPath);
	//查找照片by主色
	public List<PhotoInfo> queryByMainColor(Integer colorNo);
}
