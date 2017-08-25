package com.gentler.liveanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gentler.liveanim.view.GiftTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_gift_num)
    GiftTextView mGiftTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.btn_send)
    protected void onClickSend(View view){
//        mGiftTextView.doTweenScale();
        mGiftTextView.doObjectScale();
    }

}
