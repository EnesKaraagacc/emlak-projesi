package com.emlak.service;

import com.emlak.model.Emlak;
import com.emlak.repository.EmlakRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmlakService {

    private final EmlakRepository emlakRepository;

    public EmlakService(EmlakRepository emlakRepository) {
        this.emlakRepository = emlakRepository;
    }
    // Sistemdeki tüm emlak kayıtlarını döndür.
    public List<Emlak> getAll() {
        return emlakRepository.findAll();
    }
    // ID ile tek bir emlak kaydını getir.
    public Emlak getById(Long id) {
        return emlakRepository.findById(id).orElse(null);
    }
    // Yeni bir emlak kaydını veritabanına kaydet.
    public Emlak save(Emlak emlak) {
        return emlakRepository.save(emlak);
    }
    // Belirli bir emlak kaydını sil.
    public void delete(Long id) {
        emlakRepository.deleteById(id);
    }
    // Tür ve durum filtresine göre emlakları listele.
    public List<Emlak> search(String tur, String durum) {
        return emlakRepository.findByTurAndDurum(tur, durum);
    }

    // Belirli bir işletmeye ait emlakları getir.
    public List<Emlak> getByIsletmeId(Long isletmeId) {
        return emlakRepository.findAll().stream()
                .filter(e -> e.getIsletme() != null && e.getIsletme().getId().equals(isletmeId))
                .collect(Collectors.toList());
    }
    // Var olan bir emlak kaydını güncelle.
    public Emlak update(Long id, Emlak yeniEmlak) {
        Emlak mevcut = emlakRepository.findById(id).orElseThrow(() -> new RuntimeException("Emlak bulunamadı"));
        mevcut.setTur(yeniEmlak.getTur());
        mevcut.setMetrekare(yeniEmlak.getMetrekare());
        mevcut.setOdaSayisi(yeniEmlak.getOdaSayisi());
        mevcut.setKat(yeniEmlak.getKat());
        mevcut.setBinaKati(yeniEmlak.getBinaKati());
        mevcut.setIsinma(yeniEmlak.getIsinma());
        mevcut.setDurum(yeniEmlak.getDurum());
        mevcut.setMusteri(yeniEmlak.getMusteri());
        mevcut.setIsletme(yeniEmlak.getIsletme());
        return emlakRepository.save(mevcut);
    }

}
