package com.porducer.designing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class org_regis extends AppCompatActivity implements CallBackInterface {

    Button Bussiness_hour,Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_regis);

        Bussiness_hour = findViewById(R.id.hosregis_button_bussinesshour);
        Location = findViewById(R.id.hosregis_button_location);

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
    }

    private View.OnClickListener Bussiness_Hour_Clicked = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        public void onClick(View v) {
            //Fragment
            fragment_bussinesshour fragment_bh = new fragment_bussinesshour();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_for_fragment, fragment_bh);
            ft.commit();
            // Set Callback in fragment
            fragment_bussinesshour.setCallback(org_regis.this);
            Bussiness_hour.setVisibility(4);
            Location.setVisibility(4);
        }
    };

    @SuppressLint("WrongConstant")
    @Override
    public void callbackMethod() {
        //Test call back
        Toast.makeText(getApplicationContext(), "Callback Online!",Toast.LENGTH_SHORT).show();
        Bussiness_hour.setVisibility(0);
        Location.setVisibility(0);
    }
}
