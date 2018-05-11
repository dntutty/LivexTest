package com.example.liveztest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<LiveSource> sources=null;
    private SourceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLiveSource();//初始化直播源数据

        RecyclerView sourceView = (RecyclerView) findViewById(R.id.source_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        sourceView.setLayoutManager(layoutManager);
        adapter= new SourceAdapter(sources);
        sourceView.setAdapter(adapter);

    }


    private void initLiveSource() {
        sendRequestWithOkHttp("http://api.ghs-tv.readtv.cn/app/bftv/channel/",new okhttp3.Callback() {
            @Override
            public void onResponse(Call call,Response response) throws IOException {
                String sourceData = response.body().string();
                Gson gson = new Gson();
                Log.d("haha", sourceData);
                sources = gson.fromJson(sourceData, new TypeToken<List<LiveSource>>() {
                }.getType());
            }

            @Override
            public void onFailure(Call call,IOException e) {
                Log.d("oo","网络异常");
            }
        });

    }

    public void sendRequestWithOkHttp(String address,okhttp3.Callback callback) {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(address).build();
                    client.newCall(request).enqueue(callback);
    }

    @Override
    protected void onResume() {
        adapter.setItems(sources);
        adapter.notifyDataSetChanged();
        super.onResume();
    }

}
