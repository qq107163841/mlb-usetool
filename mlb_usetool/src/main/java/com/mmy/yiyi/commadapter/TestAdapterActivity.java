package com.mmy.yiyi.commadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mmy.yiyi.R;

import java.util.ArrayList;

/**
 * 创建自帅气的 清川
 */
public class TestAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_adapter);
        ListView listView = findViewById(R.id.main_list);
        ArrayList<String> mDatas = new ArrayList<String>();
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        //设置监听
        CommListAdapter<String> adapter = new CommListAdapter<String>(
                this, mDatas, R.layout.list_item) {
            @Override
            public void convert(ViewHolder c, String item) {
                TextView view = c.getView(R.id.item_text);
                ImageView imageView = c.getView(R.id.item_image);
                view.setText(item);
            }
        };
        listView.setAdapter(adapter);

    }

}
