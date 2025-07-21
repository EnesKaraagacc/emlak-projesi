package com.emlak.service;

import com.emlak.model.Musteri;
import com.emlak.repository.MusteriRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusteriService {

    private final MusteriRepository musteriRepository;

    public MusteriService(MusteriRepository musteriRepository) {
        this.musteriRepository = musteriRepository;
    }

    // Tüm müşterileri getir.
    public List<Musteri> getAll() {
        return musteriRepository.findAll();
    }

    // ID ile tek bir müşteri bilgisini getir.
    public Musteri getById(Long id) {
        return musteriRepository.findById(id).orElse(null);
    }

    // Yeni müşteri kaydı ekler ya da var olanı güncelle.
    public Musteri save(Musteri musteri) {
        return musteriRepository.save(musteri);
    }

    // Müşteri kaydını sil.
    public void delete(Long id) {
        musteriRepository.deleteById(id);
    }


}
