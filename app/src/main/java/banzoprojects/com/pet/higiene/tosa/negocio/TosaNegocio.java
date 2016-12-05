package banzoprojects.com.pet.higiene.tosa.negocio;

import android.content.Context;

import java.util.ArrayList;

import banzoprojects.com.pet.higiene.tosa.dao.TosaDAO;
import banzoprojects.com.pet.higiene.tosa.dominio.Tosa;

public class TosaNegocio {
    private TosaDAO tosaDAO;

    public TosaNegocio(Context context){
        tosaDAO = new TosaDAO(context);

    }

    public void cadastrarTosa(String dataTosa, String localTosa, String dataProxTosa, Long IdAnimal){
        Tosa tosa = new Tosa();
        tosa.setDataTosa(dataTosa);
        tosa.setLocalTosa(localTosa);
        tosa.setDataProxTosa(dataProxTosa);
        tosa.setIdAnimal(IdAnimal);



        Long idAnimal = tosaDAO.inserir(tosa);
        tosa.set_id(idAnimal);
    }

    public ArrayList<Tosa> getTodasTosas(String IdAnimal){
        return (ArrayList<Tosa>) tosaDAO.listaTosas(IdAnimal);
    }
}