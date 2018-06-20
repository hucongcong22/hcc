package com.aifule.jxc.site.service;

import com.aifule.jxc.core.dao.mysql.PhotosMapper;
import com.aifule.jxc.core.domain.Photos;
import com.aifule.jxc.core.mybatispage.Page;
import com.aifule.jxc.site.common.util.FileUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LuenBoService {
    @Resource
    PhotosMapper photosMapper;

    /**
     * 添加
     *
     * @param
     * @return
     */


    public boolean insert(MultipartFile fileToUpload, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("ck/images/b");
        FileUtil fileUtil = new FileUtil();
        String wenjian = "b";
        wenjian += fileUtil.uploading(fileToUpload, rootPath);
        System.out.print(rootPath);
        Photos photos = new Photos();
        photos.setPhotoname(wenjian);
        int sd = photosMapper.insert(photos);
        if (sd != 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取所有
     *
     * @return
     */
    public List<Photos> allphotos() {
        List<Photos> photosList = photosMapper.selectsBySelective(new Photos(), new Page());
        return photosList;
    }

    /**
     * 删除
     *
     * @param photos
     * @return
     */
    public boolean delect(Photos photos) {
        int sd = photosMapper.deleteByPrimaryKey(photos.getPhotoid());
        if (sd != 0) {
            return true;
        }
        return false;
    }

}
