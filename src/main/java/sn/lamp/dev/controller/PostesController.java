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
import sn.lamp.dev.model.Postes;
import sn.lamp.dev.service.impl.PosteServiceIpml;

@RestController
@RequestMapping("/api/v1")
@Tag(name ="Postes controller " ,description = "all crud Postes controller"  )
public class PostesController {
	@Autowired
	private PosteServiceIpml posteServiceIpml;
	@GetMapping("/postes")
	public ResponseEntity<List<Postes>> getAll(){
		return ResponseEntity.ok(posteServiceIpml.getAll());
	}
	@PostMapping("/postes")
	public ResponseEntity<Postes> addPostes(@RequestBody Postes P){
		return ResponseEntity.ok(posteServiceIpml.save(P));
	}
	@GetMapping("/postes/{id}")
	public ResponseEntity<Postes> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(posteServiceIpml.findById(id));
		
	}
	@PutMapping("/postes/{id}")
	public ResponseEntity<Postes> Update(@RequestBody Postes cat,@PathVariable Long id) {
		Postes c=posteServiceIpml.findById(id);
		c.setLibelle(cat.getLibelle());
		c.setCotisation(cat.getCotisation());
		return ResponseEntity.ok(posteServiceIpml.save(c));
		
	}
	@DeleteMapping("postes/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		posteServiceIpml.deleteById(id);
		return ResponseEntity.ok("deleted succefuly");
	}


}
