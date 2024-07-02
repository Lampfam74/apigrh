package sn.lamp.dev.service;

import java.util.List;
import sn.lamp.dev.model.Postes;


public interface PosteService {
	List<Postes> getAll();
	Postes findById(Long id);
	Postes save(Postes Pos);
	 void deleteById(Long id);
}
