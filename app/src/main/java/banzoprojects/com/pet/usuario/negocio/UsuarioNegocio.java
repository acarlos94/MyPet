package banzoprojects.com.pet.usuario.negocio;

import android.content.Context;

import banzoprojects.com.pet.infra.Criptografia;
import banzoprojects.com.pet.infra.Sessao;
import banzoprojects.com.pet.usuario.dao.UsuarioDAO;
import banzoprojects.com.pet.usuario.dominio.Usuario;


public class UsuarioNegocio {
    private UsuarioDAO usuarioDAO;
    private Criptografia criptografia = new Criptografia();
//    private Criptografia criptografia = new Criptografia();

    public UsuarioNegocio(Context context){

        usuarioDAO = new UsuarioDAO(context);
    }

    public void cadastrarUsuario(String nome, String email, String senha) throws Exception {

        Usuario usuario = usuarioDAO.getUsuario(email);

        if (usuario != null) {
            throw new Exception("Usuario ja cadastrado");

        }

        String senhaMascarada = criptografia.criptografarSenha(senha);
        usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senhaMascarada);

        long idUsuario = usuarioDAO.inserir(usuario);

        usuario.set_idUsuario(idUsuario);

    }


    public void login(String email, String senha) throws Exception {

        String senhaMascarada = criptografia.criptografarSenha(senha);

        Usuario usuarioVerificado = usuarioDAO.getUsuario(email,senhaMascarada);

        if(usuarioVerificado == null) {
            throw new Exception("Usuário ou senha inválidos!");
        }
        else {
            Sessao.setUsuario(usuarioVerificado);
        }

    }
}