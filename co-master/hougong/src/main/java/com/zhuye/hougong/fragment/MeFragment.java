package com.zhuye.hougong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.hougong.R;
import com.zhuye.hougong.adapter.me.MeBottomAdapter;
import com.zhuye.hougong.utils.CommentUtils;
import com.zhuye.hougong.utils.SpUtils;
import com.zhuye.hougong.view.FansActivity;
import com.zhuye.hougong.view.GuanZhuActivity;
import com.zhuye.hougong.view.LookMeActivity;
import com.zhuye.hougong.view.MyFriendsActivity;
import com.zhuye.hougong.view.MyWaletActivity;
import com.zhuye.hougong.view.PersonDetailActivity;
import com.zhuye.hougong.view.SettingsActivity;
import com.zhuye.hougong.view.ShengVIP1Activity;
import com.zhuye.hougong.view.WhoSendLiWuActivity;
import com.zhuye.hougong.view.YanQingJiangLiActivity;
import com.zhuye.hougong.weidgt.RoundedCornerImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by zzzy on 2017/11/20.
 */

public class MeFragment extends Fragment {


    //private MyToolbar myToolbar;

    RoundedCornerImageView cornerImageView;
    ImageView setiv;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.tv_friends)
    TextView tvFriends;
    Unbinder unbinder;
    //    @BindView(R.id.me_recycleview)
//    RecyclerView meRecycleview;
    MeBottomAdapter meBottomAdapter;
    @BindView(R.id.avatar)
    RoundedCornerImageView avatar;
    @BindView(R.id.me_name)
    TextView meName;
    @BindView(R.id.me_id)
    TextView meId;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    @BindView(R.id.zuopinji)
    RelativeLayout zuopinji;
    @BindView(R.id.nickname)
    TextView nickname;
    @BindView(R.id.btn_sign)
    TextView btnSign;
    @BindView(R.id.tag_vip)
    ImageView tagVip;
    @BindView(R.id.me_yinpin_iv)
    ImageView meYinpinIv;
    @BindView(R.id.me_yinpin_tv)
    TextView meYinpinTv;
    @BindView(R.id.me_yinpin_iv2)
    ImageView meYinpinIv2;
    @BindView(R.id.me_yinpin_go)
    ImageView meYinpinGo;
    @BindView(R.id.me_yinpin_tv2)
    TextView meYinpinTv2;
    @BindView(R.id.me_shipin_iv)
    ImageView meShipinIv;
    @BindView(R.id.me_shipin_tv)
    TextView meShipinTv;
    @BindView(R.id.me_shipin_iv2)
    ImageView meShipinIv2;
    @BindView(R.id.me_shipin_go)
    ImageView meShipinGo;
    @BindView(R.id.me_shipin_tv2)
    TextView meShipinTv2;
    @BindView(R.id.me_qianbao)
    LinearLayout meQianbao;
    @BindView(R.id.me_photos)
    LinearLayout mePhotos;
    @BindView(R.id.me_yaoqing)
    LinearLayout meYaoqing;
    @BindView(R.id.me_lookme)
    LinearLayout meLookme;
    @BindView(R.id.me_sengliwu)
    LinearLayout meSengliwu;
    @BindView(R.id.me_shengvip)
    LinearLayout meShengvip;

    private Boolean isShouYuYin ;
    private Boolean isShouShiPin ;
    private static final String SHOWYINPIN = "shouyinpin";
    private static final String SHOWSHIPIN = "shoushipin";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_mee, null);
        //myToolbar = view.findViewById(R.id.mee_toolbar);
        // myToolbar.hideView(myToolbar.homeLeftIcon);
        cornerImageView = view.findViewById(R.id.avatar);
        setiv = view.findViewById(R.id.iv_set);
        unbinder = ButterKnife.bind(this, view);


        List<String> data = new ArrayList<>();

        data.add("我的钱包");
        data.add("自拍认证");
        data.add("邀请奖励");
        data.add("谁看过我");
        data.add("谁送过礼物");
        data.add("升级VIP");

