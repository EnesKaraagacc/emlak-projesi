package com.emlak.controller;

import com.emlak.model.Isletme;
import com.emlak.service.IsletmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isletme")
public class IsletmeController {

    private final IsletmeService isletmeService;

    public IsletmeController(IsletmeService isletmeService) {
        this.isletmeService = isletmeService;
    }

    // Sistemdeki tüm işletmeleri getir.
    @GetMapping
    public List<Isletme> getAll() {
        return isletmeService.getAll();
    }

    // Yeni bir işletme ekle.
    @PostMapping
    public Isletme create(@RequestBody Isletme isletme) {
        return isletmeService.save(isletme);
    }
}
