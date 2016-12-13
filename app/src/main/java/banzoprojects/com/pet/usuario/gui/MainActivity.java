package banzoprojects.com.pet.usuario.gui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.animal.gui.CadastrarAnimalActivity;
import banzoprojects.com.pet.infra.AnimalAdapter;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class MainActivity extends AppCompatActivity {
    private Button btnlogout, btnCadastrarAnimal;
    private Sessao sessao = new Sessao();
    private TextView tvBemVindo;
    private Animal animal;
    private AnimalDAO animalDAO;


    ListView animaisListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long user = sessao.getUsuario().get_idUsuario();
        animaisListView = (ListView)findViewById(R.id.listaAnimais);
        List<Animal> listaAnimais = animalDAO.getAnimais(user);
        AnimalAdapter adapter = new AnimalAdapter(listaAnimais,getApplicationContext());
        animaisListView.setAdapter(adapter);




//        String usuarioLogado = sessao.getUsuario().getNome();

        btnlogout = (Button) findViewById(R.id.btnLogout);
        btnCadastrarAnimal = (Button)findViewById(R.id.btnCadastrarAnimal);
//
//        ListView listView = (ListView)findViewById(R.id.minhalista);
//        long idAnimal = animal.get_idAnimal();
//        final ArrayList<Animal> animais = ani.getAnimais(Sessao.getUsuario().get_idUsuario());
//        ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1, animais);
//
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Animal animal = animais.get(position);
//
//                Sessao.setAnimal(animal);
//                Intent intent = new Intent(getApplicationContext(), OpcoesAnimalActivity.class);
//                startActivity(intent);
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
//        tvBemVindo.setText(usuarioLogado);


    }
    private void logout() {
        Usuario usuarioVazio = new Usuario();
        sessao.setUsuario(usuarioVazio);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

}