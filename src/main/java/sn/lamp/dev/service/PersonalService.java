package sn.lamp.dev.service;

import java.util.List;
import java.util.Optional;

import sn.lamp.dev.model.Personal;

public interface PersonalService {
List<Personal> getAll();
Optional<Personal> findById(Long id);
Personal save(Personal Per);
 void deleteById(Long id);
 Personal findByToken(String token);
}
