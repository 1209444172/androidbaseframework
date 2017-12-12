package com.mainactivity;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.app.AppConstant;
import com.base.BaseActivity;
import com.bean.TabEntity;
import com.commonutils.LogUtils;
import com.example.enyoshio.autoday.R;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.fragment.main.CareMainFragment;
import com.fragment.main.NewsMainFragment;
import com.fragment.main.PhotosMainFragment;
import com.fragment.main.VideoMainFragment;
import java.util.ArrayList;
import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private final static  String Tag = "MainActivity";
    private String[] mTitles = {"首页", "美女","视频","关注"};
    private int[] mIconUnselectIds = {
            R.drawable.news_image_unselected,R.drawable.news_image_unselected,R.drawable.news_image_unselected,R.drawable.news_image_unselected};
    private int[] mIconSelectIds = {
            R.drawable.news_image_sydney_selected,R.drawable.news_image_sydney_selected, R.drawable.news_image_sydney_selected,R.drawable.news_image_sydney_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private NewsMainFragment newsMainFragment;
    private PhotosMainFragment photosMainFragment;
    private VideoMainFragment videoMainFragment;
    private CareMainFragment careMainFragment;
    private static int tabLayoutHeight;

    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
               R.anim.fade_out);
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    public void initPresenter() {

    }
    @Override
    public void initView() {

        //初始化菜单
        initTab();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //切换daynight模式要立即变色的页面
    //    ChangeModeController.getInstance().init(this,R.attr.class);
        super.onCreate(savedInstanceState);
        //初始化frament
        initFragment(savedInstanceState);
        tabLayout.measure(0,0);
        tabLayoutHeight=tabLayout.getMeasuredHeight();
        //监听菜单显示或隐藏

    }
    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
    }
    /**
     * 初始化碎片
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            newsMainFragment = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment");
            photosMainFragment = (PhotosMainFragment) getSupportFragmentManager().findFragmentByTag("photosMainFragment");
            videoMainFragment = (VideoMainFragment) getSupportFragmentManager().findFragmentByTag("videoMainFragment");
            careMainFragment = (CareMainFragment) getSupportFragmentManager().findFragmentByTag("careMainFragment");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            newsMainFragment = new NewsMainFragment();
            photosMainFragment = new PhotosMainFragment();
            videoMainFragment = new VideoMainFragment();
            careMainFragment = new CareMainFragment();

            transaction.add(R.id.fl_body, newsMainFragment, "newsMainFragment");
            transaction.add(R.id.fl_body, photosMainFragment, "photosMainFragment");
            transaction.add(R.id.fl_body, videoMainFragment, "videoMainFragment");
            transaction.add(R.id.fl_body, careMainFragment, "careMainFragment");
        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }

    /**
     * 切换
     */
    private void SwitchTo(int position) {
        LogUtils.logi("MainActivity","主页菜单position" ,position+"");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:
                transaction.hide(photosMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(newsMainFragment);
                transaction.commitAllowingStateLoss();
                setTitle("首页");
                break;
            //美女
            case 1:
                transaction.hide(newsMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(photosMainFragment);
                transaction.commitAllowingStateLoss();
                setTitle("美女");
                break;
            //视频
            case 2:
                transaction.hide(newsMainFragment);
                transaction.hide(photosMainFragment);
                transaction.hide(careMainFragment);
                transaction.show(videoMainFragment);
                transaction.commitAllowingStateLoss();
                setTitle("视频");
                break;
            //关注
            case 3:
                transaction.hide(newsMainFragment);
                transaction.hide(photosMainFragment);
                transaction.hide(videoMainFragment);
                transaction.show(careMainFragment);
                transaction.commitAllowingStateLoss();
                setTitle("关注");
                break;
            default:
                break;
        }
    }

    /**
     * 菜单显示隐藏动画
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide){
        final ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if(!showOrHide){
             valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 1, 0);
        }else{
             valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height= (int) valueAnimator.getAnimatedValue();
                tabLayout.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator,alpha);
        animatorSet.start();
    }

    /**
     * 监听全屏视频时返回键
     */
   /* @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }*/
    /**
     * 监听返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //奔溃前保存位置
        LogUtils.logi(Tag,"onSaveInstanceState进来了1");
        if (tabLayout != null) {
            LogUtils.logi(Tag,"onSaveInstanceState进来了2");
            outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, tabLayout.getCurrentTab());
        }
    }

    public void setTitle(String title){
        toolbar.setTitle(title);
    }

    @Override
    protected void onResume() {
        super.onResume();
       // UpdateFunGO.onResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
       // UpdateFunGO.onStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // ChangeModeController.onDestory();
    }
}
