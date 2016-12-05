package banzoprojects.com.pet.usuario.dominio;

/**
 * Created by Romilson on 27/10/2016.
 */


public class Usuario {
    private long _idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){

    }

//    public Usuario(Long id, String nome, String email, String senha){
//        this._idUsuario = id;
//        this.nome = nome;
//        this.email = email;
//        this.senha = senha;
//    }

    public Long get_idUsuario() {
        return _idUsuario;
    }

    public void set_idUsuario(Long id) {
        this._idUsuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}