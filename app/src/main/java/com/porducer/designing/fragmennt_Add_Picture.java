package com.porducer.designing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


public class fragmennt_Add_Picture extends Fragment {

    static CallBackInterface mcallback;
    ImageView Addpic;
    EditText Description;
    Spinner Service_type;
    Button Confirm;
    Bundle data_from_addpic;

    public fragmennt_Add_Picture() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Addpic = view.findViewById(R.id.faddpic_imageview_addimage);
        Description = view.findViewById(R.id.faddpic_editview_description);
        Service_type = view.findViewById(R.id.faddpic_spinner_service);
        Confirm = view.findViewById(R.id.faddpic_button_confirm);

        Confirm.setOnClickListener(Confirm_Clicked);
        Addpic.setOnClickListener(Addpic_Clicked);

        //TODO : android how to upload image from gallery to firebase storage
        //TODO : Get data to Spinner service type

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_picture, container, false);
    }

    //Method of Setting interface call back
    public static void setCallback(CallBackInterface callback) {
        mcallback = callback;
    }
    private View.OnClickListener Confirm_Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            if (mcallback != null) {
                mcallback.callback_from_addpic(data_from_addpic);//TODO Add data bundle to call back)
            }
        }
    };
    private View.OnClickListener Addpic_Clicked = new View.OnClickListener() {
        public void onClick(View v) {

        }
    };


}
