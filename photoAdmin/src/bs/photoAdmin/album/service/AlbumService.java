package bs.photoAdmin.album.service;

import java.util.List;

import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserInfo;

public interface AlbumService {
	//创建相册
	public boolean addAlbum(UserInfo u,AlbumInfo albumInfo, TagInfo tagInfo);
	//删除相册
	public boolean deleteAlbum(UserInfo u,int[] albums);
	//更新相册
	public boolean updateAlbum(AlbumInfo albumInfo);
	//更新相册2
	public boolean updateAlbum2(AlbumInfo albumInfo, boolean ifModify);
	//查找相册byId
	public AlbumInfo queryAlbumById(Integer albumId);
	//显示所有相册
	public List<AlbumInfo> listAllAlbum(UserInfo u);
	//添加userHasAlbum纪录
	public boolean addUserHasAlbum(AlbumInfo albumInfo, int[] userIds);
}
