package com.zhuye.hougong.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.zhuye.hougong.R;
import com.zhuye.hougong.adapter.find.FindZuiXinAdapter;
import com.zhuye.hougong.base.BaseFragment;
import com.zhuye.hougong.bean.HomeBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzzy on 2017/11/21.
 */

public class FindPagerAdapter2 extends PagerAdapter {


    private  Context conn;
    private List<String> titles = new ArrayList<>();
    private List<BaseFragment> fargments = new ArrayList<>();

    HomeBanner homeBanner;

    public FindPagerAdapter2(Context con) {
        conn = con;
        titles.add("最新");
        titles.add("关注");
        titles.add("同城");

//        fargments.add(new ZuiXinFragment());
//        fargments.add(new GuanZhuFragment());
//        fargments.add(new TongChengFragment());
    }



//    public FindPagerAdapter2(FragmentManager fm) {
//        super(fm);
//        titles.add("最新");
//        titles.add("关注");
//        titles.add("同城");
//        fargments.add(new ZuiXinFragment());
//        fargments.add(new GuanZhuFragment());
//        fargments.add(new TongChengFragment());
//    }


    @Override
    public int getCount() {
        return titles.size();
    }

    MaterialRefreshLayout materialRefreshLayout;
    RecyclerView recyclerView;
    FindZuiXinAdapter messageXiaoXi;

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



        @Override
    public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(conn, R.layout.common_recycle, null);
            materialRefreshLayout = view.findViewById(R.id.common_material);
            recyclerView = view.findViewById(R.id.commot_recycle);
            //BaseFindFragment messageXiaoXi = (BaseFindFragment) fargments.get(position);
            messageXiaoXi = new FindZuiXinAdapter(conn,titles);
            recyclerView.setAdapter(messageXiaoXi);
            recyclerView.setLayoutManager(new LinearLayoutManager(conn));
            // initView();
            //paihangThree = view.findViewById(R.id.paihang_three);
            container.addView(view);
            return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
