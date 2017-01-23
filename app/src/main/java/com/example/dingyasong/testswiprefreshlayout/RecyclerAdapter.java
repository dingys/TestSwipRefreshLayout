package com.example.dingyasong.testswiprefreshlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dingyasong on 2017/1/23.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> data;
    private LayoutInflater mInflater;
    public  final int headerView = 4;
    private final int footerView = 5;

    public RecyclerAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position))
            return headerView;
        if (isFooterView(position)) {
            return footerView;
        }
        int i = position % 3;
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 0;
            default:
                return 0;
        }
    }

    public boolean isHeaderView(int position) {
        if (position == 0) {
            return true;
        }
        return false;
    }

    public boolean isFooterView(int postion) {
        if (postion == (data.size() + 1)) {
            return true;
        }
        return false;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = mInflater.inflate(R.layout.recycler_item, null);
                return new TestHolder(view);
            case headerView:
                View leftView = mInflater.inflate(R.layout.left, null);
                return new LeftHolder(leftView);
            case footerView:
            default:
                View rightView = mInflater.inflate(R.layout.right, null);
                return new RightHolder(rightView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TestHolder) holder).setData(position);
//        switch (position) {
//            case 0:
//                if (holder instanceof TestHolder) {
//                    ((TestHolder) holder).setData(position);
//                }
//                break;
//            case 1:
//                if (holder instanceof LeftHolder) {
//                    ((LeftHolder) holder).setData(position);
//                }
//                break;
//            case 2:
//                if (holder instanceof RightHolder) {
//                    ((RightHolder) holder).setData(position);
//                }
//                break;
//
//        }
    }


    @Override
    public int getItemCount() {
        return (data == null ? 0 : data.size());
    }

    class TestHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public TestHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
        }

        public void setData(int position) {
            textView.setText(data.get(position) + "");
        }
    }

    class  HeaderHolder extends  RecyclerView.ViewHolder{

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    class  FooterHolder extends  RecyclerView.ViewHolder{

        public FooterHolder(View itemView) {
            super(itemView);
        }
    }

    class LeftHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public LeftHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }

        public void setData(int position) {
            textView.setText(data.get(position) + "");
        }
    }

    class RightHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public RightHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }

        public void setData(int position) {
            textView.setText(data.get(position) + "");
        }
    }
}
