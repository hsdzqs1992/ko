package com.zhuye.hougong.adapter.find;

import android.content.Context;

import com.zhuye.hougong.R;
import com.zhuye.hougong.adapter.BaseHolder;
import com.zhuye.hougong.adapter.BaseRecycleAdapter;

import java.util.List;

/**
 * Created by zzzy on 2017/11/22.
 */

public class FindZuiXinAdapter extends BaseRecycleAdapter {


    public FindZuiXinAdapter(Context conn) {
        super(conn);
    }

    public FindZuiXinAdapter(Context conn, List data) {
        super(conn, data);
    }

    @Override
    protected int getResId() {
        return R.layout.find_zuixin_item;
    }

    @Override
    protected void conver(BaseHolder holder, int position) {

    }

}
