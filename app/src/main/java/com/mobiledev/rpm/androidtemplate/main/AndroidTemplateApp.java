package com.mobiledev.rpm.androidtemplate.main;

import android.app.Application;

import com.mobiledev.rpm.androidtemplate.main.data.remote.component.DaggerNetComponent;
import com.mobiledev.rpm.androidtemplate.main.data.remote.component.NetComponent;
import com.mobiledev.rpm.androidtemplate.main.data.remote.module.AppModule;
import com.mobiledev.rpm.androidtemplate.main.data.remote.module.LocModule;
import com.mobiledev.rpm.androidtemplate.main.data.remote.module.NetModule;

/**
 * Created by rmanacmol on 10/8/2016.
 */

public class AndroidTemplateApp extends Application {

    private static AndroidTemplateApp instance;
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;

            mNetComponent = DaggerNetComponent.builder()
                    .netModule(new NetModule(this))
                    .appModule(new AppModule(this))
                    .locModule(new LocModule(this))
                    .build();

        }
    }

    public static AndroidTemplateApp getInstance() {
        return instance;
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
