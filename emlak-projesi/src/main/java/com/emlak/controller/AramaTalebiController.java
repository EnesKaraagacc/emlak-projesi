package com.emlak.controller;

import com.emlak.model.AramaTalebi;
import com.emlak.model.Emlak;
import com.emlak.service.AramaTalebiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arama-talebi")
public class AramaTalebiController {

    private final AramaTalebiService aramaTalebiService;

    public AramaTalebiController(AramaTalebiService aramaTalebiService) {
        this.aramaTalebiService = aramaTalebiService;
    }

    // Talebi kaydet ve uygun emlakları getir.
    @PostMapping
    public List<Emlak> createAndGetUygunlar(@RequestBody AramaTalebi talep) {
        AramaTalebi kaydedilen = aramaTalebiService.save(talep);
        return aramaTalebiService.uygunEmlaklariBul(kaydedilen);
    }

    // Kayıt yapmadan sadece uygun emlakları getir.
    @PostMapping("/uygun-emlaklar")
    public List<Emlak> uygunlariBul(@RequestBody AramaTalebi talep) {
        return aramaTalebiService.uygunEmlaklariBul(talep);
    }

    @GetMapping
    public List<AramaTalebi> getAll() {
        return aramaTalebiService.getAll();
    }

    @GetMapping("/{id}/uygun-emlaklar")
    public List<Emlak> uygunEmlaklariGetir(@PathVariable Long id) {
        return aramaTalebiService.uygunEmlaklariBul(id);
    }
}
