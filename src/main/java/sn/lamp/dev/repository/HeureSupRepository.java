package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.dev.model.HeureSup;
@Repository
public interface HeureSupRepository extends JpaRepository<HeureSup, Long>{

}
