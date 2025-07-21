package com.emlak.controller;

import com.emlak.model.Musteri;
import com.emlak.service.MusteriService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musteri")
public class MusteriController {

    private final MusteriService musteriService;

    public MusteriController(MusteriService musteriService) {
        this.musteriService = musteriService;
    }

    // Tüm müşteri kayıtlarını getir.
    @GetMapping
    public List<Musteri> getAll() {
        return musteriService.getAll();
    }

    // Belirli bir müşteriyi ID ile getir.
    @GetMapping("/{id}")
    public Musteri getById(@PathVariable Long id) {
        return musteriService.getById(id);
    }

    // Yeni müşteri kaydı oluştur.
    @PostMapping
    public Musteri create(@RequestBody Musteri musteri) {
        return musteriService.save(musteri);
    }

    // Var olan bir müşteriyi güncelle (ID ile eşleştirerek).
    @PutMapping("/{id}")
    public Musteri update(@PathVariable Long id, @RequestBody Musteri musteri) {
        musteri.setId(id);
        return musteriService.save(musteri);
    }

    // Müşteri kaydını sil.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musteriService.delete(id);
    }
}

