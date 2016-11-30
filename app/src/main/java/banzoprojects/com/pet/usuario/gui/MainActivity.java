package banzoprojects.com.pet.usuario.gui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.animal.gui.CadastrarAnimalActivity;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class MainActivity extends AppCompatActivity {
    private Button btnlogout, btnCadastrarAnimal;
    private Sessao sessao;
    private TextView tvBemVindo;
    private Animal animal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.minhalista);

        sessao = new Sessao();

        String usuarioLogado = sessao.getUsuario().getNome();
//        ArrayAdapter<Animal> novoAnimal = new ArrayAdapter<Animal>();


//        if (sessao.logado() == false){
//            logout();
//        }

        btnlogout = (Button) findViewById(R.id.btnLogout);
        btnCadastrarAnimal = (Button)findViewById(R.id.btnCadastrarAnimal);
        btnCadastrarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastrarAnimalActivity.class);
                startActivity(intent);
            }
        });
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