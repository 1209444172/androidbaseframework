package com.fragment.main;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import com.app.AppConstant;
import com.base.BaseFragment;
import com.base.BaseFragmentAdapter;
import com.bean.NewsChannelTable;
import com.commonutils.LogUtils;
import com.commonutils.MyUtils;
import com.example.enyoshio.autoday.R;
import com.flyco.tablayout.SlidingTabLayout;
import com.fragment.NewsFragment;
import com.interfaces.NewsMainContract;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import android.support.design.widget.TabLayout;

public class NewsMainFragment extends BaseFragment {
    private final static  String TAG = "NewsMainFragment";
    @BindView(R.id.tabs)
    SlidingTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private BaseFragmentAdapter fragmentAdapter;
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    List<Fragment> mNewsFragmentList = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        LogUtils.logi(TAG,"newsmain initview");
        List<NewsChannelTable> newsChannelsMine =  new ArrayList<>();
        for(int i=0;i<mTitles.length;i++){
            NewsChannelTable newschanneltable = new NewsChannelTable();
            newschanneltable.setNewsChannelName(mTitles[i]);
            newschanneltable.setNewsChannelIndex(i);
            newschanneltable.setNewsChannelId(i+"");
            newsChannelsMine.add(newschanneltable);
        }

       List<String> channelNames = new ArrayList<>();

        for (int i = 0; i < newsChannelsMine.size(); i++) {
            channelNames.add(newsChannelsMine.get(i).getNewsChannelName());
            mNewsFragmentList.add(createListFragments(newsChannelsMine.get(i)));
        }
        for(int i=0;i<channelNames.size();i++){
            LogUtils.logi(TAG,channelNames.get(i));
        }
        if(fragmentAdapter==null) {
            fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        }else{
            //刷新fragment
            fragmentAdapter.setFragments(getChildFragmentManager(),mNewsFragmentList,channelNames);
        }
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setViewPager(viewPager );
        setPageChangeListener();

    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

              //  tabLayout.getTitleView(position).setTextSize(20);//改变字体大小

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private NewsFragment createListFragments(NewsChannelTable newsChannel) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.NEWS_ID, newsChannel.getNewsChannelId());
        bundle.putString(AppConstant.NEWS_TYPE, newsChannel.getNewsChannelType());
        bundle.putInt(AppConstant.CHANNEL_POSITION, newsChannel.getNewsChannelIndex());
        fragment.setArguments(bundle);
        return fragment;
    }

}
