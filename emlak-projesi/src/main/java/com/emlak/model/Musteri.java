package com.emlak.model;

import jakarta.persistence.*;

@Entity
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;
    private String evTel;
    private String cepTel;
    private String email;

    @ManyToOne
    @JoinColumn(name = "isletme_id")
    private Isletme isletme;

    // Boş constructor
    public Musteri() {}

    // Tüm alanlarla nesne oluşturmak için kullanılan constructor
    public Musteri(Long id, String ad, String soyad, String evTel, String cepTel, String email, Isletme isletme) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.evTel = evTel;
        this.cepTel = cepTel;
        this.email = email;
        this.isletme = isletme;
    }

    // Getter ve setter'lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getEvTel() { return evTel; }
    public void setEvTel(String evTel) { this.evTel = evTel; }

    public String getCepTel() { return cepTel; }
    public void setCepTel(String cepTel) { this.cepTel = cepTel; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Isletme getIsletme() { return isletme; }
    public void setIsletme(Isletme isletme) { this.isletme = isletme; }
}
