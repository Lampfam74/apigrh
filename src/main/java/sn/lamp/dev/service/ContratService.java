package sn.lamp.dev.service;

import java.util.List;

import sn.lamp.dev.model.Contrat;

public interface ContratService {
	List<Contrat> getAll();
     Contrat findById(Long id);
	Contrat save(Contrat cont);
	 void deleteById(Long id);
}
