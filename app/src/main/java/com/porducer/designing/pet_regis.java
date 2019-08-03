package com.porducer.designing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

public class pet_regis extends AppCompatActivity {

    TextView Birthdate;
    RadioGroup sex_radiogroup;
    DatePickerDialog datePickerDialog;
    Spinner species;
    EditText species_other,AnimalName,breed,color,OPD_HN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_regis);

        Birthdate = findViewById(R.id.petregis_textview_selectBirthday);
        sex_radiogroup = findViewById(R.id.petregis_radiogroup);
        species = findViewById(R.id.petregis_spinner_species);

        ArrayAdapter<CharSequence> spinner_adapter_day = ArrayAdapter.createFromResource(pet_regis.this.getApplicationContext(),R.array.species, android.R.layout.simple_spinner_item);
        spinner_adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        species.setAdapter(spinner_adapter_day);

        Birthdate.setOnClickListener(Birthdate_Clicked);
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
                            Birthdate.setText(String.format("%d/%d/%d", dayOfMonth, monthOfYear+1, year));
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    };
    private String get_sex(){
        String selected_sex;
        int selectedRadioButtonID = sex_radiogroup.getCheckedRadioButtonId();
        if (selectedRadioButtonID==-1){
            selected_sex = "No sex Selected";
        }
        else {
            RadioButton SelectedRB = findViewById(selectedRadioButtonID);
            selected_sex = SelectedRB.getText().toString();
        }
        return selected_sex;
    }
    private boolean data_validation(){
        boolean answer = false;
        if(species.getSelectedItem().toString().equals(getResources().getString(R.string.species_defult))
        &&AnimalName.getText().equals("")&&OPD_HN.getText().equals("")){
            answer = true;
        }
        return answer;
    }
}
