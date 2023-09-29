package br.com.techsolutions.findpros.repository;

import br.com.techsolutions.findpros.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {}
