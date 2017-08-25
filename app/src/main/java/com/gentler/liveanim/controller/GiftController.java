package com.gentler.liveanim.controller;

import android.content.Context;

/**
 * Created by Jiantao on 2017/8/25.
 */

public class GiftController {

    private static GiftController mGiftController;
    private GiftController(){}

    public static GiftController getInstance(Context context){
        if (null==mGiftController){
            synchronized (GiftController.class){
                if (null==mGiftController){
                    mGiftController=new GiftController();
                }
            }
        }
        return mGiftController;
    }





}
