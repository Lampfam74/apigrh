package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.lamp.dev.model.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

}
