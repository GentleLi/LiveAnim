package com.gentler.liveanim.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gentler.liveanim.R;

/**
 * Created by Jiantao on 2017/8/25.
 */

public class GiftItem extends FrameLayout {

    private static final String TAG=GiftItem.class.getSimpleName();
    private Context mContext;
    private View mContentView;
    private int mWidth;
    private int mHeight;
    private TextView mTxtName;
    private ImageView mImgAvatar;


    public GiftItem(@NonNull Context context) {
        this(context,null);
    }

    public GiftItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GiftItem(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        init();
    }

    private void init() {
        mContentView = LayoutInflater.from(mContext).inflate(R.layout.item_gift,null);
        mTxtName = (TextView) mContentView.findViewById(R.id.tv_gift_name);
        mImgAvatar = (ImageView) findViewById(R.id.iv_avatar);
        addView(mContentView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    /**
     * 开始动画
     */
    public void startAnim(){
          ObjectAnimator animContainer=ObjectAnimator.ofFloat(this,"translationX",-mWidth,0);
        animContainer.setDuration(200);
        animContainer.start();
        animContainer.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator animAvatar=ObjectAnimator.ofFloat(mImgAvatar,"translationX",-500,0);
        animAvatar.setDuration(300);
        animAvatar.start();
    }
}
