package com.mobiledev.rpm.androidtemplate.main.features.main;

import com.mobiledev.rpm.androidtemplate.main.data.local.manager.DataManager;
import com.mobiledev.rpm.androidtemplate.main.data.model.Users;
import com.mobiledev.rpm.androidtemplate.main.data.remote.service.UserService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmanacmol on 10/8/2016.
 */

public class MainPresenter implements MainContract.Presenter {

    public DataManager getDataManager() {
        return dataManager;
    }

    private DataManager dataManager;
    private Retrofit retrofit;
    private MainContract.View mView;

    Subscription loadUserListSubscription;

    @Inject
    public MainPresenter(Retrofit retrofit, DataManager dataManager, MainContract.View mView) {
        this.dataManager = dataManager;
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadUserList() {

        loadUserListSubscription = retrofit.create(UserService.class)
                .getUsersService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Users>>() {
                    @Override
                    public void onCompleted() {
                        mView.showLoadUserComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showLoadUserError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Users> usersList) {
                        dataManager.saveUsers(usersList);
                        mView.showLoadUser(dataManager.loadUsers());
                    }
                });

    }

    @Override
    public void cancelNetworkRequests() {
        if(loadUserListSubscription != null){
            loadUserListSubscription.unsubscribe();
        }
    }
}
