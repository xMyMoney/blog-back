package com.zwx.blogback.model.res;

import io.swagger.models.auth.In;

import java.util.*;

public class ResArchivesInfo {


    private Map<Integer,Map<Integer,List<ResArticleInfo>>> yearMap;

    public ResArchivesInfo(List<ResArticleInfo> list) {
        yearMap = new HashMap<>();

        Map<Integer,List<ResArticleInfo>> monthMap = new HashMap<>();
        List<ResArticleInfo> articleInfoList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();


        for (ResArticleInfo articleInfo : list) {
            if(null == articleInfo.getArticle().getPublishTime()) continue;
            calendar.setTime(articleInfo.getArticle().getPublishTime());
            int year = calendar.get(Calendar.YEAR);
            //月份从0开始的
            int month = calendar.get(Calendar.MONTH) + 1;
            if(!yearMap.containsKey(year)) {
                monthMap = new HashMap<>();
            }
            if(!monthMap.containsKey(month)) {
                articleInfoList = new ArrayList<>();
            }
            articleInfoList.add(articleInfo);
            monthMap.put(month,articleInfoList);
            yearMap.put(year,monthMap);
        }

    }

    public Map<Integer, Map<Integer, List<ResArticleInfo>>> getYearMap() {
        return yearMap;
    }
}
