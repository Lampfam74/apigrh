package sn.lamp.dev.service;

import java.util.List;
import java.util.Optional;

import sn.lamp.dev.model.TypeContrat;

public interface TypeContratService {
	List<TypeContrat> getAll();
	Optional<TypeContrat> findById(Long id);
	TypeContrat save(TypeContrat Poin);
	 void deleteById(Long id);
}
