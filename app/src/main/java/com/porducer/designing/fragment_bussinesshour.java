package com.porducer.designing;

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
    Button Confirm;

    //Constructor
    public fragment_bussinesshour() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Confirm = view.findViewById(R.id.fragment_button_confirm);
        ConstraintLayout cLayout = view.findViewById(R.id.fragment_constraintlayout);

        //Add Date&Time Layout Programatically//
        //params.setMargins(0, 0, 0, 0);
        bussinessshour_date_time date_time = new bussinessshour_date_time(getContext());
        //date_time.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        cLayout.addView(date_time);

        Confirm.setOnClickListener(Confirm_Clicked);
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

    public void data_send(){
        //TODO : Add data send intent to hospital register activity
    }
}
