package com.aifule.jxc.site.web.controller;


import com.aifule.jxc.core.domain.Photos;
import com.aifule.jxc.site.service.LuenBoService;
import com.aifule.jxc.site.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LuenBoController extends WebController {
    @Resource
    LuenBoService luenBoService;


    /**
     * 所有的轮播图片
     *
     * @param photos
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/luenbo/all", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> allphotos(@RequestBody Photos photos, HttpSession httpSession) {
        List<Photos> photosList = luenBoService.allphotos();
        return getResultMap(photosList);
    }


    /**
     * 删除轮播图片
     *
     * @param photos
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/luenbo/delect", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delect(@RequestBody Photos photos, HttpSession httpSession) {
        boolean sd = luenBoService.delect(photos);
        return getResultMap(sd);
    }


    /**
     * 添加轮播图片
     *
     * @param fileToUpload
     * @param request
     * @return
     */
    @RequestMapping(value = "/luenbo/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestParam("file") MultipartFile fileToUpload, HttpServletRequest request) {
        boolean sd = luenBoService.insert(fileToUpload, request);
        return getResultMap(sd);
    }
}
