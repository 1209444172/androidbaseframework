package com.fragment;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.adapter.TopicCommentRecyclerAdapter;
import com.app.AppConstant;
import com.base.BaseFragment;
import com.commonutils.DynamicTimeFormat;
import com.commonutils.ImeiUtils;
import com.commonutils.LogUtils;
import com.example.enyoshio.autoday.R;
import com.interfaces.VRequstView;
import com.model.HomePageListRowsBean;
import com.presenter.RequstPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import butterknife.BindView;


public class NewsFragment extends BaseFragment  implements VRequstView {
    private static String TAG = "NewsFragment";
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private String mNewsId;
    private String mNewsType;
    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;
    private RequstPresenter requstPresenter;
    private int page = 1;

    @Override
    protected int getLayoutResource() {
        return R.layout.newsfragment;
    }

    @Override
    public void initPresenter() {
        requstPresenter  = new RequstPresenter(this);
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            mNewsId = getArguments().getString(AppConstant.NEWS_ID);
            mNewsType = getArguments().getString(AppConstant.NEWS_TYPE);
        }
        int deta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader = (ClassicsHeader)refreshLayout.getRefreshHeader();
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis()-deta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));
        mClassicsHeader.setSpinnerStyle(SpinnerStyle.Scale);//尺寸拉申
        mDrawableProgress = mClassicsHeader.getProgressView().getDrawable();
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                LogUtils.logi(TAG,"onRefresh");
                page = 1;
                requstPresenter.requstData(getActivity(),page);

            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                LogUtils.logi(TAG,"onLoadmore");

            }
        });


        //requestData();
    }

    public void requestData(){
        LogUtils.logi(TAG,"requestData","网路请求开始");

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hidProgressBar() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void getDataSuccess( List<HomePageListRowsBean> jsonBeanList) {
        refreshLayout.finishRefresh();
        LogUtils.logi(TAG,"data",jsonBeanList.size()+"");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        TopicCommentRecyclerAdapter adapter = new TopicCommentRecyclerAdapter(mRecyclerView.getContext(), jsonBeanList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void getDataFail() {

    }
}
