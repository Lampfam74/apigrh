package sn.lamp.dev.service;

import java.util.List;

import sn.lamp.dev.model.Categorie;


public interface CategorieService {
	List<Categorie> getAll();
	Categorie findById(Long id);
	Categorie save(Categorie Poin);
	 void deleteById(Long id);
}
