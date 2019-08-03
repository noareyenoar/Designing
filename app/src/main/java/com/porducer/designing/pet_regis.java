package com.porducer.designing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

public class pet_regis extends AppCompatActivity {

    TextView Birthdate;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_regis);

        Birthdate = findViewById(R.id.petregis_textview_selectBirthday);

        Birthdate.setOnClickListener(Birthdate_Clicked);
        // TODO : Add and work on this xml




    }
    private View.OnClickListener Birthdate_Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            // calender class's instance and get current date , month and year from calender
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR); // current year
            int mMonth = c.get(Calendar.MONTH); // current month
            int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
            // date picker dialog
            datePickerDialog = new DatePickerDialog(pet_regis.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text
                            Birthdate.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    };
}
