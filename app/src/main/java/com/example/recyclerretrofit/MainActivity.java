package com.example.recyclerretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModelClass> modelClassArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TestAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //getDataFormNet();
        getMovies();
    }

    private void getMovies() {


    }

    private void getDataFormNet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DataInterface dataInterface = retrofit.create(DataInterface.class);
        final Call<List<ModelClass>> listCall = dataInterface.getData();
        listCall.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                Toast.makeText(MainActivity.this, "its ok", Toast.LENGTH_SHORT).show();
                modelClassArrayList = new ArrayList<>(response.body());
                adapter = new TestAdapter(modelClassArrayList,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "its not ok", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
