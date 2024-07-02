package sn.lamp.dev.service;

import java.util.List;

import sn.lamp.dev.model.HeureSup;

public interface HeureSupService {
	List<HeureSup> getAll();
	HeureSup findById(Long id);
	HeureSup save(HeureSup Heur);
	 void deleteById(Long id);
}
