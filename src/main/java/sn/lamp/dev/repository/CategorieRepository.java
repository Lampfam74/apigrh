package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.dev.model.Categorie;
@Repository
public interface CategorieRepository  extends JpaRepository<Categorie, Long>{

}
