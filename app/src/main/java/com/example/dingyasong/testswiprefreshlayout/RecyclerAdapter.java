package com.example.dingyasong.testswiprefreshlayout;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by dingyasong on 2017/1/23.
 */

public class RecyclerAdapter extends ListBaseAdapter<String> {

    public RecyclerAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.recycler_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        TextView textView = holder.getView(R.id.text_view);
        textView.setText(mDataList.get(position));
    }

}
