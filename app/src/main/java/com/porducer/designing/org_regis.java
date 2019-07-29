package com.porducer.designing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class org_regis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_regis);

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
    }
}
