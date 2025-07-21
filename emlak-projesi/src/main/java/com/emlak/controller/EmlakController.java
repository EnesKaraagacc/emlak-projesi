package com.emlak.controller;

import com.emlak.model.Emlak;
import com.emlak.service.EmlakService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emlak")
public class EmlakController {

    private final EmlakService emlakService;

    public EmlakController(EmlakService emlakService) {
        this.emlakService = emlakService;
    }
    // Tüm emlakları getir. Eğer işletmenin ID'si verilmişse sadece o işletmeye ait olanları döndür.
    @GetMapping
    public List<Emlak> getAll(@RequestParam(value = "isletmeId", required = false) Long isletmeId) {
        if (isletmeId != null) {
            return emlakService.getByIsletmeId(isletmeId);
        }
        return emlakService.getAll();
    }
    // Belirli bir emlak kaydını ID ile getir.
    @GetMapping("/{id}")
    public Emlak getById(@PathVariable Long id) {
        return emlakService.getById(id);
    }
    // Yeni bir emlak kaydı oluştur.
    @PostMapping
    public Emlak create(@RequestBody Emlak emlak) {
        return emlakService.save(emlak);
    }
    // Tür ve durum bilgisine göre emlak araması yap.
    @GetMapping("/arama")
    public List<Emlak> search(
            @RequestParam String tur,
            @RequestParam(defaultValue = "aktif") String durum
    ) {
        return emlakService.search(tur, durum);
    }
    // Var olan bir emlak kaydını güncelle.
    @PutMapping("/{id}")
    public Emlak update(@PathVariable Long id, @RequestBody Emlak emlak) {
        return emlakService.update(id, emlak);
    }
    // Belirli bir emlak kaydını sil.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        emlakService.delete(id);
    }
}
