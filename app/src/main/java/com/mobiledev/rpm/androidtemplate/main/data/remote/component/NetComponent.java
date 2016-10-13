package com.mobiledev.rpm.androidtemplate.main.data.remote.component;

import com.mobiledev.rpm.androidtemplate.main.data.local.manager.DataManager;
import com.mobiledev.rpm.androidtemplate.main.data.remote.module.AppModule;
import com.mobiledev.rpm.androidtemplate.main.data.remote.module.LocModule;
import com.mobiledev.rpm.androidtemplate.main.data.remote.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by rmanacmol on 10/8/2016.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class, LocModule.class})

public interface NetComponent {
    Retrofit retrofit();
    DataManager dataManager();
}