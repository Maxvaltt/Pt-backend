package pt.pt.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Treeni {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nimi;
    private String viikonpaiva;
    private String kesto;

   
    @JsonIgnoreProperties("treenis")
    private String kuvaus;
    

    public Treeni() {
    }
    
    public Treeni(String nimi, String viikonpaiva, String kesto, String kuvaus) {
        this.nimi = nimi;
        this.viikonpaiva = viikonpaiva;
        this.kesto = kesto;
        this.kuvaus = kuvaus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getViikonpaiva() {
        return viikonpaiva;
    }

    public void setViikonpaiva(String viikonpaiva) {
        this.viikonpaiva = viikonpaiva;
    }

    public String getKesto() {
        return kesto;
    }

    public void setKesto(String kesto) {
        this.kesto = kesto;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }


}
