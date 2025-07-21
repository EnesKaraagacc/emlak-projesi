package com.emlak.model;

import jakarta.persistence.*;

@Entity
public class AramaTalebi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "musteri_id", nullable = false)
    private Musteri musteri;

    @Column(nullable = false)
    private String tur;

    private Integer minMetrekare;
    private Integer maxMetrekare;
    private Integer minOda;
    private Integer maxOda;
    private String isinma;

    public AramaTalebi() {}

    public AramaTalebi(Long id, Musteri musteri, String tur,
                       Integer minMetrekare, Integer maxMetrekare,
                       Integer minOda, Integer maxOda, String isinma) {
        this.id = id;
        this.musteri = musteri;
        this.tur = tur;
        this.minMetrekare = minMetrekare;
        this.maxMetrekare = maxMetrekare;
        this.minOda = minOda;
        this.maxOda = maxOda;
        this.isinma = isinma;
    }

    // Getter ve setter
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Musteri getMusteri() { return musteri; }

    public void setMusteri(Musteri musteri) { this.musteri = musteri; }

    public String getTur() { return tur; }

    public void setTur(String tur) { this.tur = tur; }

    public Integer getMinMetrekare() { return minMetrekare != null ? minMetrekare : 0; }

    public void setMinMetrekare(Integer minMetrekare) { this.minMetrekare = minMetrekare; }

    public Integer getMaxMetrekare() { return maxMetrekare != null ? maxMetrekare : Integer.MAX_VALUE; }

    public void setMaxMetrekare(Integer maxMetrekare) { this.maxMetrekare = maxMetrekare; }

    public Integer getMinOda() { return minOda != null ? minOda : 0; }

    public void setMinOda(Integer minOda) { this.minOda = minOda; }

    public Integer getMaxOda() { return maxOda != null ? maxOda : Integer.MAX_VALUE; }

    public void setMaxOda(Integer maxOda) { this.maxOda = maxOda; }

    public String getIsinma() { return isinma; }

    public void setIsinma(String isinma) { this.isinma = isinma; }
}
