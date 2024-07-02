package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.dev.model.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
