package banzoprojects.com.pet.vacina.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.infra.GuiUtil;
import banzoprojects.com.pet.animal.gui.OpcoesAnimalActivity;
import banzoprojects.com.pet.vacina.negocio.VacinaNegocio;

public class CadastroVacina extends AppCompatActivity {
    private Button btnSalvarVacina;
    private VacinaNegocio vacinaNegocio;
    private GuiUtil guiUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vacina);
        btnSalvarVacina = (Button)findViewById(R.id.btnSalvarVacina);
        vacinaNegocio = new VacinaNegocio(this);

    }
    public void onButtonClickSalvarVacina(View v){
        if(v.getId()==R.id.btnSalvarVacina){
            EditText nomeVacina =(EditText)findViewById(R.id.etNomeVacina);
            EditText dataVacina =(EditText)findViewById(R.id.etDataVacina);
            EditText localVacina =(EditText)findViewById(R.id.etLocal);
            EditText proximaVacina =(EditText)findViewById(R.id.etProximaVacina);

            String nome = nomeVacina.getText().toString();
            String data = dataVacina.getText().toString();
            String local = localVacina.getText().toString();
            String prox = proximaVacina.getText().toString();

            vacinaNegocio.cadastrarVacina(nome,data,local,prox);
            Toast.makeText(getApplicationContext(),"Vacina Cadastrada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), OpcoesAnimalActivity.class);
            startActivity(intent);
        }
    }
}
