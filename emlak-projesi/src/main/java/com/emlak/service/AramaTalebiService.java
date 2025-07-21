package com.emlak.service;

import com.emlak.model.AramaTalebi;
import com.emlak.model.Emlak;
import com.emlak.repository.AramaTalebiRepository;
import com.emlak.repository.EmlakRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AramaTalebiService {

    private final AramaTalebiRepository aramaTalebiRepository;
    private final EmlakRepository emlakRepository;

    public AramaTalebiService(AramaTalebiRepository aramaTalebiRepository, EmlakRepository emlakRepository) {
        this.aramaTalebiRepository = aramaTalebiRepository;
        this.emlakRepository = emlakRepository;
    }

    public AramaTalebi save(AramaTalebi talep) {
        return aramaTalebiRepository.save(talep);
    }

    public AramaTalebi getById(Long id) {
        return aramaTalebiRepository.findById(id).orElse(null);
    }

    public List<AramaTalebi> getAll() {
        return aramaTalebiRepository.findAll();
    }

    public List<Emlak> uygunEmlaklariBul(Long talepId) {
        AramaTalebi talep = getById(talepId);
        if (talep == null) return List.of();
        return uygunEmlaklariBul(talep);
    }

    // filtreleme
    public List<Emlak> uygunEmlaklariBul(AramaTalebi talep) {
        return emlakRepository.findAll().stream()
                .filter(e -> e.getTur() != null && e.getTur().equalsIgnoreCase(talep.getTur()))
                .filter(e -> e.getIsinma() != null && e.getIsinma().equalsIgnoreCase(talep.getIsinma()))
                .filter(e -> e.getMetrekare() >= talep.getMinMetrekare() && e.getMetrekare() <= talep.getMaxMetrekare())
                .filter(e -> e.getOdaSayisi() >= talep.getMinOda() && e.getOdaSayisi() <= talep.getMaxOda())
                .collect(Collectors.toList());
    }
}
