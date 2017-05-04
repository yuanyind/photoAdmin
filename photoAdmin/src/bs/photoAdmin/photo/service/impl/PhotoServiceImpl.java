package bs.photoAdmin.photo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import bs.photoAdmin.album.dao.AlbumDao;
import bs.photoAdmin.friend.dao.FriendDao;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.FriendInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.TagInfo;
import bs.photoAdmin.model.UserHasAlbumInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.photo.dao.PhotoDao;
import bs.photoAdmin.photo.service.PhotoService;
import bs.photoAdmin.tag.dao.TagDao;

public class PhotoServiceImpl implements PhotoService{
	private PhotoDao photoDao;
	private AlbumDao albumDao;
	private TagDao tagDao;
	private FriendDao friendDao;
	
	public PhotoDao getPhotoDao() {
		return photoDao;
	}
	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}
	public AlbumDao getAlbumDao() {
		return albumDao;
	}
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	public TagDao getTagDao() {
		return tagDao;
	}
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	public FriendDao getFriendDao() {
		return friendDao;
	}
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}
	//上传图片
	public PhotoInfo uploadPhoto(UserInfo u, Integer albumId,String str){
		
		PhotoInfo photoInfo=new PhotoInfo();
		
		Timestamp time = new Timestamp(System.currentTimeMillis());	

		AlbumInfo albumInfo=albumDao.queryAlbumById(albumId);
		 
		photoInfo.setUserInfo(u);
		photoInfo.setAlbumInfo(albumInfo);
		photoInfo.setPCreatetime(time);	
		photoInfo.setPPath(str);
		photoInfo.setPIfmodify(false);
		photoDao.addPhoto(photoInfo);
		return photoInfo;
	}
	//更新相片
	public boolean updatePhoto(PhotoInfo photoInfo){
		try{
			photoDao.updatePhoto(photoInfo);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	//显示图片
	public List<PhotoInfo> showPhotos(AlbumInfo albumInfo){
		return photoDao.showPhoto(albumInfo);
	}
	//查找图片byId
	public PhotoInfo queryPhotoById(Integer id){
		return photoDao.queryById(id);
	}
	//查找图片byDorTag
	public List<PhotoInfo> queryPhotoByD(UserInfo u, String searchCon){
		List<PhotoInfo> photos = new ArrayList<PhotoInfo>();
		
		List<TagInfo> tags=tagDao.getTagByName(searchCon);
		for(int i=0;i<tags.size();i++){
			photos.addAll(photoDao.queryByTag(tags.get(i)));
		}
		List<UserHasAlbumInfo> uhas=albumDao.queryUhaByUser(u);
		List<AlbumInfo> as=new ArrayList<AlbumInfo>();
		for(int j=0;j<uhas.size();j++){
			as.add(uhas.get(j).getAlbumInfo());
		}
		for(int n=0;n<as.size();n++){
			photos.addAll(photoDao.queryByD(as.get(n),searchCon));
		}
		
		HashSet<PhotoInfo> h= new LinkedHashSet<PhotoInfo>(photos);
		photos.clear();
		photos.addAll(h);
		
		return photos;
	}
	
	//查找album
	public List<AlbumInfo> queryAlbum(UserInfo u, String searchCon){
		List<AlbumInfo> albums=new ArrayList<AlbumInfo>();
		List<TagInfo> tags=tagDao.getTagByName(searchCon);
		for(int i=0;i<tags.size();i++){
			albums.addAll(albumDao.queryAlbumByTag(tags.get(i)));
		}
		
		List<UserHasAlbumInfo> uhas=albumDao.queryUhaByUser(u);
		List<Integer> aIds=new ArrayList<Integer>();
		for(int j=0;j<uhas.size();j++){
			aIds.add(uhas.get(j).getAlbumInfo().getAId());
		}
		for(int n=0;n<aIds.size();n++){
			albums.addAll(albumDao.queryAlbumInfoByName(aIds.get(n), searchCon));
		}
		
		HashSet<AlbumInfo> a= new LinkedHashSet<AlbumInfo>(albums);
		albums.clear();
		albums.addAll(a);
		
		return albums;
	}
	//显示图片byTime
	public List<PhotoInfo> listPhotoByTime(UserInfo userInfo){	
		List<PhotoInfo> ps=photoDao.listPhotoByTime();
		List<FriendInfo> fs=friendDao.listAllFriend(userInfo);
		List<UserInfo> friends=new ArrayList<UserInfo>();

		for(int i=0;i<fs.size();i++){
			friends.add(fs.get(i).getUserInfoByOtheruserId());
		}
		List<PhotoInfo> photos= new ArrayList<PhotoInfo>();
		for(int j=0;j<ps.size();j++){
			for(int q=0;q<friends.size();q++){
				if((ps.get(j).getUserInfo()).equals(friends.get(q))){
					photos.add(ps.get(j));
				}
			}
		}
		List<PhotoInfo> photoList=new ArrayList<PhotoInfo>();
		for(int n=photos.size()-1;n>0;n--){
			if((photos.get(n).getUserInfo()).equals(photos.get(n-1).getUserInfo())){
				if((photos.get(n).getAlbumInfo()).equals(photos.get(n-1).getAlbumInfo())){
					if((photos.get(n-1).getPCreatetime().getTime()
						-photos.get(n).getPCreatetime().getTime())/1000<60){
						photos.remove(photos.get(n));
					}
					
				}
			}
		}
		photoList.addAll(photos);
		return photoList;
	}
	//显示图片byUser
	public List<PhotoInfo> listPhotoByUser(UserInfo userInfo){
		List<PhotoInfo> ps=photoDao.listPhotoByTime();
		List<PhotoInfo> photos= new ArrayList<PhotoInfo>();
		for(int j=0;j<ps.size();j++){
			if((ps.get(j).getUserInfo()).equals(userInfo)){
				photos.add(ps.get(j));
				
			}
		}
		List<PhotoInfo> photoList=new ArrayList<PhotoInfo>();
		for(int n=photos.size()-1;n>0;n--){
			if((photos.get(n-1).getPCreatetime().getTime()-photos.get(n).getPCreatetime().getTime())/1000<60){
				photos.remove(photos.get(n));
			}
			
		}
		photoList.addAll(photos);
		return photoList;
	}
	//查找图片byPath
	public PhotoInfo queryPhotoByPath(String pPath){
		return photoDao.queryByPath(pPath); 
	}
	//查找图片byColor
	public List<PhotoInfo> queryPhotoByColor(Integer colorNo){
		return photoDao.queryByMainColor(colorNo);
	}
}
