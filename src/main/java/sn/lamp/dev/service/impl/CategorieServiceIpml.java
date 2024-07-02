/**
 * 
 */
package sn.lamp.dev.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.lamp.dev.model.Categorie;
import sn.lamp.dev.repository.CategorieRepository;
import sn.lamp.dev.service.CategorieService;
@Service
public class CategorieServiceIpml implements CategorieService {

	@Autowired
	private CategorieRepository categorieRepository;
	@Override
	public List<Categorie> getAll() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie findById(Long id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id).orElse(new Categorie());
	}

	@Override
	public Categorie save(Categorie Poin) {
		// TODO Auto-generated method stub
		return categorieRepository.save(Poin);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);

	}

}
