package com.yuan.farmerwork.ynblog.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.farmerwork.ynblog.domain.*;
import com.yuan.farmerwork.ynblog.domain.pojo.*;
import com.yuan.farmerwork.ynblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    YnDocumentService documentService;
    @Autowired
    YnLinksService ynLinksService;

    /*
     * 首页
     */
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

    /*
     * 404页面
     */
    @GetMapping("/haserror")
    public String error() {
        return "404";
    }

    /*
     * 添加标签，分类，系列,文档页面
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

        List<ClassifiesBo> documentBoList = new ArrayList<>();
        List<YnDocument> documentList = documentService.list();
        documentList.stream().map(x -> {
            ClassifiesBo classifiesBo = new ClassifiesBo();
            classifiesBo.setName(x.getTitle());
            classifiesBo.setColor(COLO_LIST.get(new Random().nextInt(COLO_LIST.size())));
            documentBoList.add(classifiesBo);
            return x;
        }).collect(Collectors.toList());
        map.put("documentBo", documentBoList);

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

    /*
     * 关于我页面
     */
    @GetMapping("/about")
    public ModelAndView about(Map map) {
        //获取首页介绍
        List<YnMian> ynMians = ynMianService.list();
        map.put("ownIntro", ynMians.get(1).getMainTitle());
        return new ModelAndView("about", map);
    }


    /*
     * 友情链接页面
     */
    @GetMapping("/uselink")
    public ModelAndView useLink(Map map) {
        List<YnLinks> ynLinks = ynLinksService.list(new QueryWrapper<YnLinks>().eq("is_delelte", 0));
        map.put("ynLinks", ynLinks);
        return new ModelAndView("uselink", map);
    }


}
