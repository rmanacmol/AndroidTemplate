package com.mobiledev.rpm.androidtemplate.main.features.main;

import com.mobiledev.rpm.androidtemplate.main.data.model.Users;

import java.util.List;

/**
 * Created by rmanacmol on 10/8/2016.
 */

public class MainContract {

    interface View {

        void showLoadUserError(String message);

        void showLoadUserComplete();

        void showLoadUser(List<Users> usersList);
    }

    interface Presenter {

        void loadUserList();

        void cancelNetworkRequests();

    }

}
