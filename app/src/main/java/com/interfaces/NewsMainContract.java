package com.interfaces;





import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import com.base.BaseModel;
import com.base.BasePresenter;
import com.base.BaseView;
import com.bean.NewsChannelTable;

import java.util.List;


public interface NewsMainContract {

    void getData(Context context ,  ProgressBar progressBar);
    void initData(List<View> editList);
}
