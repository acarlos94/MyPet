//package banzoprojects.com.pet.vacina.negocio;
//
//
//import android.content.Context;
//import java.util.ArrayList;
//import banzoprojects.com.pet.animal.dominio.Animal;
//import banzoprojects.com.pet.vacina.dao.VacinaDAO;
//import banzoprojects.com.pet.vacina.dominio.Vacina;
//
//public class VacinaNegocio {
//    private VacinaDAO vacinaDAO;
//    Animal animal = new Animal();
//
//    public VacinaNegocio(Context context){
//        vacinaDAO = new VacinaDAO(context);
//    }
//    public void cadastrarVacina(String nome, String data, String local, String dataproxima){
//        Vacina vacina = new Vacina();
//        vacina.setNome_vacina(nome);
//        vacina.setData_vacina(data);
//        vacina.setLocal(local);
//        vacina.setProxima_vacina(dataproxima);
//        vacina.setIdAnimal(animal.get_idAnimal());
//
//        Long idVacina = vacinaDAO.inserir(vacina);
//        vacina.set_id(idVacina);
//    }
//    public ArrayList<Vacina> getTodasVacinas(){
//        return (ArrayList<Vacina>) vacinaDAO.listaVacinas();
//    }
//}
