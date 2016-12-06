package banzoprojects.com.pet.animal.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.negocio.AnimalNegocio;
import banzoprojects.com.pet.vacina.gui.CadastroVacina;

public class OpcoesAnimalActivity extends Activity {

    private AnimalDAO animalDAO;
    private AnimalNegocio negocio;
//    private Sessao sessao;
//    private EditText etNomeVacina, etDataVacina,etLocal, etProximaVacina;
    private Button btnVacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_animal);
//        Animal animalSelecionado = sessao.getAnimal();
//        salvarVacina = (Button)findViewById(R.id.btnSalvarVacina);
        btnVacinas = (Button)findViewById(R.id.btnVacinas);
        btnVacinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroVacina.class);
                startActivity(intent);
            }
        });


    }



}
