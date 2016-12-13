package banzoprojects.com.pet.usuario.gui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.animal.gui.CadastrarAnimalActivity;
import banzoprojects.com.pet.animal.gui.OpcoesAnimalActivity;
import banzoprojects.com.pet.infra.AnimalAdapter;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class MainActivity extends AppCompatActivity {
    private Button btnlogout, btnCadastrarAnimal;
    private Sessao sessao = new Sessao();
    private TextView tvBemVindo;
    private Animal animal = new Animal();
    private AnimalDAO animalDAO = new AnimalDAO(this);



    ListView animaisListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String usuarioLogado = sessao.getUsuario().getNome();
        btnlogout = (Button) findViewById(R.id.btnLogout);
        btnCadastrarAnimal = (Button)findViewById(R.id.btnCadastrarAnimal);
        tvBemVindo = (TextView)findViewById(R.id.tvBemVindo);
        tvBemVindo.setText(usuarioLogado);
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
        long user = sessao.getUsuario().get_idUsuario();
        animaisListView = (ListView) findViewById(R.id.listaAnimais);
        final ArrayList<Animal> listaAnimais = animalDAO.getAnimais(user);
        final AnimalAdapter adapter = new AnimalAdapter(listaAnimais, getApplicationContext());
        animaisListView.setAdapter(adapter);
        animaisListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position , long id) {
                Animal animal = (Animal)parent.getAdapter().getItem(position);
                sessao.setAnimal(animal);
                
                Intent intent = new Intent(getApplicationContext(), OpcoesAnimalActivity.class);
                startActivity(intent);
            }
        });
    }
    private void logout() {
        Usuario usuarioVazio = new Usuario();
        sessao.setUsuario(usuarioVazio);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}