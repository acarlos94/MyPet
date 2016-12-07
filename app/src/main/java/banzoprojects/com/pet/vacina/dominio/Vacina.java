package banzoprojects.com.pet.vacina.dominio;


import banzoprojects.com.pet.animal.dominio.Animal;

public class Vacina {
    private long _id;
    private String nome_vacina;
    private String data_vacina;
    private String local;
    private String proxima_vacina;
    private long idAnimal;
    private Animal animal;

    public Vacina(){}

    public Vacina(long id, String nome_vacina, String data_vacina, String local, String proxima_vacina) {
        this._id = id;
        this.nome_vacina = nome_vacina;
        this.data_vacina = data_vacina;
        this.local = local;
        this.proxima_vacina = proxima_vacina;
        this.animal = animal;

    }
    public Long get_id() {

        return _id;
    }
    public void set_id(long _id){this._id=_id;}

    public String getNome_vacina(){return nome_vacina;}

    public void setNome_vacina(String nome_vacina){this.nome_vacina=nome_vacina;}

    public String getData_vacina(){return data_vacina;}

    public void setData_vacina(String data_vacina){this.data_vacina=data_vacina;}

    public String getLocal(){return local;}

    public void setLocal(String local){this.local=local;}

    public String getProxima_vacina(){return proxima_vacina;}

    public void setProxima_vacina(String proxima_vacina){this.proxima_vacina=proxima_vacina;}

    public void setIdAnimal(long idAnimal){this.idAnimal=idAnimal;}

    public long getIdAnimal(){return idAnimal;}

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal){
            this.animal = animal;
    }
}
