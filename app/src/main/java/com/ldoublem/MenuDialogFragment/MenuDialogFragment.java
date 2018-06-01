package com.ldoublem.MenuDialogFragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuDialogFragment extends DialogFragment implements OnClickListener {

    Drawable mDrawable;
    private LinearLayout ly_sousuo4;
    private LinearLayout ly_note1;
    private LinearLayout ly_edit2;
    private LinearLayout ly_shijian3;
    private LinearLayout ll_other;
    private FloatingActionButton iv4;
    private TextView tv4;
    private LinearLayout ll;


    public static MenuDialogFragment newInstance() {
        MenuDialogFragment contextMenuDialogFragment = new MenuDialogFragment();
        return contextMenuDialogFragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, R.style.MenuFragmentStyle);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        initViews(rootView);
        return rootView;
    }

    @SuppressLint("NewApi")
    private void initViews(final View view) {
        ly_note1 = (LinearLayout) view.findViewById(R.id.ly_note1);
        ly_edit2 = (LinearLayout) view.findViewById(R.id.ly_edit2);
        ly_shijian3 = (LinearLayout) view.findViewById(R.id.ly_shijian3);
        ll_other = (LinearLayout) view.findViewById(R.id.ll_other);
        ly_sousuo4 = (LinearLayout) view.findViewById(R.id.ly_sousuo4);
        ll = (LinearLayout) view.findViewById(R.id.ll);
        iv4 = (FloatingActionButton) view.findViewById(R.id.iv_sousuo4);
        tv4 = (TextView) view.findViewById(R.id.tv4);

        mDrawable = getActivity().getResources().getDrawable(R.drawable.white);
        mDrawable.setAlpha(500);
        view.findViewById(R.id.ly_diss).setBackground(mDrawable);

        startAnima(ly_note1);
        startAnima(ly_edit2);
        startAnima(ly_shijian3);
        startAnima(tv4);
        initClick();





    }

    private void initClick() {
        ly_note1.setOnClickListener(this);
        ly_edit2.setOnClickListener(this);
        ly_shijian3.setOnClickListener(this);
        ly_sousuo4.setOnClickListener(this);
        ll_other.setOnClickListener(this);
        ll.setOnClickListener(this);

    }

    Handler mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0) {
                    iv4.setImageResource(R.mipmap.ic_launcher);
                    cancleAnima(ly_note1);
                    cancleAnima(ly_edit2);
                    cancleAnima(ly_shijian3);
                    cancleAnima(tv4);

                }

            }
        };

    /**
     * 点击外部取消动画
     */
    private void cancleAnima(final View view) {
        ObjectAnimator animatorX4 = ObjectAnimator.ofFloat(view,"scaleX",1.0f,0.0f);
        ObjectAnimator animatorY4 = ObjectAnimator.ofFloat(view,"scaleY",1.0f,0.0f);
        AnimatorSet set =new AnimatorSet();
        set.setDuration(300);
        set.playTogether(animatorX4,animatorY4);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (view.getId()==R.id.ly_shijian3) {
                    dismiss();
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 点击动画显示
     * @param view
     */
    private void startAnima(View view){
    ObjectAnimator animatorX4 = ObjectAnimator.ofFloat(view,"scaleX",0.0f,1.0f);
    ObjectAnimator animatorY4 = ObjectAnimator.ofFloat(view,"scaleY",0.0f,1.0f);
    AnimatorSet set =new AnimatorSet();
    set.setDuration(300);
//    set.setInterpolator(new SpringScaleInterpolator(0.4f));
    set.playTogether(animatorX4,animatorY4);
    set.start();
}

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ly_note1:
                dismiss();
                break;
            case R.id.ly_edit2:
                dismiss();
                break;
            case R.id.ly_shijian3:
                dismiss();
                break;
            case R.id.ly_sousuo4:
                dismiss();
                break;
            case R.id.ll_other:
               message();
                break;
            case R.id.ll:
               message();
                break;
//            case R.id.ll2:
//             message();
//                break;
//            case R.id.ll3:
//              message();
//                break;
//            case R.id.ll4:
//             message();
//                break;
        }
    }

    private void message(){
        Message message = mHandler.obtainMessage(0);
        mHandler.sendMessage(message);
    }

}