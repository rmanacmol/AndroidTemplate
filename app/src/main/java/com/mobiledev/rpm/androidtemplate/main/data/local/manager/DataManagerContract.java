package com.mobiledev.rpm.androidtemplate.main.data.local.manager;

import com.mobiledev.rpm.androidtemplate.main.data.model.Users;

import java.util.List;

/**
 * Created by rmanacmol on 10/13/2016.
 */

public interface DataManagerContract {

    void saveUsers(List<Users> usersList);

    List<Users> loadUsers();

}
