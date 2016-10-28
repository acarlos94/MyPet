package banzoprojects.com.pet.usuario.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.infra.GuiUtil;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.infra.Validacao;
import banzoprojects.com.pet.usuario.negocio.UsuarioNegocio;

;

public class LoginActivity extends AppCompatActivity {
    UsuarioNegocio usuarioNegocio = new UsuarioNegocio(this);
    GuiUtil guiUtil = GuiUtil.getGuiUtil();
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    private Sessao sessao = Sessao.getInstancia();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    public void onButtonClick(View v){

        if (v.getId()==R.id.btnLogar) {
            EditText usuarioEmail = (EditText) findViewById(R.id.etEmail);
            EditText usuarioSenha = (EditText) findViewById(R.id.etSenha);
            String email = usuarioEmail.getText().toString();
            String senha = usuarioSenha.getText().toString();

            if (validacaoUtil.isFieldEmpty(usuarioEmail)) {
                usuarioEmail.requestFocus();
                usuarioEmail.setError("Digite seu email");
                return;
            }
            if (validacaoUtil.isFieldEmpty(usuarioSenha)) {
                usuarioSenha.requestFocus();
                usuarioSenha.setError("digite sua senha");
                return;
            }
            if (!validacaoUtil.isEmailValid(email)) {
                usuarioEmail.requestFocus();
                usuarioEmail.setError("Email invalido");
                return;
            } else {
                try {
                    usuarioNegocio.login(email, senha);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (v.getId()==R.id.tvRegistrar){
            Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
            startActivity(intent);
        }
    }
}
