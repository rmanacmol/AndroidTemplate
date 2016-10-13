package com.mobiledev.rpm.androidtemplate.main.features.main;

import com.mobiledev.rpm.androidtemplate.main.data.remote.component.NetComponent;
import com.mobiledev.rpm.androidtemplate.util.CustomScope;

import dagger.Component;

/**
 * Created by rmanacmol on 10/8/2016.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}