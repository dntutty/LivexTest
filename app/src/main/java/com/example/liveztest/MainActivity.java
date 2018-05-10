package com.example.liveztest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class MainActivity extends AppCompatActivity {
    private List<LiveSource> sources = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLiveSource();//初始化直播源数据
        SourceAdapter adapter = new SourceAdapter(MainActivity.this,R.layout.source_item,sources);
        final ListView sourceView = (ListView)findViewById(R.id.source_view);
        sourceView.setAdapter(adapter);
        sourceView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this,PlayActivity.class);
                LiveSource s=(LiveSource)sourceView.getItemAtPosition(position);
                //String url ="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

                intent.putExtra("PlayActivity",s.getSourceUri());
                startActivity(intent);

            }


        });
    }


    private void initLiveSource() {
        LiveSource baidu = new LiveSource("baidu","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        sources.add(baidu);
        LiveSource Ghs = new LiveSource("Ghs","http://zhuanba.c01.live.readtv.cn/ghs.m3u8");
        sources.add(Ghs);

    }

}
