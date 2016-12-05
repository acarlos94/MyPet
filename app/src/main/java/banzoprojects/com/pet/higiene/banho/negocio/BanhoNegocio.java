package banzoprojects.com.pet.higiene.banho.negocio;

import android.content.Context;

import java.util.ArrayList;

import banzoprojects.com.pet.higiene.banho.dao.BanhoDAO;
import banzoprojects.com.pet.higiene.banho.dominio.Banho;

public class BanhoNegocio {
    private BanhoDAO banhoDAO;

    public BanhoNegocio(Context context){
        banhoDAO = new BanhoDAO(context);

    }

    public void cadastrarBanho(String dataBanho, String localBanho, String dataProxBanho, Long IdAnimal){
        Banho banho = new Banho();
        banho.setDataBanho(dataBanho);
        banho.setLocalBanho(localBanho);
        banho.setDataProxBanho(dataProxBanho);
        banho.setIdAnimal(IdAnimal);



        Long idAnimal = banhoDAO.inserir(banho);
        banho.set_id(idAnimal);
    }

    public ArrayList<Banho> getTodosBanhos(String IdAnimal){
        return (ArrayList<Banho>) banhoDAO.listaBanhos(IdAnimal);
    }
}

