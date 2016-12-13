package banzoprojects.com.pet.animal.negocio;

import android.content.Context;

import banzoprojects.com.pet.animal.dao.AnimalDAO;
import banzoprojects.com.pet.animal.dominio.Animal;

public class AnimalNegocio {
    private AnimalDAO animalDAO;

    public AnimalNegocio(Context context){
        animalDAO = new AnimalDAO(context);
    }
    public void cadastrarAnimal(Animal animal){
        Long idAnimal = animalDAO.inserir(animal);
        animal.set_id(idAnimal);
    }
    public void apagarAnimal(Animal animal){
        animalDAO.deletarAnimal(animal);
    }
}

