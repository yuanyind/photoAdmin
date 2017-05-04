package bs.photoAdmin.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import bs.photoAdmin.model.PhotoInfo;
import bs.photoAdmin.model.UserInfo;
import bs.photoAdmin.photo.service.PhotoService;
import bs.photoAdmin.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 使用List上传多个文件
 * 
 *
 *
 */
@SuppressWarnings("serial")
public class UserIconAction extends ActionSupport {
    private List<File> image; // 上传的文件
    private List<String> imageFileName; // 文件名称
    private List<String> imageContentType; // 文件类型
    private String savePath;
    
    private UserService userService;
    private UserInfo userInfo;
    
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
    public String execute() throws Exception {
		boolean flag=userService.RegisterUser(userInfo);
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
                System.out.print(sdf.format(now));
                
                System.out.print("\nid:"+userInfo.getUserId());
                System.out.print("\n进入service");
                userService.uploadIcon(userInfo,sdf.format(now) + getImageFileName().get(i));
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

}