package com.porducer.designing;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class fragment_bussinesshour extends Fragment{

    String Defult_time;
    static CallBackInterface mcallback;
    Button Confirm, Add_time,timepicker_ok;
    int date_time_counter;
    bussinessshour_date_time viewgroup1, viewgroup2, viewgroup3;
    TimePicker picker;
    TextView hour_from1, hour_to1, hour_from2, hour_to2, hour_from3, hour_to3;
    Spinner day_from1,day_to1,day_from2,day_to2,day_from3,day_to3;
    TextView Header;
    View Clicked;
    Bundle data_from_this_fragment;


    //Constructor
    public fragment_bussinesshour() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        date_time_counter = 1;
        Defult_time = getResources().getString(R.string.defult_time);

        Confirm = view.findViewById(R.id.fragment_button_confirm);
        Add_time = view.findViewById(R.id.fragment_button_addtime);
        viewgroup1 = view.findViewById(R.id.bussinessshour_date_time1);
        viewgroup2 = view.findViewById(R.id.bussinessshour_date_time2);
        viewgroup3 = view.findViewById(R.id.bussinessshour_date_time3);
        hour_from1 = viewgroup1.hour_from;
        hour_to1 = viewgroup1.hour_to;
        hour_from2 = viewgroup2.hour_from;
        hour_to2 = viewgroup2.hour_to;
        hour_from3 = viewgroup3.hour_from;
        hour_to3 = viewgroup3.hour_to;
        day_from1 = viewgroup1.day_from;
        day_to1 = viewgroup1.day_from;
        day_from2 = viewgroup2.day_from;
        day_to2 = viewgroup2.day_to;
        day_from3 = viewgroup3.day_from;
        day_to2 = viewgroup3.day_to;
        Header = view.findViewById(R.id.fragment_textview_header);
        picker = view.findViewById(R.id.simpleTimePicker);
        timepicker_ok = view.findViewById(R.id.time_picker_ok);
        picker.setVisibility(4);
        timepicker_ok.setVisibility(4);

        Confirm.setOnClickListener(Confirm_Clicked);
        Add_time.setOnClickListener(Add_time_Clicked);
        hour_from1.setOnClickListener(hf_clicked);
        hour_from2.setOnClickListener(hf_clicked);
        hour_from3.setOnClickListener(hf_clicked);
        hour_to1.setOnClickListener(hf_clicked);
        hour_to2.setOnClickListener(hf_clicked);
        hour_to3.setOnClickListener(hf_clicked);
        timepicker_ok.setOnClickListener(timepicker_ok_Clicked);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bussinesshour, container, false);
    }

    //Method of Setting interface call back
    public static void setCallback(CallBackInterface callback) {
        mcallback = callback;
    }

    private View.OnClickListener Confirm_Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            if (mcallback != null) {
                data_packing();
                mcallback.callback_from_bussinesshour(data_from_this_fragment);
            }
        }
    };

    private View.OnClickListener Add_time_Clicked = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        public void onClick(View v) {
            switch (date_time_counter) {
                case 1:
                    viewgroup2.setVisibility(0);
                    date_time_counter++;
                    break;
                case 2:
                    viewgroup3.setVisibility(0);
                    date_time_counter++;
                    break;
                default:
                    date_time_counter = 1;
                    viewgroup2.setVisibility(4);
                    viewgroup3.setVisibility(4);
                    break;
            }
        }
    };
    private View.OnClickListener hf_clicked = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        public void onClick(View v) {
                picker.setVisibility(0);
                timepicker_ok.setVisibility(0);
                Clicked = v;
            }
        };
    private View.OnClickListener timepicker_ok_Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            picker.setVisibility(4);
            timepicker_ok.setVisibility(4);
            String temp = String.valueOf(picker.getHour())+":"+String.valueOf(picker.getMinute());
            if (Clicked==hour_from1){hour_from1.setText(temp);}
            else if (Clicked==hour_to1){hour_to1.setText(temp);}
            else if (Clicked==hour_from1){hour_from2.setText(temp);}
            else if (Clicked==hour_to2){hour_to2.setText(temp);}
            else if (Clicked==hour_from2){hour_from2.setText(temp);}
            else if (Clicked==hour_to3){hour_to3.setText(temp);}
        }
    };

    private void data_packing(){
        if (data_valid()) {
            data_from_this_fragment = new Bundle();
            if (date_time_counter == 1) {
                data_from_this_fragment.putString("Day_from1", String.valueOf(day_from1.getSelectedItem()));
                data_from_this_fragment.putString("Day_to1", String.valueOf(day_to1.getSelectedItem()));
                data_from_this_fragment.putString("Hour_from1", String.valueOf(hour_from1.getText()));
                data_from_this_fragment.putString("Hour_to1", String.valueOf(hour_to1.getText()));
            }
            if (date_time_counter == 1) {
                data_from_this_fragment.putString("Day_from2", String.valueOf(day_from2.getSelectedItem()));
                data_from_this_fragment.putString("Day_to2", String.valueOf(day_to2.getSelectedItem()));
                data_from_this_fragment.putString("Hour_from2", String.valueOf(hour_from2.getText()));
                data_from_this_fragment.putString("Hour_to2", String.valueOf(hour_to2.getText()));
            }
            if (date_time_counter == 1) {
                data_from_this_fragment.putString("Day_from3", String.valueOf(day_from3.getSelectedItem()));
                data_from_this_fragment.putString("Day_to3", String.valueOf(day_to3.getSelectedItem()));
                data_from_this_fragment.putString("Hour_from3", String.valueOf(hour_from3.getText()));
                data_from_this_fragment.putString("Hour_to3", String.valueOf(hour_to3.getText()));
            }
        } else Toast.makeText(getContext(), "Please Describe time and date before Confirm bussiness time", Toast.LENGTH_SHORT).show();

    }

    //Function to check "is Data Set Correctly" before send to mainhospital registration activity
    private boolean data_valid(){
        boolean validation = false;
        int date_time_counter_tracker = 1;
        if (date_time_counter<=1&&Defult_time.equals(hour_from1.getText())&&Defult_time.equals(hour_to1.getText())){
            if (date_time_counter==date_time_counter_tracker){validation=true;}
            else {date_time_counter_tracker=date_time_counter_tracker+1;}
        }
        if (date_time_counter<=2&&Defult_time.equals(hour_from2.getText())&&Defult_time.equals(hour_to2.getText())
                &&"Monday".equals(String.valueOf(day_from2.getSelectedItem()))&&"Monday".equals(String.valueOf(day_to2.getSelectedItem()))){
            if (date_time_counter==date_time_counter_tracker){validation=true;}
            else {date_time_counter_tracker=date_time_counter_tracker+1;}
        }
        if (date_time_counter<=3&&Defult_time.equals(hour_from3.getText())&&Defult_time.equals(hour_to3.getText())
                &&"Monday".equals(String.valueOf(day_from3.getSelectedItem()))&&"Monday".equals(String.valueOf(day_to3.getSelectedItem()))){
            if (date_time_counter==date_time_counter_tracker){validation=true;}
            else {validation=false;}
        }
        return  validation;
    }
}
