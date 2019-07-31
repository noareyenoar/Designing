package com.porducer.designing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class fragment_bussinesshour extends Fragment {

    Spinner day_from,day_to;
    EditText hour_from,hour_to;
    static CallBackInterface mcallback;
    Button Confirm;

    //Constructor
    public fragment_bussinesshour() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hour_from = view.findViewById(R.id.fragmenttimepick_edittext_hourfrom);
        hour_to = view.findViewById(R.id.fragmenttimepick_edittext_hourto);
        Confirm = view.findViewById(R.id.fragmenttimepick_button_confirm);

        //Spinner adapter
        String[] day = getResources().getStringArray(R.array.day);
        ArrayAdapter<String> day_adapter = new ArrayAdapter<String>(getContext(),R.layout.fragment_bussinesshour, day);
        day_from.setAdapter(day_adapter);
        day_to.setAdapter(day_adapter);

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
}
