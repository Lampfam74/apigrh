package sn.lamp.dev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.dev.model.TypeContrat;
import sn.lamp.dev.repository.TypeContratRepository;
import sn.lamp.dev.service.TypeContratService;
@Service
public class TypeContratServiceIpml implements TypeContratService {
    @Autowired
    private TypeContratRepository contratRepository;
	@Override
	public List<TypeContrat> getAll() {
		// TODO Auto-generated method stub
		return contratRepository.findAll();
	}

	@Override
	public Optional<TypeContrat> findById(Long id) {
		// TODO Auto-generated method stub
		return contratRepository.findById(id);
	}

	@Override
	public TypeContrat save(TypeContrat Poin) {
		// TODO Auto-generated method stub
		return contratRepository.save(Poin);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		contratRepository.deleteById(id);

	}

}
