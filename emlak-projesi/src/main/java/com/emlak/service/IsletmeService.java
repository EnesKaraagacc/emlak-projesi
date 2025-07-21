package com.emlak.service;

import com.emlak.model.Isletme;
import com.emlak.repository.IsletmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsletmeService {

    private final IsletmeRepository isletmeRepository;

    public IsletmeService(IsletmeRepository isletmeRepository) {
        this.isletmeRepository = isletmeRepository;
    }

    // Tüm işletmeleri getir.
    public List<Isletme> getAll() {
        return isletmeRepository.findAll();
    }

    // Yeni bir işletme kaydı oluştur.
    public Isletme save(Isletme isletme) {
        return isletmeRepository.save(isletme);
    }
}
