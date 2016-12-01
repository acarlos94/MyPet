package banzoprojects.com.pet.usuario.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.negocio.AnimalNegocio;

public class Main2Activity extends Activity {
    private ListView listaAnimais;
    private AnimalDAO animalDAO;
    private AnimalNegocio negocio;
    private String[]itens = {"Angra","recife"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaAnimais = (ListView)findViewById(R.id.minhalista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, itens);
        listaAnimais.setAdapter(adapter);
        listaAnimais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Teste de clique", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
