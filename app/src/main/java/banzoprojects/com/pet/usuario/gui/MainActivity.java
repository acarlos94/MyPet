package banzoprojects.com.pet.usuario.gui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.animal.gui.CadastrarAnimalActivity;
import banzoprojects.com.pet.animal.gui.OpcoesAnimalActivity;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class MainActivity extends AppCompatActivity {
    private Button btnlogout, btnCadastrarAnimal;
    private Sessao sessao;
    private TextView tvBemVindo;
    private Animal animal;
    private ListView listaAnimal;
    private AnimalDAO ani;
    private String[]itens = {"Vacina","Banho", "Calendario"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ani = new AnimalDAO(this);
        sessao = new Sessao();
        String usuarioLogado = sessao.getUsuario().getNome();
        btnlogout = (Button) findViewById(R.id.btnLogout);
        btnCadastrarAnimal = (Button)findViewById(R.id.btnCadastrarAnimal);

        listaAnimal = (ListView)findViewById(R.id.minhalista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,ani.getAnimais(Sessao.getUsuario().get_idUsuario()));

        listaAnimal.setAdapter(adapter);
        listaAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Sessao.setAnimal(ani.getAnimal(id));
                String nome = Sessao.getAnimal().get_idAnimal().toString();
                Toast.makeText(getApplicationContext(),nome, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), OpcoesAnimalActivity.class);
                startActivity(intent);
            }
        });

//        listaAnimal.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Sessao.setAnimal(ani.getAnimal(id));
//                Intent intent = new Intent(getApplicationContext(), OpcoesAnimalActivity.class);
//                startActivity(intent);
//
//                return false;
//            }
//        });

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