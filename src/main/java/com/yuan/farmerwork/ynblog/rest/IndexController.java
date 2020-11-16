package com.yuan.farmerwork.ynblog.rest;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.farmerwork.ynblog.domain.*;
import com.yuan.farmerwork.ynblog.domain.pojo.*;
import com.yuan.farmerwork.ynblog.service.*;
import javassist.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class IndexController {

    private static final List<String> COLO_LIST = Arrays.asList("Cyan", "DarkBlue", "DarkCyan", "DarkGoldenRod", "DarkGray"
            , "DarkGreen", "DarkKhaki", "DarkMagenta", "DarkOliveGreen", "Darkorange", "DarkOrchid", "DarkRed"
            , "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue", "DarkSlateGray", "DarkTurquoise", "DarkViolet"
            , "DeepPink", "DeepSkyBlue", "DimGray", "DodgerBlue", "Feldspar", "FireBrick", "Linen", "Magenta", "Maroon"
            , "MediumAquaMarine", "MediumBlue", "MediumOrchid", "MediumPurple", "MediumSeaGreen", "MediumSlateBlue"
            , "MediumSpringGreen", "MediumTurquoise", "MediumVioletRed", "MidnightBlue");

    @Autowired
    BlogService blogService;
    @Autowired
    TagService tagService;
    @Autowired
    SeriesService seriesService;
    @Autowired
    ClassifyService classifyService;
    @Autowired
    YnMianService ynMianService;
    @Autowired
    YnMainProjectsService ynMainProjectsService;
    @Autowired
    YnItemsService ynItemsService;

    @GetMapping("/")
    public ModelAndView getIndex(Map map) {
        //获取首页介绍
        List<YnMian> ynMians = ynMianService.list();
        map.put("ynMain", ynMians.get(0).getMainTitle());

        //获取服务介绍
        List<YnMainProjects> mainProjectsList = ynMainProjectsService.list();
        map.put("mainProjectsList", mainProjectsList);

        //获取阅读榜单
        List<Blogs> readList = blogService.findReadmList();
        map.put("readList", readList);

        return new ModelAndView("index", map);
    }

    @GetMapping("/haserror")
    public String error() {
        return "404";
    }

    /*
     * 添加标签，分类，系列页面
     */
    @GetMapping("/configure")
    public ModelAndView configure(Map map) {
        List<ClassifiesBo> tagsBoList = new ArrayList<>();
        List<Tag> taglist = tagService.list();
        taglist.stream().map(x -> {
            ClassifiesBo classifiesBo = new ClassifiesBo();
            classifiesBo.setName(x.getTagName());
            classifiesBo.setColor(COLO_LIST.get(new Random().nextInt(COLO_LIST.size())));
            tagsBoList.add(classifiesBo);
            return x;
        }).collect(Collectors.toList());
        map.put("tagsBo", tagsBoList);


        List<ClassifiesBo> classifiesBoList = new ArrayList<>();
        List<Classify> classifList = classifyService.list();
        classifList.stream().map(x -> {
            ClassifiesBo classifiesBo = new ClassifiesBo();
            classifiesBo.setName(x.getClassifyName());
            classifiesBo.setColor(COLO_LIST.get(new Random().nextInt(COLO_LIST.size())));
            classifiesBoList.add(classifiesBo);
            return x;
        }).collect(Collectors.toList());
        map.put("classifBo", classifiesBoList);

        List<ClassifiesBo> secriscBoList = new ArrayList<>();
        List<Series> seriesList = seriesService.list();
        seriesList.stream().map(x -> {
            ClassifiesBo classifiesBo = new ClassifiesBo();
            classifiesBo.setName(x.getSericsName());
            classifiesBo.setColor(COLO_LIST.get(new Random().nextInt(COLO_LIST.size())));
            secriscBoList.add(classifiesBo);
            return x;
        }).collect(Collectors.toList());
        map.put("secriscBo", secriscBoList);
        return new ModelAndView("configure", map);
    }

    /*
     * 归档
     */
    @GetMapping("/pigeonhole")
    public ModelAndView projects(Map map) {
        List<PigeonholeData> pigeonholeData = blogService.guiDangSum();
        Map<String, List<PigeonholeData>> rex = pigeonholeData.stream()
                .collect(Collectors.groupingBy(PigeonholeData::getYearMonth));
        List<OutPigeData> outPigeData = new ArrayList<>();
        Set<Map.Entry<String, List<PigeonholeData>>> entrySet = rex.entrySet();
        for (Map.Entry<String, List<PigeonholeData>> entry : entrySet) {
            OutPigeData od = new OutPigeData();
            String[] split = entry.getKey().split("-");
            od.setYearMonth(Long.valueOf(split[0]+split[1]));
            od.setPigeonholeData(entry.getValue());
            outPigeData.add(od);
        }
        outPigeData = outPigeData
                .stream()
                .sorted(Comparator.comparing(OutPigeData::getYearMonth))
                .collect(Collectors.toList());
        map.put("pigeBlogs", outPigeData);
        return new ModelAndView("pigeonhole", map);
    }

    /*@GetMapping("/details")
    public ModelAndView projects(Map map) {
        PageHelper.startPage(1, 2);
        List<Blog> blogList = blogService.list();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
        map.put("blog", blogPageInfo.getList().get(0));
        return new ModelAndView("details", map);
    }*/


   /* @GetMapping("/documents")
    public String documents() {
        return "documents";
    }*/

    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/doc")
    public String doc() {
        return "doc";
    }
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
       /* Iterator<Map.Entry<Integer, List<YnItems>>> it = retrunItemMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, List<YnItems>> entry = it.next();
            ItemClassfy itemClassfy = new ItemClassfy();
            itemClassfy.setYnItems(entry.getValue());
            itemClassfy.setItemClassfyName(entry.getKey());
            itemClassfies.add(itemClassfy);
        }*/
        map.put("itemClassfies", itemClassfies);
        return new ModelAndView("projects", map);
    }
}
