package com.porducer.designing;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class bussinessshour_date_time extends FrameLayout {

    Spinner day_from,day_to;
    EditText hour_from,hour_to;
    public bussinessshour_date_time(@NonNull Context context) {
        super(context);
        bindobject();
    }

    public bussinessshour_date_time(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bindobject();
    }

    public bussinessshour_date_time(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bindobject();
    }

    public bussinessshour_date_time(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        bindobject();
    }

    private void bindobject(){
        inflate(getContext(),R.layout.viewgroup_date_time,this);
        hour_from = findViewById(R.id.vg_edittext_timefrom);
        hour_to = findViewById(R.id.vg_edittext_timeto);
        day_from = findViewById(R.id.vg_spinner_dayfrom);
        day_to = findViewById(R.id.vg_spinner_dayto);

        //Spinner adapter
        ArrayAdapter<CharSequence> spinner_adapter_day = ArrayAdapter.createFromResource(getContext().getApplicationContext(),R.array.day, android.R.layout.simple_spinner_item);
        spinner_adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day_from.setAdapter(spinner_adapter_day);
        day_to.setAdapter(spinner_adapter_day);
    }
}
