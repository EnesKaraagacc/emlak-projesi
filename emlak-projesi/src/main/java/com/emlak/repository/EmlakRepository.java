package com.emlak.repository;

import com.emlak.model.Emlak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmlakRepository extends JpaRepository<Emlak, Long> {
    // Tür ve durum bilgisine göre emlakları getir.
    List<Emlak> findByTurAndDurum(String tur, String durum);

}
