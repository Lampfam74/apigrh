package sn.lamp.dev.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.dev.model.Pointages;
import sn.lamp.dev.repository.PointagesRepository;
import sn.lamp.dev.service.PointageService;
@Service
public class PointagesServiceIpml implements PointageService {
	@Autowired
	private PointagesRepository pointagesRepository;
	@Override
	public List<Pointages> getAll() {
		return pointagesRepository.findAll();
	}

	@Override
	public Optional<Pointages> findById(Long id) {
		// TODO Auto-generated method stub
		return pointagesRepository.findById(id);
	}

	@Override
	public Pointages save(Pointages Poin) {
		// TODO Auto-generated method stub
		return pointagesRepository.save(Poin);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		pointagesRepository.deleteById(id);
	}

	@Override 
	public Pointages findByToken(String token,Date d) {
		// TODO Auto-generated method stub
		return pointagesRepository.findByToken(token,d);
	}

	@Override
		public long count_pointage(String token,Date d) {
			// TODO Auto-generated method stub
			long count;
			List<Pointages> counta;
			counta =pointagesRepository.count_pointage(token,d);
			//count=p.size();
			count=((PointagesRepository) counta).count();
			
			return count;
			
		}


}
