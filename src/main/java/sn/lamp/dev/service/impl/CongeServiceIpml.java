package sn.lamp.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.dev.model.Conges;
import sn.lamp.dev.repository.CongeRepository;
import sn.lamp.dev.service.CongeService;
@Service
public class CongeServiceIpml implements CongeService {

	@Autowired
	private CongeRepository congeRepository;
	@Override
	public List<Conges> getAll() {
		// TODO Auto-generated method stub
		return congeRepository.findAll();
	}

	@Override
	public Conges findById(Long id) {
		// TODO Auto-generated method stub
		return congeRepository.findById(id).orElse(null);
	}

	@Override
	public Conges save(Conges Poin) {
		// TODO Auto-generated method stub
		return congeRepository.save(Poin);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		congeRepository.deleteById(id);

	}

}
