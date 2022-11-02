package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CateAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Cate> cateList;

    public CateAdapter(Context context, int layout, List<Cate> cateList) {
        this.context = context;
        this.layout = layout;
        this.cateList = cateList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class Viewholder{
        TextView cate;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        if (view == null){
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.cate = view.findViewById(R.id.cate);
            view.setTag(holder);
        }else{
            holder = (Viewholder) view.getTag();
        }

        Cate cate = cateList.get(i);
        holder.cate.setText(cate.getTen());
        return view;
    }
}
