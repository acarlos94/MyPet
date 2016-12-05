package banzoprojects.com.pet.higiene.banho.dominio;



public class Banho {

    private Long _id;
    private String dataBanho;
    private String localBanho;
    private String dataProxBanho;
    private Long idAnimal;

    public Banho() {
    }

    public Banho(Long id, String dataBanho, String localBanho, String dataProxBanho, Long idAnimal) {
        this._id = id;
        this.dataBanho = dataBanho;
        this.localBanho = localBanho;
        this.dataProxBanho = dataProxBanho;
        this.idAnimal = idAnimal;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getDataBanho() {
        return dataBanho;
    }

    public void setDataBanho(String dataBanho) {
        this.dataBanho = dataBanho;
    }

    public String getLocalBanho() {
        return localBanho;
    }

    public void setLocalBanho(String localBanho) {
        this.localBanho = localBanho;
    }


    public String getDataProxBanho() {
        return dataProxBanho;
    }

    public void setDataProxBanho(String dataProxBanho) {
        this.dataProxBanho = dataProxBanho;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
}