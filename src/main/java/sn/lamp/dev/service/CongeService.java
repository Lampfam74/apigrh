package sn.lamp.dev.service;

import java.util.List;

import sn.lamp.dev.model.Conges;

public interface CongeService {
	List<Conges> getAll();
	Conges findById(Long id);
	Conges save(Conges Poin);
	 void deleteById(Long id);
}
