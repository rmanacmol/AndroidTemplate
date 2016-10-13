package com.mobiledev.rpm.androidtemplate.main.data.local.manager;

import com.mobiledev.rpm.androidtemplate.main.data.model.Users;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by rmanacmol on 10/13/2016.
 */

public class DataManager implements DataManagerContract {

    @Override
    public void saveUsers(List<Users> usersList) {
        Delete.table(Users.class);
        Users users = new Users();
        for (int i = 0; i < usersList.size(); i++) {
            users.setId(usersList.get(i).getId());
            users.setEmail(usersList.get(i).getEmail());
            users.setName(usersList.get(i).getName());
            users.save();
        }
    }

    @Override
    public List<Users> loadUsers() {
        return SQLite.select().from(Users.class).queryList();
    }
}
