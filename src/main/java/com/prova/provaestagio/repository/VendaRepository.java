package com.prova.provaestagio.repository;

import com.prova.provaestagio.model.Venda;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByVendaDateBetween(OffsetDateTime dataInicial, OffsetDateTime dataFinal);

}
