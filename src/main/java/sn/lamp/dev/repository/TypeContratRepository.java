package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.dev.model.TypeContrat;
@Repository
public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {

}
