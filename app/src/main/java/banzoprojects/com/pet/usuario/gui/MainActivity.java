package banzoprojects.com.pet.usuario.gui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class MainActivity extends AppCompatActivity {
    private Button btnlogout;
    private Sessao sessao;
    private TextView tvBemVindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessao = new Sessao();

        String usuarioLogado = sessao.getUsuario().getNome();

//        if (sessao.logado() == false){
//            logout();
//        }

        btnlogout = (Button) findViewById(R.id.btnLogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logout();
            }
        });
        tvBemVindo = (TextView)findViewById(R.id.tvBemVindo);
        tvBemVindo.setText(usuarioLogado);

    }
    private void logout() {
        Usuario usuarioVazio = new Usuario();
        sessao.setUsuario(usuarioVazio);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}