package sn.lamp.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.dev.model.HeureSup;
import sn.lamp.dev.repository.HeureSupRepository;
import sn.lamp.dev.service.HeureSupService;
@Service
public class HeureSupServiceIpml implements HeureSupService {

	@Autowired
	private HeureSupRepository heureSupRepository;
	@Override
	public List<HeureSup> getAll() {
		// TODO Auto-generated method stub
		return heureSupRepository.findAll();
	}

	@Override
	public HeureSup findById(Long id) {
		// TODO Auto-generated method stub
		return heureSupRepository.findById(id).orElse(new HeureSup());
	}

	@Override
	public HeureSup save(HeureSup Heur) {
		// TODO Auto-generated method stub
		return heureSupRepository.save(Heur);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		heureSupRepository.deleteById(id);

	}

}
