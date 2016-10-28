package banzoprojects.com.pet.usuario.dominio;

/**
 * Created by Romilson on 27/10/2016.
 */


public class Usuario {
    private long _id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){

    }

    public Usuario(long id, String nome, String email, String senha){
        this._id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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