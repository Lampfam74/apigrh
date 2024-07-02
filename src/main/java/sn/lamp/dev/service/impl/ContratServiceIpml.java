package sn.lamp.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.dev.model.Contrat;
import sn.lamp.dev.repository.ContratRepository;
import sn.lamp.dev.service.ContratService;
@Service
public class ContratServiceIpml implements ContratService {

	@Autowired
	private ContratRepository contratRepository;
	@Override
	public List<Contrat> getAll() {
		return contratRepository.findAll();
	}

	@Override
	public Contrat findById(Long id) {
		return contratRepository.findById(id).get();
	}

	@Override
	public Contrat save(Contrat cont) {
		return contratRepository.save(cont);
	}

	@Override
	public void deleteById(Long id) {
		contratRepository.deleteById(id);

	}

}
