package com.mobiledev.rpm.androidtemplate.main.data.remote.service;

import com.mobiledev.rpm.androidtemplate.main.data.model.Users;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by rmanacmol on 10/8/2016.
 */

public interface UserService {
    @GET("users")
    Observable<List<Users>>
    getUsersService();
}
