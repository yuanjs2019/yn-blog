package com.yuan.farmerwork.ynblog.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * list 工具类.
 */
public class ListUtils {

    /**
     * @Description list 随机取数据
     * @params list    list集合
     * num     随机取多少条
     **/
    public static List getRandomList(List list, int num) {
        List olist = new ArrayList<>();
        if (list.size() <= num) {
            return list;
        } else {
            Random random = new Random();
            for (int i = 0; i < num; i++) {
                int intRandom = random.nextInt(list.size() - 1);
                olist.add(list.get(intRandom));
                list.remove(list.get(intRandom));
            }
            return olist;
        }
    }
}
