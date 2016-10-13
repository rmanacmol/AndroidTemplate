package com.mobiledev.rpm.androidtemplate.main.features.main;

import com.mobiledev.rpm.androidtemplate.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rmanacmol on 10/8/2016.
 */

@Module
public class MainModule {

    private final MainContract.View mView;

    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainContract.View providesUserListContractView() {
        return mView;
    }
}