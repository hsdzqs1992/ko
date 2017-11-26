package com.zhuye.hougong.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.daimajia.slider.library.SliderLayout;
import com.zhuye.hougong.R;
import com.zhuye.hougong.adapter.home.HomeTuiJianAdapter;
import com.zhuye.hougong.base.BaseFragment;
import com.zhuye.hougong.bean.HomeBanner;
import com.zhuye.hougong.fragment.home.TuiJianFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzzy on 2017/11/21.
 */

public class HomePagerAdapter2 extends PagerAdapter {


    private  Context conn;
    private List<String> titles = new ArrayList<>();
    private List<BaseFragment> fargments = new ArrayList<>();

    HomeBanner homeBanner;

    private View rotview;


    public HomePagerAdapter2(Context con) {
        conn = con;
        titles.add("推荐");
        titles.add("活跃");
        titles.add("新人");
        titles.add("免费");
    }


//    public HomePagerAdapter2(FragmentManager fm) {
//        super(fm);
//        titles.add("推荐");
//        titles.add("活跃");
//        titles.add("新人");
//        titles.add("免费");
//        fargments.add(new TuiJianFragment());
//        fargments.add(new HuoYueFragment());
//        fargments.add(new XinRenFragment());
//        fargments.add(new MianFeiFragment());
//    }

    public void setData(HomeBanner homeBanner){
        this.homeBanner = homeBanner;
        if(((TuiJianFragment)fargments.get(0))!=null){
            ((TuiJianFragment)fargments.get(0)).setData(homeBanner);
        }

    }


    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


    protected SliderLayout sliderShow;
    protected MaterialRefreshLayout materialRefreshLayout;

    protected RecyclerView recyclerView;
    protected HomeTuiJianAdapter homeTuiJianAdapter;
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(conn, R.layout.fragment_home_vp, null);
        materialRefreshLayout = view.findViewById(R.id.fragment_home_materrial);
        recyclerView = view.findViewById(R.id.fragment_home_recycle);
        sliderShow= (SliderLayout) view.findViewById(R.id.slider);
        homeTuiJianAdapter = new HomeTuiJianAdapter(conn,titles);
        recyclerView.setAdapter(homeTuiJianAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(conn));
        // initView();
        //paihangThree = view.findViewById(R.id.paihang_three);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
