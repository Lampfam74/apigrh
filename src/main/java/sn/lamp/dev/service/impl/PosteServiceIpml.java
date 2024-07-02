package sn.lamp.dev.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.dev.model.Postes;
import sn.lamp.dev.repository.PostesRepository;
import sn.lamp.dev.service.PosteService;
@Service
public class PosteServiceIpml implements PosteService {

	@Autowired
	private  PostesRepository postesRepository;
	@Override
	public List<Postes> getAll() {
		// TODO Auto-generated method stub
		return postesRepository.findAll();
	}

	@Override
	public Postes findById(Long id) {
		// TODO Auto-generated method stub
		return postesRepository.findById(id).orElseThrow();
	}

	@Override
	public Postes save(Postes Pos) {
		// TODO Auto-generated method stub
		return postesRepository.save(Pos);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		postesRepository.deleteById(id);

	}

}
