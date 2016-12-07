package banzoprojects.com.pet.alimentacao.negocio;

import android.content.Context;

import java.util.ArrayList;

import banzoprojects.com.pet.alimentacao.dao.AlimentoDao;
import banzoprojects.com.pet.alimentacao.dominio.Alimento;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.infra.Sessao;

/**
 * Created by Antonio on 02/12/2016.
 */

public class AlimentoNegocio {
    private AlimentoDao alimentoDao;
    Animal animal = new Animal();

    public AlimentoNegocio(Context context){
        alimentoDao = new AlimentoDao(context);

    }

    public void cadastrarAlimento(String nome, String recomendado){
        Sessao sessao = new Sessao();
        Alimento alimento = new Alimento();
        alimento.setNome(nome);
        alimento.setRecomendado(recomendado);
        //alimento.setIdAnimal(animal.get_id());



        Long idAlimento = alimentoDao.inserir(alimento);
        alimento.set_id(idAlimento);
    }

    public ArrayList<Alimento> getTodosAlimentos(){
        return (ArrayList<Alimento>) alimentoDao.listaAlimentoRecomendado();
    }
}
