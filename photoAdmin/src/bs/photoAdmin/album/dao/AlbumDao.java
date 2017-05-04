package bs.photoAdmin.album.dao;

import java.util.List;

import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserHasAlbumInfo;
import bs.photoAdmin.model.UserInfo;

public interface AlbumDao {
	//创建相册
	public void addAlbum(AlbumInfo album);
	//删除相册
	public void deleteAlbum(AlbumInfo album);
	//更新相册
	public void updateAlbum(AlbumInfo album);
	//更新相册2
	public void updateAlbum2(AlbumInfo album, boolean ifModify);
	//查找相册byName
	public List<AlbumInfo> queryAlbumInfoByName(Integer aId, String albumName);
	//查找相册byId
	public AlbumInfo queryAlbumById(int aId);
	//查找相册byTag
	public List<AlbumInfo> queryAlbumByTag(TagInfo tagInfo);
	//显示所有相册
	public List<AlbumInfo> listAllAlbum(UserInfo userInfo);
	//获得用户初始化相册的id
	public AlbumInfo getIniAlbumId(UserInfo userInfo);
	//通过user和album查找userHasAlbum表
	public UserHasAlbumInfo getUserHasAlbumInfo(UserInfo u, AlbumInfo albumInfo);
	//通过user查uha表
	public List<UserHasAlbumInfo> queryUhaByUser(UserInfo u);
	//创建相册用户关系表
	public void addUserHasAlbum(UserHasAlbumInfo uhaInfo);
	//删除相册用户关系表
	public void deleteUserHasAlbum(UserHasAlbumInfo uhaInfo);
	//更新相册用户关系表
	public void updateUserHasAlbum(UserHasAlbumInfo uhaInfo);
}
