package banzoprojects.com.pet.infra;

import banzoprojects.com.pet.animal.dominio.Animal;
import banzoprojects.com.pet.usuario.dominio.Usuario;

public class Sessao {
    private static Sessao instancia = new Sessao();
    private static Usuario usuario;
    private static Animal animal;

    public static Usuario getUsuario(){
        return usuario;
    }

    public static void setUsuario(Usuario usuario){
        Sessao.usuario = usuario;
    }

    public static Sessao getInstancia(){ return  instancia;}



}