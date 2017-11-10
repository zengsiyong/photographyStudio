package com.zengsy.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 该类中有一个MultipartFile类型的属性，用于接收上传文件的注入
 * Created by xlc on 2017-10-21.
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
    //public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
    //    InputStream is =null;
    //    try {
    //        DiskFileItemFactory factory = new DiskFileItemFactory();
    //        ServletFileUpload upload = new ServletFileUpload(factory);
    //        // 设置上传文件的大小限制为10M
    //        factory.setSizeThreshold(1024 * 10240);
    //
    //        List items = upload.parseRequest(request);
    //        Iterator iter = items.iterator();
    //        while (iter.hasNext()) {
    //            FileItem item = (FileItem) iter.next();
    //            if (!item.isFormField()) {
    //                // item.getInputStream() 获取上传文件的输入流
    //                is = item.getInputStream();
    //            } else {
    //                String paramName = item.getFieldName();
    //                String paramValue = item.getString();
    //                paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");
    //                params.put(paramName, paramValue);
    //            }
    //        }
    //
    //
    //
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //    return is;
    //}
}
