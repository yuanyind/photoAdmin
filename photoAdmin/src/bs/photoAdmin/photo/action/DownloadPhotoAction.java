package bs.photoAdmin.photo.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class DownloadPhotoAction {
	  
    // 传递一个List<String>()对象传值路径合集  
    private String[] downLoadPaths;  
    private OutputStream res;  
    private ZipOutputStream zos;  
    private String outPath;  
    
    
   //下载相片
    public String downLoadZip() throws Exception {  
        // 有数据可以下载  
        if (downLoadPaths.length != 0) {  
            // 进行预处理  
            preProcess();  
        } else {  
            // 没有文件可以下载，返回nodata  
            return "nodata";  
        }  
        // 处理  
        writeZip(downLoadPaths);  
        // 后处理关闭流  
        afterProcess();  
        return "success";  
    }  
  
    // 压缩处理  
    public void writeZip(String[] downLoadPaths) throws IOException {  
        byte[] buf = new byte[8192];  
        int len;  
          
        for (String filename : downLoadPaths) {  
            File file = new File(filename);  
            if (!file.isFile())  
                continue;  
            ZipEntry ze = new ZipEntry(file.getName()); //apache jar的ZipEntry  
            zos.putNextEntry(ze);  
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));  
            while ((len = bis.read(buf)) > 0) {  
                zos.write(buf, 0, len);  
            }  
            bis.close();  
            zos.closeEntry();  
        }  
    }  
  
    // 预处理  
    public void preProcess() throws Exception {  
        HttpServletResponse response = ServletActionContext.getResponse();  
        res = response.getOutputStream();  
        // 清空输出流(在迅雷下载不会出现一长窜)  
        response.reset();  
        // 设定输出文件头  
        response.setHeader("Content-Disposition", "attachment;filename=document.zip");  
        response.setContentType("application/zip");  
        zos = new ZipOutputStream(res);  
    }  
  
    // 后处理  
    public void afterProcess() throws IOException {  
  
        zos.close();  
        res.close();  
    }  
  
    public OutputStream getRes() {  
        return res;  
    }  
  
    public void setRes(OutputStream res) {  
        this.res = res;  
    }  
  
    public ZipOutputStream getZos() {  
        return zos;  
    }  
  
    public void setZos(ZipOutputStream zos) {  
        this.zos = zos;  
    }  
  
    public String[] getDownLoadPaths() {  
        return downLoadPaths;  
    }  
  
    public void setDownLoadPaths(String[] downLoadPaths) {  
        this.downLoadPaths = downLoadPaths;  
    }  
  
    public String getOutPath() {  
        return outPath;  
    }  
  
    public void setOutPath(String outPath) {  
        this.outPath = outPath;  
    }  
  
}  