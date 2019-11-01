package com.mrcodekiddie.pikaboo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API
{
    @GET("users.json")
    Call<String> getUsers();
}
