package com.presenter;

import android.app.Activity;
import com.commonutils.ImeiUtils;
import com.commonutils.JsonUtils;
import com.commonutils.LogUtils;
import com.google.gson.reflect.TypeToken;
import com.interfaces.RowsBeanInterface;
import com.interfaces.VRequstView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;
import com.model.HomePageListRowsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by enyoshio on 2017/12/6.
 */

public class RequstPresenter {
    private static final String TAG = "RequstPresenter";
    VRequstView requstModel;
    private   List<HomePageListRowsBean> jsonBeanList =  new ArrayList<>();
    public RequstPresenter(VRequstView VRequstView){
        this.requstModel = VRequstView;
    }

    public void requstData(Activity activity,int page){
        OkGo.<String>post("http://app.chinesetoday.cn/news/applist/")//
                .headers("aaa", "111")//
                .params("token", "5900d9329e0a903e5e4a6830c22874ccde84295d")
                .params("newsType", "1491534322")
                .params("cateid", "1491534322")
                .params("page", page)
                .params("domain_id", 2113)
                .params("version", "490")
                .params("sbID", ImeiUtils.getImei(activity))
                .converter(new StringConvert())//
                .adapt(new ObservableResponse<String>())//
                .subscribeOn(Schedulers.io())//
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        LogUtils.logi(TAG,"accept","请求开始");
                        // showLoading();
                        requstModel.showProgressBar();
                    }
                })//
                .observeOn(AndroidSchedulers.mainThread())//
                .subscribe(new Observer<Response<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        LogUtils.logi(TAG,"onSubscribe","onSubscribe");
                        // addDisposable(d);
                    }

                    @Override
                    public void onNext(@NonNull Response<String> response) {
                        //handleResponse(response);
                       // LogUtils.logtolongi(TAG,"onNext",response.body().toString());
                        getListData(response.body().toString());
                       // requstModel.getDataSuccess(response.body().toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        // showToast("请求失败");
                        //  handleError(null);
                        LogUtils.logtolongi(TAG,"onError",e.toString());
                        requstModel.getDataFail();
                    }

                    @Override
                    public void onComplete() {
                        // dismissLoading();
                        LogUtils.logtolongi(TAG,"onComplete","hidProgressBar");
                        requstModel.hidProgressBar();
                    }
                });
    }

    public void getListData(String resultStr){
        if(resultStr.isEmpty()){
            return;
        }
        try {
            JSONObject resultData = new JSONObject(resultStr).getJSONObject("data");
            Type type = new TypeToken<List<HomePageListRowsBean>>() {
            }.getType();
            JSONArray rowArray = resultData.getJSONArray("rows");

            try {
                jsonBeanList = (List<HomePageListRowsBean>) JsonUtils.fromJson(rowArray.toString(), type);
            } catch (Exception e) {
                LogUtils.logi(TAG,"error"+rowArray.toString());
                LogUtils.logi(TAG, "json error" + e.getMessage());
            }
            requstModel.getDataSuccess(jsonBeanList);
            for(int i=0;i<jsonBeanList.size();i++){
                LogUtils.logi(TAG,"jsonbelist",jsonBeanList.get(i).getTitle());
            }

        } catch (JSONException e) {
            e.printStackTrace();
            LogUtils.logi(TAG,"解析出错"+e.toString());
        }
    }
}
