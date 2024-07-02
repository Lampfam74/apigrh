package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.dev.model.Conges;
@Repository
public interface CongeRepository extends JpaRepository<Conges, Long>{

}
