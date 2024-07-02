package sn.lamp.dev.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.lamp.dev.model.Personal;
import sn.lamp.dev.repository.PersonalRepository;
import sn.lamp.dev.service.PersonalService;
@Service
public class PersonalServiceIpml implements PersonalService {
    @Autowired
	private PersonalRepository personalRepository;
	@Override
	public List<Personal> getAll() {
		// TODO Auto-generated method stub
		return personalRepository.findAll();
	}

	@Override
	public Optional<Personal> findById(Long id) {
		// TODO Auto-generated method stub
		return personalRepository.findById(id);
	}


	@Override
	public Personal save(Personal Per) {
		return personalRepository.save(Per);

		}



	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		personalRepository.deleteById(id);

	}

	@Override
	public Personal findByToken(String token) {
		return personalRepository.findByToken(token);
	}

}
