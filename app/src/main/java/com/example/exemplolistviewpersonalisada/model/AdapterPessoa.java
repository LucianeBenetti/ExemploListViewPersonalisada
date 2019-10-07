package com.example.exemplolistviewpersonalisada.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.exemplolistviewpersonalisada.R;
import java.util.List;
public class AdapterPessoa extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Pessoa> listPessoas;
    private Context context;

    public AdapterPessoa(List<Pessoa> listPessoas, Context context) {
        this.listPessoas = listPessoas;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listPessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return listPessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add (Pessoa p){
        listPessoas.add(p);
        this.notifyDataSetChanged();
    }

    public void remove (Pessoa p){
        listPessoas.remove(p);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //resgatar a pessoa da lista
        final Pessoa pessoa = listPessoas.get(position);
        //resgatar o layout do item
        view = inflater.inflate(R.layout.item_listview_pessoa, null);
        //resgatar os elementos para saida dos dados
        TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvIdade = view.findViewById(R.id.tvIdade);
        ImageView ivIdade = view.findViewById(R.id.ivMaiorIdade);
        //mandar dados para o layout
        tvNome.setText(pessoa.getNome());
        tvIdade.setText(String.valueOf(pessoa.getIdade()));

        if(PessoaBO.isMaiorIdade(pessoa)){
            ivIdade.setImageResource(R.drawable.maior_idade);
        }else {
            ivIdade.setImageResource(R.drawable.menor_idade);
       }
        //ao clicar na imagem, mostrar um toast dizendo se é de menor ou de maior
        ivIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PessoaBO.isMaiorIdade(pessoa)) {
                    Toast.makeText(context, "De maior", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "De menor", Toast.LENGTH_SHORT).show();
                    remove(pessoa);
                }
            }
        });
        return view;
    }
}
