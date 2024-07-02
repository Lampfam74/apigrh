package sn.lamp.dev.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.lamp.dev.model.Pointages;
@Repository
public interface PointagesRepository extends JpaRepository<Pointages, Long>{
	@Query("SELECT DISTINCT poin FROM Pointages poin  where poin.token=:poin and poin.date=:date")
	Pointages findByToken(String poin,Date date);
	@Query("SELECT DISTINCT poin FROM Pointages poin  where poin.token=:poin and poin.date=:date")
	List<Pointages> count_pointage(String poin,Date date);
	long count();
}
