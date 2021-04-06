package com.example.h11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMain extends Fragment {
    EditText textWrite;
    TextView textRead;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        textWrite = view.findViewById(R.id.textWrite);
        textRead = view.findViewById(R.id.textRead);

    }

    public void disableEditText(){
        textWrite.setFocusable(false);
    }

    public void enableEditText(){
        textWrite.setFocusableInTouchMode(true);
    }

    public void setTextView(){
        String text = textWrite.getText().toString();
        textRead.setText(text);
    }

    public void setTextSize(int size){
        textRead.setTextSize(size);
    }

    public void setTextColor(int color){
        textRead.setTextColor(color);
    }

    public void setBackgroundColor(int color){
        textRead.setBackgroundColor(color);
    }

    public void setRows(int rows){
        textRead.setLines(rows);
    }

}
