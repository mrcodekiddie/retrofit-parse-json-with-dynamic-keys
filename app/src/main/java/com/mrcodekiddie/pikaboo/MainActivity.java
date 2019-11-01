package com.mrcodekiddie.pikaboo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    API api;
    Call<String> getUsersCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api=ServiceGenerator.createService(API.class);
        getUsersCall=api.getUsers();


        getUsersCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.v("userss",response.body());
                try {
                    JSONObject jsonResponse=new JSONObject(response.body());

                    JSONObject userss=new JSONObject(jsonResponse.getString("data").toString());

                    JSONArray usersArray=userss.names();

                    for(int i=0;i<usersArray.length();i++)
                    {
                        Log.v("users",userss.get(usersArray.get(i).toString()).toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
