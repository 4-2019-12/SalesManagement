package com.xzit.salesmanagement.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {


    public static void deleteFile(String file){
        String fileName = file.substring(file.lastIndexOf("/")+1);  // 文件名
        File f=new File("E://java_wk//salesmanagement//src//main//resources//static//upload//costume_img//"+fileName);
        try {
            System.out.println(f.getCanonicalPath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Sorry,can't get canonical path");
        }
        try{
            f.delete();
        }
        catch(NullPointerException n){
            System.out.println("Sorry,No such file");
        }
    }

    @ResponseBody
    @RequestMapping("/fileupload")
    public JSONObject fileUpload(@RequestParam("fileName") MultipartFile file) {
        String result_msg = "";//上传结果信息
        JSONObject root = new JSONObject();
        if (file.isEmpty() || (file.getSize() / 1000 > 100)) {
            result_msg = "文件为空";
        } else {
            //判断格式
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            if (suffixName.equals(".png") || suffixName.equals(".jpg") || suffixName.equals(".gif")) {
//                String filePath = "E://temp-rainy//costume_img//"; // 上传后的路径
                String filePath = "E://java_wk//salesmanagement//src//main//resources//static//upload//costume_img//"; // 上传后的路径
                fileName = UUID.randomUUID() + suffixName; // 新文件名
                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filename = "/upload/costume_img/" + fileName;
                result_msg = "图片上传成功";
                root.put("filename", filename);
            } else {
                result_msg = "图片格式不正确";
            }
        }
        root.put("result_msg", result_msg);
        String root_json = JSON.toJSONString(root);
        System.out.println(root_json);
        return root;
    }

}
