package banzoprojects.com.pet.usuario.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.infra.GuiUtil;
import banzoprojects.com.pet.infra.Validacao;
import banzoprojects.com.pet.usuario.negocio.UsuarioNegocio;

public class RegistroActivity extends AppCompatActivity{

    UsuarioNegocio usuarioNegocio = new UsuarioNegocio(this);
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    GuiUtil guiUtil =GuiUtil.getGuiUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void onButtonClickUsuario(View v) {
        if (v.getId() == R.id.btnCadastrar){
            EditText nome = (EditText) findViewById(R.id.etNome);
            EditText email = (EditText) findViewById(R.id.etEmail);
            EditText senha = (EditText) findViewById(R.id.etSenha);

            String nomeString = nome.getText().toString();
            String emailString = email.getText().toString();
            String senhaString = senha.getText().toString();

            if (validacaoUtil.isFieldEmpty(nome)){
                nome.requestFocus();
                nome.setError(getString(R.string.error_nome_vazio));
                return;
            }
            if (validacaoUtil.isFieldEmpty(email)){
                email.requestFocus();
                email.setError(getString(R.string.error_email_vazio));
                return;
            }
            if (validacaoUtil.isFieldEmpty(senha)){
                senha.requestFocus();
                senha.setError(getString(R.string.error_senha_vazia));
                return;
            }
            if (!validacaoUtil.hasSpacePassword(senha)){
                senha.requestFocus();
                senha.setError(getString(R.string.error_espaco_branco));
                return;
            }
            if (!validacaoUtil.isEmailValid(emailString)){
                email.requestFocus();
                email.setError(getString(R.string.email_invalido));
                return;
            }
            else{
                try {
                    usuarioNegocio.cadastrarUsuario(nomeString,emailString,senhaString);
                    guiUtil.toastLong(getApplicationContext(), "Cadastro realizado com sucesso");
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);

                }catch (Exception exception){
                    guiUtil.toastLong(getApplicationContext(),exception.getMessage());
                }
            }
        }else if (v.getId() == R.id.btnVoltarParaLogin){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
