package com.yuan.farmerwork.ynblog.rest;

import com.yuan.farmerwork.ynblog.domain.YnItems;
import com.yuan.farmerwork.ynblog.domain.YnItemsDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.ItemClassfy;
import com.yuan.farmerwork.ynblog.domain.pojo.ItemsTitles;
import com.yuan.farmerwork.ynblog.service.YnItemsDetailsService;
import com.yuan.farmerwork.ynblog.service.YnItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目控制器.
 *
 * @author : YJS
 * @date: 2020-11-23 14:00
 */
@Controller
public class ProjectsController {

    @Autowired
    YnItemsService ynItemsService;

    @Autowired
    YnItemsDetailsService ynItemsDetailsService;

    /*
     * 项目页面
     */
    @GetMapping("/projects")
    public ModelAndView blogDetails(Map map) {
        List<ItemClassfy> itemClassfies = new ArrayList<>();
        List<YnItems> ynItems = ynItemsService.list();
        Map<String, List<YnItems>> retrunItemMap = ynItems.stream()
                .collect(Collectors.groupingBy(YnItems::getItemClassfyName));
        retrunItemMap.entrySet().stream()
                .map(x -> {
                    ItemClassfy itemClassfy = new ItemClassfy();
                    itemClassfy.setYnItems(x.getValue());
                    itemClassfy.setItemClassfyName(x.getKey());
                    itemClassfies.add(itemClassfy);
                    return x;
                }).count();
        map.put("itemClassfies", itemClassfies);
        return new ModelAndView("projects", map);
    }


    @GetMapping("/itemsdtails/{itemsId}")
    public ModelAndView testDtails(@PathVariable Long itemsId, Map map) {
        //获取目录
        List<ItemsTitles> itemsTitles = ynItemsDetailsService.findItemsTitlesByItmsId(itemsId);
        if (!itemsTitles.isEmpty()) {
            map.put("itemName", itemsTitles.get(0).getItemsName());
            map.put("itemsId", itemsId);
            Long firstId = itemsTitles.get(0).getId();
            itemsTitles = itemsTitles.stream().map(x ->{
                if(x.getId()==firstId){
                    x.setType(" -current");
                }
                return x;
            }).collect(Collectors.toList());
            //获取内容
            YnItemsDetails itemsDtails = ynItemsDetailsService.getById(firstId);
            map.put("detailsContent", itemsDtails);
        }
        map.put("itemsTitles", itemsTitles);
        return new ModelAndView("itemsdetails", map);
    }

    @GetMapping("/itemsdtails/{itemsId}/{id}")
    public ModelAndView testDtails(@PathVariable Long itemsId, @PathVariable Long id, Map map) {
        //获取目录
        List<ItemsTitles> itemsTitles = ynItemsDetailsService.findItemsTitlesByItmsId(itemsId);
        if (!itemsTitles.isEmpty()) {
            map.put("itemName", itemsTitles.get(0).getItemsName());
            map.put("itemsId", itemsId);
            itemsTitles = itemsTitles.stream().map(x ->{
                if(x.getId()==id){
                    x.setType(" -current");
                }
                return x;
            }).collect(Collectors.toList());
            //获取内容
            YnItemsDetails itemsDtails = ynItemsDetailsService.getById(id);
            map.put("detailsContent", itemsDtails);
        }
        map.put("itemsTitles", itemsTitles);
        return new ModelAndView("itemsdetails", map);
    }
}
