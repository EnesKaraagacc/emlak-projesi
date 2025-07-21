package com.emlak.model;

import jakarta.persistence.*;

@Entity
public class Isletme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String yetkili;
    private String adres;
    private String telefon;
    private String fax;

    // Parametresiz constructor
    public Isletme() {
    }

    // Tüm alanları içeren constructor
    public Isletme(Long id, String ad, String yetkili, String adres, String telefon, String fax) {
        this.id = id;
        this.ad = ad;
        this.yetkili = yetkili;
        this.adres = adres;
        this.telefon = telefon;
        this.fax = fax;
    }

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getYetkili() {
        return yetkili;
    }

    public void setYetkili(String yetkili) {
        this.yetkili = yetkili;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
