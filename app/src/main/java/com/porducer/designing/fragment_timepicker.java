package com.porducer.designing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_timepicker extends Fragment {

    Spinner day_from,day_to;
    EditText hour_from,hour_to;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timepicker1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hour_from = view.findViewById(R.id.fragmenttimepick_edittext_hourfrom);
        hour_to = view.findViewById(R.id.fragmenttimepick_edittext_hourto);
    }
}
