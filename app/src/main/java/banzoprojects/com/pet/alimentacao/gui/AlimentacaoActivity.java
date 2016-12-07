package banzoprojects.com.pet.alimentacao.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.alimentacao.dao.AlimentoDao;
import banzoprojects.com.pet.infra.Sessao;

public class AlimentacaoActivity extends AppCompatActivity {
    private TextView tvRecomendado, tvNaoRecomendado;
    private ListView listaRecomendado, listaNaoRecomendado;
    private AlimentoDao ali;
    private Button btnCadastrarAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacao);
        ali = new AlimentoDao(this);

        listaRecomendado = (ListView)findViewById(R.id.lvRecomendado);
        ArrayAdapter<String> adapterRecomendado = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,ali.getAlimentosRecomendado(Sessao.getAnimal().get_idAnimal()));
        listaRecomendado.setAdapter(adapterRecomendado);


        listaNaoRecomendado = (ListView)findViewById(R.id.lvNaoRecomendado);
        ArrayAdapter<String> adapterNaoRecomendado = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,ali.getAlimentosNaoRecomendado(Sessao.getAnimal().get_idAnimal()));
        listaNaoRecomendado.setAdapter(adapterNaoRecomendado);

        tvRecomendado = (TextView)findViewById(R.id.tvRecomendados);
        tvNaoRecomendado = (TextView)findViewById(R.id.tvNaoRecomendado);

        btnCadastrarAlimento = (Button)findViewById(R.id.btnCadastrarAlimento);
        btnCadastrarAlimento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastrarAlimentoActivity.class);
                startActivity(intent);
            }
        });
    }
}
