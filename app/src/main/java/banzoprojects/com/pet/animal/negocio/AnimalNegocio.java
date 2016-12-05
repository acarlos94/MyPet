package banzoprojects.com.pet.animal.negocio;

import android.content.Context;

import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dominio.Usuario;

/**
 * Created by Romilson on 28/10/2016.
 */

public class AnimalNegocio {
    private AnimalDAO animalDAO;
    Usuario usuario = new Usuario();

    public AnimalNegocio(Context context){
        animalDAO = new AnimalDAO(context);

    }

    public void cadastrarAnimal(String nome, String raca, String sexo, String cor, String nascimento,
                                String peso, String altura, String tipo){
        Sessao sessao = new Sessao();
        Animal animal = new Animal();
        animal.setNome(nome);
        animal.setRaca(raca);
        animal.setSexo(sexo);
        animal.setCor(cor);
        animal.setNascimento(nascimento);
        animal.setPeso(peso);
        animal.setAltura(altura);
        animal.setTipo(tipo);
//        animal.setIdUsuario(usuario.get_idUsuario());



        Long idAnimal = animalDAO.inserir(animal);
        animal.set_id(idAnimal);
    }

//    public ArrayList<Animal> getTodosAnimais(){
//        return (ArrayList<Animal>) animalDAO.listaAnimais();
//    }
}

