package com.gentler.liveanim.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;

import com.gentler.liveanim.R;
import com.gentler.liveanim.evaluator.ColorEvaluator;

/**
 * Created by jiantao on 2017/8/25.
 */

public class GiftTextView extends AppCompatTextView {

    private static final String TAG = GiftTextView.class.getSimpleName();
    private Context mContext;
    private int mCurrNum = 0;
    private ScaleAnimation mScaleAnimation;
    private ObjectAnimator mScaleX;
    private ObjectAnimator mScaleY;
    private AnimatorSet mAnimatorSet;
    private ObjectAnimator mColorAnim;
    private int color= Color.WHITE;


    public GiftTextView(Context context) {
        this(context, null);
    }

    public GiftTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GiftTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        mScaleAnimation = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mScaleAnimation.setDuration(300);
        mScaleAnimation.setRepeatMode(1);
//        mScaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        mScaleAnimation.setInterpolator(new OvershootInterpolator(0.3f));
        mScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG, "onAnimationStart");
                mCurrNum++;
                setText(String.format(mContext.getString(R.string.gift_num), mCurrNum));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "onAnimationEnd");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d(TAG, "onAnimationRepeat");
            }
        });

        mScaleX = ObjectAnimator.ofFloat(this, "scaleX", 1.6f,2.4f,1.0f);
        mScaleY = ObjectAnimator.ofFloat(this, "scaleY", 1.6f,2.4f,1.0f);

        ValueAnimator valueAnimator=ValueAnimator.ofObject(new ColorEvaluator(),"#0000FF","#FF0000");
        mColorAnim = ObjectAnimator.ofObject(
                this,
                "textColor",
                new ColorEvaluator(),
                "#0000FF",
                "#FF0000");
        mColorAnim.setDuration(2000);
        mScaleX.setDuration(2000);
        mScaleY.setDuration(2000);
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.setDuration(2000);

        mAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimatorSet.playTogether(mScaleX, mScaleY, mColorAnim);
        mAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "onAnimationStart");
                mCurrNum++;
                setText(String.format(mContext.getString(R.string.gift_num), mCurrNum));
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

    }

    public void setCurrGiftNum(int giftNum) {
        this.mCurrNum = giftNum;
    }

    public void doTweenScale() {
        if (mScaleAnimation.hasStarted()) {
            mScaleAnimation.cancel();
        }
        this.startAnimation(mScaleAnimation);
    }


    public void doObjectScale() {
        mAnimatorSet.start();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        setTextColor(color);
        this.color = color;
    }
}
