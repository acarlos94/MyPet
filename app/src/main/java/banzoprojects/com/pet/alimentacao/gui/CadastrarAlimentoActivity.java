package banzoprojects.com.pet.alimentacao.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.alimentacao.negocio.AlimentoNegocio;
import banzoprojects.com.pet.infra.GuiUtil;
import banzoprojects.com.pet.infra.Validacao;

public class CadastrarAlimentoActivity extends AppCompatActivity {
    AlimentoNegocio alimentoNegocio = new AlimentoNegocio(this);
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    GuiUtil guiUtil = GuiUtil.getGuiUtil();
    private Button btnSalvarAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_alimento);
        btnSalvarAlimento = (Button) findViewById(R.id.btnSalvarAlimento);
    }

    public void onButtonClickSalvarAlimento(View v){
        if (v.getId() == R.id.btnSalvarAlimento){
            EditText nome =(EditText)findViewById(R.id.etNomeAlimento);
            EditText recomendado =(EditText)findViewById(R.id.etRecomendado);

            String nomeAlimento = nome.getText().toString();
            String aliRecomendado = recomendado.getText().toString();

            alimentoNegocio.cadastrarAlimento(nomeAlimento, aliRecomendado);
            guiUtil.toastLong(getApplicationContext(), "Alimento cadastrado");
            Intent intent = new Intent(getApplicationContext(), AlimentacaoActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
