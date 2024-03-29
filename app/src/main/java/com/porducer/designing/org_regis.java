package com.porducer.designing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class org_regis extends AppCompatActivity implements CallBackInterface {

    Button Bussiness_hour,Location;
    Bundle data_from_fragment_bussiness_hour;
    ImageView add_picture;
    ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_regis);

        Bussiness_hour = findViewById(R.id.hosregis_button_bussinesshour);
        Location = findViewById(R.id.hosregis_button_location);
        add_picture = findViewById(R.id.hosregis_imageview_addpicture);
        scrollview = findViewById(R.id.hosregis_scrollview);

        // Spinner with CustomAdapter
        Spinner hos_service_spinner = (Spinner) findViewById(R.id.hos_service_spinner);
        String[] temp = getResources().getStringArray(R.array.hos_service);
        ArrayList<String> hos_service_list = new ArrayList<>();
        for (int counter=0;counter<temp.length;counter++){
            hos_service_list.add(temp[counter]);
        }
        //Construct the hospital custom spinner
        hospital_spinner_adapter hos_spinner_adapter = new hospital_spinner_adapter(this, hos_service_list);
        hos_service_spinner.setAdapter(hos_spinner_adapter);

        //OnClick listener
        Bussiness_hour.setOnClickListener(Bussiness_Hour_Clicked);
        add_picture.setOnClickListener(add_picture_Clicked);
    }

    private View.OnClickListener Bussiness_Hour_Clicked = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        public void onClick(View v) {
            //Fragment
            fragment_bussinesshour fragment_bh = new fragment_bussinesshour();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frame_for_fragment, fragment_bh);
            ft.addToBackStack(null);
            ft.commit();
            // Set Callback in fragment
            fragment_bussinesshour.setCallback(org_regis.this);
//            Bussiness_hour.setVisibility(4);
//            Location.setVisibility(4);
        }
    };
    private View.OnClickListener add_picture_Clicked = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        public void onClick(View v) {
            //Fragment
            fragmennt_Add_Picture fragment_bh = new fragmennt_Add_Picture();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frame_for_fragment, fragment_bh);
            ft.addToBackStack(null);
            ft.commit();
            scrollview.setScrollY(100);
            // Set Callback in fragment
            fragmennt_Add_Picture.setCallback(org_regis.this);
//            Bussiness_hour.setVisibility(4);
//            Location.setVisibility(4);
        }
    };

    @SuppressLint("WrongConstant")
    @Override
    public void callback_from_bussinesshour(Bundle data) {
        //Test call back
        //Toast.makeText(getApplicationContext(), "Callback Online!",Toast.LENGTH_SHORT).show();

        this.data_from_fragment_bussiness_hour = data;
        Bussiness_hour.setVisibility(0);
        Location.setVisibility(0);
    }

    @Override
    public void callback_from_addpic(Bundle data) {
        //Test call back
        Toast.makeText(getApplicationContext(), "Callback Online!",Toast.LENGTH_SHORT).show();
        //TODO Add data handling from add_pic

    }
}
