package com.example.h11;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSettings extends Fragment {

    Switch switch2;
    EditText textSize;
    EditText textColor;
    EditText backgroundColor;
    EditText editRows;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        switch2 = view.findViewById(R.id.switch2);
        textSize = view.findViewById(R.id.editSize);
        textColor = view.findViewById(R.id.editTextColor);
        backgroundColor = view.findViewById(R.id.editBackgroundColor);
        editRows = view.findViewById(R.id.editRows);
    }

    public String getSwitchState(){
        if (switch2.isChecked()){
            return "EDITABLE";
        }
        else {
            return "NOT_EDITABLE";
        }
    }

    public int getTextSize(){
        return Integer.parseInt(textSize.getText().toString());
    }

    private int colorParser(String text){
        if (text.equals("Black")){
            return getResources().getColor(R.color.black, null);
        }
        else if (text.equals("Red")){
            return getResources().getColor(R.color.red, null);
        }
        else if (text.equals("White")){
            return getResources().getColor(R.color.white, null);
        }
        else {
            return getResources().getColor(R.color.black, null);
        }
    }

    public int getTextColor(){
        String text = textColor.getText().toString();
        return colorParser(text);
    }

    public int getBackgroundColor(){
        String text = backgroundColor.getText().toString();
        return colorParser(text);
    }

    public int getRows(){
        return Integer.parseInt(editRows.getText().toString());
    }

}
