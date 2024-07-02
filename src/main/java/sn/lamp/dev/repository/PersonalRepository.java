package sn.lamp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.lamp.dev.model.Personal;
@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
	@Query("SELECT DISTINCT per FROM Personal per  where per.token=:token")
	Personal findByToken(String token);
}
