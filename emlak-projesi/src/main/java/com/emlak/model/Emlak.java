package com.emlak.model;

import jakarta.persistence.*;

@Entity
public class Emlak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musteri_id")
    private Musteri musteri;

    @ManyToOne
    @JoinColumn(name = "isletme_id")
    private Isletme isletme;

    // Tüm emlak bilgileri
    private String tur; // kiralik veya satilik
    private Integer metrekare;
    private Integer odaSayisi;
    private Integer kat;
    private Integer binaKati;
    private String isinma;
    private String durum;

    public Emlak() {
    }

    public Emlak(Long id, Musteri musteri, Isletme isletme, String tur, Integer metrekare,
                 Integer odaSayisi, Integer kat, Integer binaKati, String isinma, String durum) {
        this.id = id;
        this.musteri = musteri;
        this.isletme = isletme;
        this.tur = tur;
        this.metrekare = metrekare;
        this.odaSayisi = odaSayisi;
        this.kat = kat;
        this.binaKati = binaKati;
        this.isinma = isinma;
        this.durum = durum;
    }
    // Getter ve setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Isletme getIsletme() {
        return isletme;
    }

    public void setIsletme(Isletme isletme) {
        this.isletme = isletme;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public Integer getMetrekare() {
        return metrekare;
    }

    public void setMetrekare(Integer metrekare) {
        this.metrekare = metrekare;
    }

    public Integer getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(Integer odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public Integer getKat() {
        return kat;
    }

    public void setKat(Integer kat) {
        this.kat = kat;
    }

    public Integer getBinaKati() {
        return binaKati;
    }

    public void setBinaKati(Integer binaKati) {
        this.binaKati = binaKati;
    }

    public String getIsinma() {
        return isinma;
    }

    public void setIsinma(String isinma) {
        this.isinma = isinma;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
