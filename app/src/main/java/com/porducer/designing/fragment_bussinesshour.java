package com.porducer.designing;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class fragment_bussinesshour extends Fragment {


    static CallBackInterface mcallback;
    Button Confirm,Add_time,B2;
    int date_time_counter;
    bussinessshour_date_time viewgroup1,viewgroup2,viewgroup3;
    TimePickerDialog picker;
    TextView hour_from1,hour_to1,hour_from2,hour_to2,hour_from3,hour_to3;
    TextView Header;

    String h_from1,h_to1,h_from2,h_to2,h_from3,h_to3;

    //Constructor
    public fragment_bussinesshour() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        date_time_counter = 1;
        Confirm = view.findViewById(R.id.fragment_button_confirm);
        Add_time = view.findViewById(R.id.fragment_button_addtime);
        viewgroup1 = view.findViewById(R.id.bussinessshour_date_time1);
        viewgroup2 = view.findViewById(R.id.bussinessshour_date_time2);
        viewgroup3 = view.findViewById(R.id.bussinessshour_date_time3);
        hour_from1 = viewgroup1.hour_from;
        hour_to1 = viewgroup1.hour_to;
        Header = view.findViewById(R.id.fragment_textview_header);

        Confirm.setOnClickListener(Confirm_Clicked);
        Add_time.setOnClickListener(Add_time_Clicked);
        hour_from1.setOnClickListener(hf_clicked);
        hour_to1.setOnClickListener(hf_clicked);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bussinesshour, container, false);
    }

    //Method of Setting interface call back
    public static void setCallback(CallBackInterface callback){
        mcallback=callback;
    }

    private View.OnClickListener Confirm_Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            if(mcallback != null){
                mcallback.callbackMethod();
            }
        }
    };

    private View.OnClickListener Add_time_Clicked = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        public void onClick(View v) {
            switch (date_time_counter){
                case 1:
                    viewgroup2.setVisibility(0);
                    date_time_counter++;
                    break;
                case 2:
                    viewgroup3.setVisibility(0);
                    date_time_counter++;
                    break;
                default:
                    date_time_counter=1;
                    viewgroup2.setVisibility(4);
                    viewgroup3.setVisibility(4);
                    break;
            }
        }
    };
    private View.OnClickListener hf_clicked = new View.OnClickListener() {
        public void onClick(View v) {
            String temp;
            temp = onTimeSet2();
            if (v==hour_from1){hour_from1.setText(temp);}
            else if(v==hour_to1){hour_to1.setText(temp);}
        }
    };

    private void data_send(){
        Bundle date_time_intent = new Bundle();
        //TODO Get data back to activity
    }
    //Create time picker graphic
    public String onTimeSet() {
        String temp;
        final Integer[] hourMinute1 = new Integer[1];
        final Integer[] hourMinute2 = new Integer[1];
        final Calendar cldr = Calendar.getInstance();
        int hour = cldr.get(Calendar.HOUR_OF_DAY);
        int minutes = cldr.get(Calendar.MINUTE);
        // time picker dialog
        picker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                hourMinute1[0] = sHour;
                hourMinute2[0] = sMinute;
            }
        }, hour, minutes, true);
        picker.show();
        temp = String.valueOf(hourMinute1[0]) + ":" + String.valueOf(hourMinute2[0]);
        return temp;
    }
    public String onTimeSet2() {
        String temp;
        final Integer[] hourMinute1 = new Integer[1];
        final Integer[] hourMinute2 = new Integer[1];
        TimePickerDialog.OnTimeSetListener timePickerListener =
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour,
                                          int selectedMinute) {
                        hourMinute1[0] = selectedHour;
                        hourMinute2[0] = selectedMinute;
                    }
                };
        temp = String.valueOf(hourMinute1[0]) + ":" + String.valueOf(hourMinute2[0]);
        return temp;
    }

}
