package com.gentler.liveanim.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.gentler.liveanim.R;

/**
 * Created by Jiantao on 2017/8/25.
 */

public class GiftItem extends FrameLayout {

    private static final String TAG=GiftItem.class.getSimpleName();
    private Context mContext;
    private View mContentView;

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

        addView(mContentView);
    }




}
