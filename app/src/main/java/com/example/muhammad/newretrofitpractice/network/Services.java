package com.example.muhammad.newretrofitpractice.network;

import com.example.muhammad.newretrofitpractice.Constants.Urls;
import com.example.muhammad.newretrofitpractice.UserModel.user_retrofit_model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Muhammad on 1/31/2017.
 */

public interface Services {

    //for all list of users
    @GET("users/")
    Call<List<UserModel>> usermodels();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    //for single index of user

    @GET("users/{user}")
    Call<UserModel> singleUser(@Path("user") int user);

    Retrofit getRetrofit = new Retrofit.Builder().baseUrl(Urls.Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
