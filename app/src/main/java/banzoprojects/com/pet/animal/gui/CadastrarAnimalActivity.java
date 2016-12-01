package banzoprojects.com.pet.animal.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.negocio.AnimalNegocio;
import banzoprojects.com.pet.infra.GuiUtil;
import banzoprojects.com.pet.infra.Validacao;
import banzoprojects.com.pet.usuario.dominio.Usuario;
import banzoprojects.com.pet.usuario.gui.LoginActivity;
import banzoprojects.com.pet.usuario.gui.MainActivity;

public class CadastrarAnimalActivity extends AppCompatActivity {
    AnimalNegocio animalNegocio = new AnimalNegocio(this);
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    GuiUtil guiUtil =GuiUtil.getGuiUtil();
    private Button btnSalvarAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_animal);
        btnSalvarAnimal = (Button)findViewById(R.id.btnSalvarAnimal);
    }
    public void onButtonClickSalvarAnimal(View v){

        if (v.getId()== R.id.btnSalvarAnimal){
            EditText nome =(EditText)findViewById(R.id.etNomeAnimal);
            EditText sexo =(EditText)findViewById(R.id.etSexoAnimal);
            EditText raca =(EditText)findViewById(R.id.etRacaAnimal);
            EditText cor =(EditText)findViewById(R.id.etCorAnimal);
            EditText peso =(EditText)findViewById(R.id.etPesoAnimal);
            EditText nascimento =(EditText)findViewById(R.id.etNascimentoAnimal);
            EditText tipo =(EditText)findViewById(R.id.etTipo);
            EditText altura =(EditText)findViewById(R.id.etAlturaAnimal);





            String nomeAnimal = nome.getText().toString();
            String sexoAnimal = sexo.getText().toString();
            String racaAnimal = raca.getText().toString();
            String corAnimal = cor.getText().toString();
            String pesoAnimal = peso.getText().toString();
            String nascimentoAnimal = nascimento.getText().toString();
            String tipoAnimal = tipo.getText().toString();
            String alturaAnimal = altura.getText().toString();
            Usuario usuario = new Usuario();
           ;


            animalNegocio.cadastrarAnimal(nomeAnimal,racaAnimal,sexoAnimal,corAnimal,nascimentoAnimal,pesoAnimal,alturaAnimal,
                    tipoAnimal);
            guiUtil.toastLong(getApplicationContext(), "Animal cadastrado");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }else if (v.getId() == R.id.btnVoltarParaLogin){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }

    }
}