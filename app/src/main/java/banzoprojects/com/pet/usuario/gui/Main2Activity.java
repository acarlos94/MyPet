package banzoprojects.com.pet.usuario.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        setContentView(R.layout.activity_main2);
        listaAnimais = (ListView)findViewById(R.id.minhalista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, itens);


    }
}
