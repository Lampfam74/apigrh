package sn.lamp.dev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import sn.lamp.dev.model.HeureSup;
import sn.lamp.dev.service.impl.HeureSupServiceIpml;

@RestController
@RequestMapping("/api/v1")
@Tag(name ="heure sup controller " ,description = "all crud heure sup controller"  )
public class HeureSupController {
	@Autowired
	private HeureSupServiceIpml heureSupServiceIpml;

	@GetMapping("/HeureSup")
	public ResponseEntity<List<HeureSup>> getAll() {
		return ResponseEntity.ok(heureSupServiceIpml.getAll());
	}
	@PostMapping("/HeureSup")
	public ResponseEntity<HeureSup> addPostes(@RequestBody HeureSup P){
		return ResponseEntity.ok(heureSupServiceIpml.save(P));
	}
	@GetMapping("/HeureSup/{id}")
	public ResponseEntity<HeureSup> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(heureSupServiceIpml.findById(id));
		
	}
	@PutMapping("/HeureSup/{id}")
	public ResponseEntity<HeureSup> Update(@RequestBody HeureSup cat,@PathVariable Long id) {
		HeureSup c=heureSupServiceIpml.findById(id);
		c.setLibelle(cat.getLibelle());
		c.setPrime(cat.getPrime());
		return ResponseEntity.ok(heureSupServiceIpml.save(c));
		
	}
	@DeleteMapping("HeureSup/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		heureSupServiceIpml.deleteById(id);
		return ResponseEntity.ok("deleted succefuly");
	}


}
