package banzoprojects.com.pet.animal.dominio;


import banzoprojects.com.pet.usuario.dominio.Usuario;

public class Animal {

    private Long _id;
    private String nome;
    private String raca;
    private String sexo;
    private String cor;
//    mudar atributo para Date
    private String nascimento;
    private String peso;
    private String altura;
    private String tipo;
    private Usuario usuario ;

    public Animal() {
    }

    public Long get_idAnimal() {
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNascimento() {
        return nascimento;
    }


    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}