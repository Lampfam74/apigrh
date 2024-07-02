package sn.lamp.dev.service;

import java.util.List;
import java.util.Optional;

import sn.lamp.dev.model.Users;

public interface UserService {
	List<Users> getAll();
	Optional<Users> findById(Long id);
	Users save(Users Poin);
	 void deleteById(Long id);
}
