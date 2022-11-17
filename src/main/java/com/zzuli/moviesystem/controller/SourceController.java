package com.zzuli.moviesystem.controller;


import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/source")
@Api(tags = "资源下载相关接口")
public class SourceController {

    @Value("${movieSystem.pictureUrl}")
    private String picBasePath;
    @Value("${movieSystem.movieUrl}")
    private String videoBasePath;

    private String picType="/image/jpeg";
    private String videoType="/video/mp4";

    /**
     * 图片上传
     * @param file  文件格式MultipartFile的文件
     * @return 封装文件名的result结果
     */
    @ApiOperation(value = "图片上传接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "MultipartFile图片文件",required = true,dataTypeClass = MultipartFile.class)
    })
    @PostMapping("/picUpload")
    public Result<String> picUpload(MultipartFile file){
        //file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
        String filename = upload(file, picBasePath);
        return Result.success(filename);
    }

    /**
     * 视频上传
     * @param file 文件格式MultipartFile的文件
     * @return 封装文件名的result结果
     */
    @ApiOperation(value = "视频上传接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "MultipartFile视频文件",required = true,dataTypeClass = MultipartFile.class)
    })
    @PostMapping("/videoUpload")
    public Result<String> videoUpload(MultipartFile file){
        String filename = upload(file, videoBasePath);
        return Result.success(filename);
    }

    /**
     * 图片下载
     * @param name 需要下载的文件名
     * @param response
     */
    @ApiOperation(value = "图片下载接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "图片文件名",required = true)
    })
    @GetMapping("/picDownload")
    public void picDownload(String name, HttpServletResponse response){
        downloadSource(name, response,picBasePath,picType);
    }

    /**
     * 视频下载
     * @param name 需要下载的文件名
     * @param response
     */
    @ApiOperation(value = "视频下载接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "视频文件名",required = true)
    })
    @GetMapping("/videoDownload")
    public void videoDownload(String name, HttpServletResponse response){
        downloadSource(name, response,videoBasePath,videoType);
    }

    /**
     * 上传方法
     * @param file 文件
     * @param basePath 保存基本路径
     * @return 文件名
     */
    private String upload(MultipartFile file, String basePath) {
        //file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
        log.info(file.toString());
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String filename = UUID.randomUUID().toString() + suffix;

        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            //将文件转存到指定位置
            file.transferTo(new File(basePath + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    /**
     * 下载方法
     * @param name 文件名
     * @param response
     * @param basePath 基本路径
     * @param type 文件类型
     */
    private void downloadSource(String name, HttpServletResponse response,String basePath,String type) {
        try {
            //输入流，通过输入流读取文件内容
            FileInputStream  fileInputStream=new FileInputStream(new File(basePath+ name));
            //输出流，通过输出流将文件写回浏览器，在浏览器中展示图片
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType(type);
            int len=0;
            byte[] bytes=new byte[1024];
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
