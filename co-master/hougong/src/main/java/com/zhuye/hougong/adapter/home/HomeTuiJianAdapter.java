package com.zhuye.hougong.adapter.home;

import android.content.Context;

import com.zhuye.hougong.R;
import com.zhuye.hougong.adapter.BaseHolder;
import com.zhuye.hougong.adapter.BaseRecycleAdapter;

import java.util.List;

/**
 * Created by zzzy on 2017/11/22.
 */

public class HomeTuiJianAdapter extends BaseRecycleAdapter {


    public HomeTuiJianAdapter(Context conn) {
        super(conn);
    }

    public HomeTuiJianAdapter(Context conn, List data) {
        super(conn, data);
    }

    @Override
    protected int getResId() {
        return R.layout.home_tuijian_recycle_item;
    }

    @Override
    protected void conver(BaseHolder holder, int position) {

    }

}
