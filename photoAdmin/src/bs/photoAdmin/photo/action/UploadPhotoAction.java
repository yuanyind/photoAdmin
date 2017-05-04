package bs.photoAdmin.photo.action;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import bs.photoAdmin.album.service.AlbumService;
import bs.photoAdmin.model.AlbumInfo;
import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.photo.service.PhotoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 使用List上传多个文件
 * 
 *
 *
 */
@SuppressWarnings("serial")
public class UploadPhotoAction extends ActionSupport {
    private List<File> image; // 上传的文件
    private List<String> imageFileName; // 文件名称
    private List<String> imageContentType; // 文件类型
    private String savePath;
    
    private PhotoService photoService; 
    private PhotoInfo photoInfo;
    private Integer albumId;
    private AlbumInfo albumInfo;
    private AlbumService albumService;
    
    public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	
	public PhotoInfo getPhotoInfo() {
		return photoInfo;
	}

	public void setPhotoInfo(PhotoInfo photoInfo) {
		this.photoInfo = photoInfo;
	}
	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	
	public AlbumInfo getAlbumInfo() {
		return albumInfo;
	}

	public void setAlbumInfo(AlbumInfo albumInfo) {
		this.albumInfo = albumInfo;
	}

	public AlbumService getAlbumService() {
		return albumService;
	}

	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	@Override
	//上传相片
    public String execute() throws Exception {
		UserInfo u = (UserInfo) ActionContext.getContext().getSession().get("u");
        ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
        // 取得需要上传的文件数组
        List<File> files = getImage();
        if (files != null && files.size() > 0) {
            for (int i = 0; i < files.size(); i++) {
            	//用当前时间命名文件，避免重复
            	Date now=new Date();
            	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
                
            	FileOutputStream fos = new FileOutputStream(getSavePath() + "/" +sdf.format(now)+getImageFileName().get(i));
                FileInputStream fis = new FileInputStream(files.get(i));
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                    
                }
                
                photoService.uploadPhoto(u,albumId,sdf.format(now) + getImageFileName().get(i));
                albumInfo=albumService.queryAlbumById(albumId);
                albumInfo.setANumber(albumInfo.getPhotoInfos().size());
                albumService.updateAlbum(albumInfo);
                
                //尝试图片主色
                getMainColor(getSavePath() + "/" +sdf.format(now)+getImageFileName().get(i),sdf.format(now)+getImageFileName().get(i));
                
                
                fis.close();
                fos.close();
            }
        }
        return SUCCESS;
    }

    public List<File> getImage() {
        return image;
    }

    public void setImage(List<File> image) {
        this.image = image;
    }

    public List<String> getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(List<String> imageFileName) {
        this.imageFileName = imageFileName;
    }

    public List<String> getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(List<String> imageContentType) {
        this.imageContentType = imageContentType;
    }

    /**
     * 返回上传文件保存的位置
     * 
     * @return
     * @throws Exception
     */
    public String getSavePath() throws Exception {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    
    //分析主颜色
    public void getMainColor(String photoPath,String pPathname) throws Exception{
    	/*设置颜色查找表  1R2G3B*/
    	int[][] c=new int[16][3];
    	/*黑色*/
    	c[0][0]=0;
    	c[0][1]=0;
    	c[0][2]=0;
    	/*灰*/
    	c[1][0]=143;
    	c[1][1]=143;
    	c[1][2]=143;
    	/*白色*/
    	c[2][0]=255;
    	c[2][1]=255;
    	c[2][2]=255;
    	/*橄榄绿*/
    	c[3][0]=36;
    	c[3][1]=73;
    	c[3][2]=0;
    	/*海绿色*/
    	c[4][0]=0;
    	c[4][1]=182;
    	c[4][2]=0;
    	/*粉绿色*/
    	c[5][0]=182;
    	c[5][1]=255;
    	c[5][2]=170;
    	/*浅蓝色*/
    	c[6][0]=128;
    	c[6][1]=225;
    	c[6][2]=225;
    	/*深蓝色*/
    	c[7][0]=0;
    	c[7][1]=128;
    	c[7][2]=255;
    	/*蓝紫色*/
    	c[8][0]=73;
    	c[8][1]=36;
    	c[8][2]=170;
    	/*紫色*/
    	c[9][0]=146;
    	c[9][1]=0;
    	c[9][2]=170;
    	/*粉色*/
    	c[10][0]=255;
    	c[10][1]=157;
    	c[10][2]=200;
    	/*红色*/
    	c[11][0]=182;
    	c[11][1]=0;
    	c[11][2]=0;
    	/*褐色*/
    	c[12][0]=109;
    	c[12][1]=36;
    	c[12][2]=0;
    	/*土黄绿*/
    	c[13][0]=146;
    	c[13][1]=109;
    	c[13][2]=0;
    	/*橙色*/
    	c[14][0]=255;
    	c[14][1]=146;
    	c[14][2]=0;
    	/*黄色*/
    	c[15][0]=255;
    	c[15][1]=255;
    	c[15][2]=0;
    	
    	
    	/*尝试像素*/
        
        FileInputStream fc=new FileInputStream(photoPath);
        BufferedImage bufferImage=ImageIO.read(fc);
        
        double min=1000000000;		//设置最小值
        int index=0;				//最接近颜色表下标值
        int[] p=new int[16];		//纪录像素数目
        for(int j=0;j<16;j++){		//数组初始化
        	p[j]=0;
        }
        
        int width=bufferImage.getWidth();
        int height=bufferImage.getHeight();
        int[][] result=new int[height][width];
        for (int h=0;h<height;h++){
        	for(int w=0;w<width;w++){
        		min=1000000000;
        		result[h][w]=bufferImage.getRGB(w, h)&0xFFFFFF;
        		Color color=new Color(result[h][w]);
        		for(int i=0;i<16;i++){
        			double d=Math.sqrt((Math.pow((color.getRed()-c[i][0]), 2)+
        								Math.pow((color.getGreen()-c[i][1]), 2)+
        								Math.pow((color.getBlue()-c[i][2]), 2)));
        			if(d<min){
        				min=d;
        				index=i;
        			}
        		}
        		p[index]=p[index]+1;
        	}
        }
        for(int j=0;j<16;j++){		//数组初始化
        	System.out.print("\n"+j+":"+p[j]);
        }
        int max1=0;
        int max2=0;
        //频率最大值
        for(int n=0;n<16;n++){
        	if(p[max1]<p[n]){
        		max1=n;
        	}
        }
        //频率第二大
        for(int n=0;n<16;n++){
        	if(max2==max1){		//防止0为最大值
        		max2++;
        	}
        	if(p[max2]<p[n]){
        		if(n!=max1){
        			max2=n;
        		}
        	}
        }
        PhotoInfo photoInfo=photoService.queryPhotoByPath(pPathname);
        
        float max1p=100*p[max1]/(width*height);
        float max2p=100*p[max2]/(width*height);
        
        photoInfo.setPMainc1(max1);
        photoInfo.setPMainc2(max2);
        photoInfo.setPMainc1p(max1p);
        photoInfo.setPMainc2p(max2p);
        
        photoService.updatePhoto(photoInfo);
        
        
        fc.close();
        /*尝试结束*/
    }

}