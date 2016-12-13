package banzoprojects.com.pet.animal.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.alimentacao.gui.AlimentacaoActivity;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.negocio.AnimalNegocio;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.vacina.gui.CadastroVacina;

public class OpcoesAnimalActivity extends AppCompatActivity {

    private AnimalDAO animalDAO;
    private AnimalNegocio negocio;
    private Button btnVacinas;
    private Sessao sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_animal);
        sessao = new Sessao();
//        Animal animalSelecionado = sessao.getAnimal();
//        salvarVacina = (Button)findViewById(R.id.btnSalvarVacina);
//        btnVacinas = (Button)findViewById(R.id.btnVacinas);
//        btnVacinas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), CadastroVacina.class);
//                startActivity(intent);
//            }
//        });

    }
    public void onButtonClickOpcoes(View v){
        if(v.getId()==R.id.btnVacinas){
            Intent intent = new Intent(getApplicationContext(), CadastroVacina.class);

                startActivity(intent);
        }else if(v.getId()==R.id.btnAlimentacao){
            Intent intent = new Intent(getApplicationContext(), AlimentacaoActivity.class);

                startActivity(intent);
        }else if (v.getId()==R.id.btnApagarAnimal){

            negocio.apagarAnimal(sessao.getAnimal());
            Intent intent = new Intent(getApplicationContext(), AlimentacaoActivity.class);


        }

    }



}
