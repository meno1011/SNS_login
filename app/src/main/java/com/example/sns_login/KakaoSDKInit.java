package com.example.sns_login;

import android.app.Application;

import com.example.sns_login.Adapter.KakaoSDKAdapter;
import com.kakao.auth.KakaoSDK;

public class KakaoSDKInit extends Application {
    private static volatile KakaoSDKInit instance = null;

    public static KakaoSDKInit getGlobalApplicationContext(){
        if (instance==null){
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        }
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        // Kakao Sdk 초기화
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        instance = null;
    }
}
