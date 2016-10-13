package com.mobiledev.rpm.androidtemplate.main.data.remote.module;

import com.mobiledev.rpm.androidtemplate.main.AndroidTemplateApp;
import com.mobiledev.rpm.androidtemplate.main.data.local.manager.DataManager;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rmanacmol on 10/8/2016.
 */
@Module
public class LocModule {
    AndroidTemplateApp instance;

    public LocModule(AndroidTemplateApp androidTemplateApp) {
        instance = androidTemplateApp;
    }

    @Provides
    @Singleton
    DataManager dataManager() {
        FlowManager.init(new FlowConfig.Builder(instance).build());
        return new DataManager();
    }

}