//        meBottomAdapter= new MeBottomAdapter(getActivity(),data);
//        meRecycleview.setAdapter(meBottomAdapter);
//        meRecycleview.setLayoutManager(new GridLayoutManager(getActivity(),3));
        isShouShiPin  = SpUtils.getBoolean(getActivity(),SHOWSHIPIN,false);
        isShouYuYin  = SpUtils.getBoolean(getActivity(),SHOWYINPIN,false);
        meShipinIv2.setImageResource(isShouShiPin ? R.drawable.open:R.drawable.close);
        meYinpinIv2.setImageResource(isShouYuYin ? R.drawable.open:R.drawable.close);
        initListener();

        //shiPinToggle();
        //yuYinToggle();
        return view;
    }

    private void initListener() {

        cornerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token = SpUtils.getString(getActivity(), "token", "");

                startActivity(new Intent(getActivity(), PersonDetailActivity.class));
                return;
//                if (TextUtils.isEmpty(token)) {
//
//                    //没登录
//                   // startActivity(new Intent(getActivity(), LoginActivity.class));
//                } else {
//                    //登录
//                    startActivity(new Intent(getActivity(), PersonDetailActivity.class));
//                }
            }
        });
        setiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });

//        meBottomAdapter.setOnItemClickListener(new BaseHolder.OnItemClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
//                switch (position){
//                    case 0:
//                        startActivity(new Intent(getActivity(), MyWaletActivity.class));
//                        break;
//                    case 1:
//                        startActivity(new Intent(getActivity(), ZiPaiActivity.class));
//                        break;
//                    case 2:
//                        startActivity(new Intent(getActivity(), YanQingJiangLiActivity.class));
//                        break;
//                    case 3:
//                        startActivity(new Intent(getActivity(), LookMeActivity.class));
//                        break;
//                    case 4:
//                        startActivity(new Intent(getActivity(), WhoSendLiWuActivity.class));
//                        break;
//                    case 5:
//                        startActivity(new Intent(getActivity(), ShengVIP1Activity.class));
//                        break;
//                }
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.tv_follow, R.id.tv_fans, R.id.tv_friends, R.id.me_yinpin_iv2, R.id.me_yinpin_go, R.id.me_shipin_iv2, R.id.me_shipin_go, R.id.me_qianbao, R.id.me_photos, R.id.me_yaoqing, R.id.me_lookme, R.id.me_sengliwu, R.id.me_shengvip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_follow:
                startActivity(new Intent(getActivity(), GuanZhuActivity.class));
                break;
            case R.id.tv_fans:
                startActivity(new Intent(getActivity(), FansActivity.class));
                break;
            case R.id.tv_friends:
                startActivity(new Intent(getActivity(), MyFriendsActivity.class));
                break;
            case R.id.me_yinpin_iv2:
                yuYinToggle();
                //meYinpinIv2.setImageResource(R.drawable.close);
                break;
            case R.id.me_yinpin_go:
                break;
            case R.id.me_shipin_iv2:
                shiPinToggle();
                break;
            case R.id.me_shipin_go:
                break;
            case R.id.me_qianbao:
                startActivity(new Intent(getActivity(), MyWaletActivity.class));
                break;
            case R.id.me_photos:
                startActivity(new Intent(getActivity(), MyFriendsActivity.class));
                break;
            case R.id.me_yaoqing:
                startActivity(new Intent(getActivity(), YanQingJiangLiActivity.class));
                break;
            case R.id.me_lookme:
                startActivity(new Intent(getActivity(), LookMeActivity.class));
                break;
            case R.id.me_sengliwu:
                startActivity(new Intent(getActivity(), WhoSendLiWuActivity.class));
                break;
            case R.id.me_shengvip:
                startActivity(new Intent(getActivity(), ShengVIP1Activity.class));
                break;
        }
    }

    private void shiPinToggle() {
        if(isShouShiPin){
            meShipinIv2.setImageResource(R.drawable.close);
        }else {
            meShipinIv2.setImageResource(R.drawable.open);
        }
        isShouShiPin=!isShouShiPin;
        SpUtils.setBoolean(getActivity(),SHOWSHIPIN,isShouShiPin);
    }

    private void yuYinToggle() {
        if(isShouYuYin){
            meYinpinIv2.setImageResource(R.drawable.close);
            CommentUtils.toast(getActivity(),"关闭服务了");
        }else {
            meYinpinIv2.setImageResource(R.drawable.open);
            CommentUtils.toast(getActivity(),"开启服务了");
        }
        isShouYuYin=!isShouYuYin;
        SpUtils.setBoolean(getActivity(),SHOWYINPIN,isShouYuYin);
    }





}
