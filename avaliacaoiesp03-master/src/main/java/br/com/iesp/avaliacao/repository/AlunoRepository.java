package br.com.iesp.avaliacao.repository;

import br.com.iesp.avaliacao.microservice.AlunoFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoFinal, Long> {
}
