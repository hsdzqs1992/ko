package com.zhuye.hougong.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.zhuye.hougong.R;
import com.zhuye.hougong.adapter.message.MessageXiaoXi;
import com.zhuye.hougong.base.BaseFragment;
import com.zhuye.hougong.bean.HomeBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzzy on 2017/11/21.
 */

public class MessagePagerAdapter2 extends PagerAdapter {


    Context conn;

    private List<BaseFragment> fargments = new ArrayList<>();

    HomeBanner homeBanner;
    List<String> titles;
    public MessagePagerAdapter2(Context con, List<String> titles) {

        conn = con;
        this.titles = titles;

    }

//    public MessagePagerAdapter2(FragmentManager fm) {
//        super(fm);
//        titles.add("消息");
//        titles.add("通话");
//
//        fargments.add(new XiaoxiFragment());
//        fargments.add(new TongHuaFragment());
//    }




    MaterialRefreshLayout materialRefreshLayout;
    RecyclerView recyclerView;
    MessageXiaoXi messageXiaoXi;



    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = View.inflate(conn, R.layout.common_recycle, null);
        materialRefreshLayout = view.findViewById(R.id.common_material);

        recyclerView = view.findViewById(R.id.commot_recycle);
        messageXiaoXi = new MessageXiaoXi(conn,titles);
        recyclerView.setAdapter(messageXiaoXi);
        recyclerView.setLayoutManager(new LinearLayoutManager(conn));
        initView();
        //paihangThree = view.findViewById(R.id.paihang_three);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void initView(){
        if (recyclerView!=null){
            recyclerView.setAdapter(messageXiaoXi);
            recyclerView.setLayoutManager(new LinearLayoutManager(conn));
        }

    };
}
