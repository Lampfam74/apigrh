package sn.lamp.dev.controller;

import java.util.List;
import java.util.Optional;

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
import sn.lamp.dev.model.TypeContrat;
import sn.lamp.dev.service.impl.TypeContratServiceIpml;

@RestController
@RequestMapping("/api/v1")

@Tag(name ="type Contrat  controller " ,description = "all crud Categorie Contrats  controller"  )
public class TypeContratController {
	@Autowired
	private TypeContratServiceIpml contratServiceIpml;

	@GetMapping("/type_contrat")
	public ResponseEntity<List<TypeContrat>> getAllCategrie() {
		return ResponseEntity.ok(contratServiceIpml.getAll());

	}
	@PostMapping("/type_contrat")
	public ResponseEntity<TypeContrat> save(@RequestBody TypeContrat cat) {
		return ResponseEntity.ok(contratServiceIpml.save(cat));
	}
	@GetMapping("/type_contrat/{id}")
	public ResponseEntity<Optional<TypeContrat>> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(contratServiceIpml.findById(id));
		
	}
	@PutMapping("/type_contrat/{id}")
	public ResponseEntity<TypeContrat> Update(@RequestBody TypeContrat cat,@PathVariable Long id) {
		TypeContrat c=contratServiceIpml.findById(id).orElse(null);
		c.setLibelle(cat.getLibelle());
		c.setDescription(cat.getDescription());
		return ResponseEntity.ok(contratServiceIpml.save(c));
		
	}
	@DeleteMapping("type_contrat/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		contratServiceIpml.deleteById(id);
		return ResponseEntity.ok("deleted succefuly");
	}
}
