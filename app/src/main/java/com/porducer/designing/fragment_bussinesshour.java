package com.porducer.designing;

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
import android.widget.FrameLayout;

public class fragment_bussinesshour extends Fragment {


    static CallBackInterface mcallback;
    Button Confirm,Add_time;
    int date_time_counter;
    bussinessshour_date_time viewgroup1,viewgroup2,viewgroup3;

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

        Confirm.setOnClickListener(Confirm_Clicked);
        Add_time.setOnClickListener(Add_time_Clicked);
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

    private void validate_to_send(){

    }

    private void data_send(){
        Bundle date_time_intent = new Bundle();

    }
}
