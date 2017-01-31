package com.example.muhammad.newretrofitpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.muhammad.newretrofitpractice.network.Services;
import com.example.muhammad.newretrofitpractice.UserModel.user_retrofit_model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//for list of users
        Services interfacess = Services.retrofit.create(Services.class);
        Call<List<UserModel>> usermodels = interfacess.usermodels();
        usermodels.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().size(); i++) {
                        Log.d("TAG", response.body().get(i).toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });


        //for Single index of user
        Services singleinterface = Services.getRetrofit.create(Services.class);
        Call<UserModel> userModelCall = singleinterface.singleUser(2);
        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.e("TAG", response.body().getEmail());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
    }
}
