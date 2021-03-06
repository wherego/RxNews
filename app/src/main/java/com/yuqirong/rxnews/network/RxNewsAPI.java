package com.yuqirong.rxnews.network;

import com.yuqirong.rxnews.module.news.model.bean.News;
import com.yuqirong.rxnews.module.news.model.bean.NewsDetail;
import com.yuqirong.rxnews.module.video.model.bean.Video;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yuqirong on 2016/2/24.
 */
public interface RxNewsAPI {

    /**
     * 得到新闻列表
     *
     * @param type      新闻类型 headline为头条,local为北京本地,fangchan为房产,list为其他
     * @param id        新闻ID
     * @param startPage 起始页
     * @return
     */
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<News>>> getNews(@Path("type") String type, @Path("id") String id, @Path("startPage") int startPage);

    /**
     * 得到某一新闻的详情
     *
     * @param postId 新闻详情的id
     * @return
     */
    @GET("nc/article/{postId}/full.html")
    Observable<Map<String, NewsDetail>> getNewsDetail(@Path("postId") String postId);

    /**
     * 得到视频列表
     *
     * @param id        视频ID
     * @param startPage 得到新闻列表
     * @return
     */
    @GET("nc/video/list/{id}/n/{startPage}-10.html")
    Observable<Map<String, List<Video>>> getVideo(@Path("id") String id, @Path("startPage") int startPage);

}
