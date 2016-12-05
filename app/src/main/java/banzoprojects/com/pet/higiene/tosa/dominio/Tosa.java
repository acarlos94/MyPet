package banzoprojects.com.pet.higiene.tosa.dominio;


public class Tosa {
    private Long _id;
    private String dataTosa;
    private String localTosa;
    private String dataProxTosa;
    private Long idAnimal;

    public Tosa() {
    }

    public Tosa(Long id, String dataTosa, String localTosa, String dataProxTosa, Long idAnimal) {
        this._id = id;
        this.dataTosa = dataTosa;
        this.localTosa = localTosa;
        this.dataProxTosa = dataProxTosa;
        this.idAnimal = idAnimal;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getDataTosa() {
        return dataTosa;
    }

    public void setDataTosa(String dataTosa) {
        this.dataTosa = dataTosa;
    }

    public String getLocalTosa() {
        return localTosa;
    }

    public void setLocalTosa(String localTosa) {
        this.localTosa = localTosa;
    }

    public String getDataProxTosa() {
        return dataProxTosa;
    }

    public void setDataProxTosa(String dataProxTosa) {
        this.dataProxTosa = dataProxTosa;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
}
