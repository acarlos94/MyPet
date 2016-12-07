package banzoprojects.com.pet.alimentacao.dominio;

import banzoprojects.com.pet.animal.dominio.Animal;

/**
 * Created by Antonio on 01/12/2016.
 */

public class Alimento {

    private Long _id;
    private String nome;
    private String recomendado;
    private Long idAnimal;
    private Animal animal;


    public Alimento() {
    }

    public Alimento(Long id, String nome, String recomendado) {
        this._id = id;
        this.nome = nome;
        this.recomendado = recomendado;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(String recomendado) {
        this.recomendado = recomendado;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
