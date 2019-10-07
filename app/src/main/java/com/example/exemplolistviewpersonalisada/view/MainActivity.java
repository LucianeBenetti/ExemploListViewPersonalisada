package com.example.exemplolistviewpersonalisada.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.exemplolistviewpersonalisada.R;
import com.example.exemplolistviewpersonalisada.controller.MainController;

public class MainActivity extends AppCompatActivity {
    private MainController control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainController(this);
    }

    public void salvar(View view) {
        control.salvarAction();
    }
}
