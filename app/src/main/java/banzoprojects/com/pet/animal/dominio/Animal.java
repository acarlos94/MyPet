package banzoprojects.com.pet.animal.dominio;


public class Animal {
    private Integer _id;
    private String nome;
    private String raca;
    private String sexo;
    private String cor;
    private String nascimento;
    private Double peso;
    private Double altura;
    private String tipo;
    private Integer idusuario;

    public Animal(){}


    public Integer getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Animal(Integer id, String nome, String raca, String sexo, String cor, String nascimento,
                  Double peso, Double altura, String tipo, Integer id_usuario) {

        this._id = id;
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.cor = cor;
        this.nascimento = nascimento;
        this.peso = peso;
        this.altura = altura;
        this.tipo = tipo;
        this.idusuario = id_usuario;
    }


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}