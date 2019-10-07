package com.example.exemplolistviewpersonalisada.controller;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.exemplolistviewpersonalisada.R;
import com.example.exemplolistviewpersonalisada.model.AdapterPessoa;
import com.example.exemplolistviewpersonalisada.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private Activity activity;
    private EditText editNome;
    private EditText editIdade;
    private ListView lvPessoas;
    private List<Pessoa> listPessoas;
    private AdapterPessoa adapterPessoa;

    public MainController(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editIdade = activity.findViewById(R.id.editIdade);
        lvPessoas = activity.findViewById(R.id.lvPessoas);
        configListView();

    }

    private void configListView() {
        listPessoas = new ArrayList<>();
        listPessoas.add(new Pessoa("José", 59));
        listPessoas.add(new Pessoa("João", 40));
        listPessoas.add(new Pessoa("Maria", 35));
        adapterPessoa = new AdapterPessoa(listPessoas, activity);
        lvPessoas.setAdapter(adapterPessoa);
    }

    public void salvarAction(){
        Pessoa p = new Pessoa();
        p.setNome(editNome.getText().toString());
        p.setIdade(editIdade.getText().toString());
        adapterPessoa.add(p);
    }
}
