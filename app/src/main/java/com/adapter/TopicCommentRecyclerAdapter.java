package com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.enyoshio.autoday.R;
import com.model.HomePageListRowsBean;

import java.util.List;


public class TopicCommentRecyclerAdapter extends RecyclerView.Adapter<TopicCommentRecyclerAdapter.MyViewHolder>   implements View.OnClickListener{
    private Context mContext;
    private List<HomePageListRowsBean> xgNewsBeanList;
    private OnItemClickListener clickListener;

    private OnItemClickListener mOnItemClickListener = null;

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    public TopicCommentRecyclerAdapter(Context context, List<HomePageListRowsBean> xgNewsBeanList) {
        mContext = context;
        this.xgNewsBeanList = xgNewsBeanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_embed_news, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        HomePageListRowsBean revHot = xgNewsBeanList.get(position);
        viewHolder.title.setText(revHot.getTitle());
        if (!revHot.getSource_name().isEmpty()) {
            viewHolder.source_name.setText(revHot.getSource_name());
        }
        int comm_nums = 0;
        try {
            comm_nums = Integer.parseInt(revHot.getComm_nums());
            viewHolder.comm_nums.setText(comm_nums + "条评论");
        } catch (Exception e) {
            comm_nums = 0;
        }
        viewHolder.comm_nums.setVisibility(comm_nums > 0 ? View.VISIBLE : View.GONE);

        if(xgNewsBeanList.size()==1){
            viewHolder.view_drvier.setVisibility(View.GONE);
        }else{
            viewHolder.view_drvier.setVisibility(View.VISIBLE);
        }

        Glide.with(mContext)
                .load(revHot.getPhoto().get(0))
                .placeholder(R.drawable.ic_empty_picture)
                .error(R.drawable.ic_empty_picture)
                .centerCrop()
                .into(viewHolder.photo);

        viewHolder.itemView.setTag(position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return xgNewsBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView source_name;
        public TextView comm_nums;
        public ImageView photo;
        public View view_drvier;

        public MyViewHolder(View convertView) {
            super(convertView);
            photo = (ImageView) convertView.findViewById(R.id.image);
            title = (TextView) convertView.findViewById(R.id.title);
            source_name = (TextView) convertView.findViewById(R.id.source);
            comm_nums = (TextView) convertView.findViewById(R.id.comm_nums);
            view_drvier=(View)convertView.findViewById(R.id.view_drvier);
        }
    }
}