package com.yuan.farmerwork.ynblog.rest.admin;

import com.yuan.farmerwork.ynblog.domain.Blog;
import com.yuan.farmerwork.ynblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * 下载md文件.
 *
 * @author : YJS
 * @date: 2020-11-10 11:21
 */
@RestController
@RequestMapping("/download")
public class MdDownloadController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/series/{seriesCode}")
    public void downMdByseriesCode(@PathVariable String seriesCode,HttpServletResponse response) throws UnsupportedEncodingException {
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("series_code",seriesCode);
        List<Blog> blogs = blogService.listByMap(queryMap);
        StringBuilder sb = new StringBuilder("# ");
        String content = "";
        if(blogs.isEmpty()){
            content = sb.append("无数据!").toString();
         }else if(blogs.size()==1){
            content = sb.append(blogs.get(0).getTitle().trim()).append("\n").append(blogs.get(0).getTextContent()).toString();
        }else{
            blogs.stream().map(x->{
               sb.append(x.getTitle().trim()).append("\n").append(x.getTextContent()).append("\n# ");
              return x;
            }).collect(Collectors.toList());
            content  = sb.substring(0, sb.length() - 1);
        }
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String((new Date().getTime()+".md").getBytes(), "iso-8859-1"));
        try {
            OutputStreamWriter write = new OutputStreamWriter(response.getOutputStream(), "utf-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
