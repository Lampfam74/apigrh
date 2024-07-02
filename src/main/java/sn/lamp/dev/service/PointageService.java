package sn.lamp.dev.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import sn.lamp.dev.model.Pointages;

public interface PointageService {
	List<Pointages> getAll();
	Optional<Pointages> findById(Long id);
	Pointages save(Pointages Poin);
	 void deleteById(Long id);
	 Pointages findByToken(String token,Date d);
	long count_pointage(String token, Date D);
}
