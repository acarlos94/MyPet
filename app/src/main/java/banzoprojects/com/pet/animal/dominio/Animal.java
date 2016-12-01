package banzoprojects.com.pet.animal.dominio;


public class Animal {

    private Long _id;
    private String nome;
    private String raca;
    private String sexo;
    private String cor;
    private String nascimento;
    private String peso;
    private String altura;
    private String tipo;
    private Long idUsuario;

    public Animal() {
    }


    public Animal(Long id, String nome, String raca, String sexo, String cor, String nascimento,
                  String peso, String altura, String tipo, Long idUsuario) {
        this._id = id;
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.cor = cor;
        this.nascimento = nascimento;
        this.peso = peso;
        this.altura = altura;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }

    public Long get_id() {

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}