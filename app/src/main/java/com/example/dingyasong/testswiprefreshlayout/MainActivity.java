package com.example.dingyasong.testswiprefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> data = new LinkedList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        for (int i = 0; i < 20; i++) {
            data.add("Test data-->" + i);
        }
        Log.i("!!", "add lOg");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter(MainActivity.this, data);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
//        swipeRefreshLayout.setColorSchemeResources(R.color.text_color,
//                R.color.text_color_nigth,
//                R.color.text_color_nigth,
//                R.color.text_color);
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
//        swipeRefreshLayout.setProgressBackgroundColor(R.color.text_color_nigth);
//        //swipeRefreshLayout.setPadding(20, 20, 20, 20);
//        //swipeRefreshLayout.setProgressViewOffset(true, 100, 200);
//        //swipeRefreshLayout.setDistanceToTriggerSync(50);
//        swipeRefreshLayout.setProgressViewEndTarget(true, 100);
//
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 2; i++) {
                            data.add(0, "SwipeRefreshLayout下拉刷新" + i);
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    swipeRefreshLayout.setRefreshing(false);
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };
}
