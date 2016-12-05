package banzoprojects.com.pet.usuario.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.negocio.AnimalNegocio;

public class Main2Activity extends Activity {
    private ListView listaAnimais;
    private AnimalDAO animalDAO;
    private AnimalNegocio negocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void onButtonClick(View v){
        if (v.getId() == R.id.btnVacina){

        }


    }



}
