package com.interfaces;

import com.model.HomePageListRowsBean;

import java.util.List;

/**
 * Created by enyoshio on 2017/12/6.
 */

public interface VRequstView {
    //显示进度条
    void showProgressBar();
    //隐藏进度条
    void hidProgressBar();
    //加载数据
    void loadData();
    //  loadMore refresh 就大家自由发挥了demo中就不写了
//    void loadMore();
//
//    void refresh();
//
//    void refreshSuccess(ArrayList<ZhihuStory> stories);
//
//    void refreshFail(String errCode, String errMsg);
//
//    void loadSuccess(ArrayList<ZhihuStory> stories);
//
//    void loadFail(String errCode, String errMsg);
    //加载数据成功回调
    void getDataSuccess(List<HomePageListRowsBean> jsonBeanList);
    //加载数据失败回调
    void getDataFail();
}
