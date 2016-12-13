package banzoprojects.com.pet.animal.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.animal.negocio.AnimalNegocio;
import banzoprojects.com.pet.infra.GuiUtil;
import banzoprojects.com.pet.infra.Validacao;
import banzoprojects.com.pet.usuario.gui.MainActivity;

public class CadastrarAnimalActivity extends AppCompatActivity {
    AnimalNegocio animalNegocio = new AnimalNegocio(this);
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    GuiUtil guiUtil =GuiUtil.getGuiUtil();
    private Button btnSalvarAnimal;
    Spinner tipo;
    Spinner raca;
    Spinner tipoAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_animal);
        btnSalvarAnimal = (Button)findViewById(R.id.btnSalvarAnimal);

        tipo = (Spinner)findViewById(R.id.spinnerTipo);
        ArrayAdapter adapterTipo = ArrayAdapter.createFromResource(this,R.array.sexo,android.R.layout.simple_spinner_item);
        tipo.setAdapter(adapterTipo);

        raca = (Spinner)findViewById(R.id.spinnerRaca);
        ArrayAdapter adapteRaca = ArrayAdapter.createFromResource(this, R.array.racas, android.R.layout.simple_spinner_item);
        raca.setAdapter(adapteRaca);

        tipoAnimal = (Spinner)findViewById(R.id.spinnerTipoAnimal);
        ArrayAdapter adapteTipoAnimal = ArrayAdapter.createFromResource(this, R.array.tipoAnimal, android.R.layout.simple_spinner_item);
        tipoAnimal.setAdapter(adapteTipoAnimal);

    }
    private Animal criarAnimal(){
        String sexo = tipo.getSelectedItem().toString();
        String racas = raca.getSelectedItem().toString();
        String tipo = tipoAnimal.getSelectedItem().toString();
        EditText nome =(EditText)findViewById(R.id.etNomeAnimal);
        EditText cor =(EditText)findViewById(R.id.etCorAnimal);
        EditText peso =(EditText)findViewById(R.id.etPesoAnimal);
        EditText nascimento =(EditText)findViewById(R.id.etNascimentoAnimal);
        EditText altura =(EditText)findViewById(R.id.etAlturaAnimal);
        Animal animal = new Animal();
        animal.setNome(nome.getText().toString());
        animal.setCor(cor.getText().toString());
        animal.setRaca(racas);
        animal.setTipo(tipo);
        animal.setSexo(sexo);
        animal.setPeso(peso.getText().toString());
        animal.setNascimento(nascimento.getText().toString());
        animal.setAltura(altura.getText().toString());
        return animal;

    }
    public void onButtonClickSalvarAnimal(View v){

        if (v.getId()== R.id.btnSalvarAnimal){
            Animal animal = criarAnimal();
            animalNegocio.cadastrarAnimal (animal);
            guiUtil.toastLong(getApplicationContext(), "Animal cadastrado");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }


    }
}
