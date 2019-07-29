package com.porducer.designing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class hospital_spinner_adapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mData;
    private String[] temp;
    private LayoutInflater mInflater;
    //Constructor
    public hospital_spinner_adapter(Context app_context,ArrayList<String> dataArray) {
        mInflater = LayoutInflater.from(app_context);
        this.mContext = app_context;
        //this.mData = data;
        mData = dataArray;
    }
    @Override
    public int getCount(){
        return mData.size();
    }
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.hos_service_spinner, viewGroup, false);
            holder.checkBox = view.findViewById(R.id.hos_spinner_checkbox);
            holder.imageview = view.findViewById(R.id.hos_spinner_image);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        int imgResourceId;
        switch (i) {
            case 0:
                imgResourceId = R.drawable.petshop;
                break;
            case 1:
                imgResourceId = R.drawable.vet;
                break;
            case 2:
                imgResourceId = R.drawable.hotal;
                break;
            case 3:
                imgResourceId = R.drawable.groom;
                break;
            default:
                imgResourceId = android.R.drawable.btn_plus;
                break;
        }
        holder.checkBox.setText(mData.get(i));
        holder.imageview.setImageResource(imgResourceId);
        view.setTag(holder);
        return view;
    }
    public class ViewHolder{
        CheckBox checkBox;
        ImageView imageview;
    }

}
