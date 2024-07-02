package sn.lamp.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.lamp.dev.model.Contrat;
import sn.lamp.dev.service.impl.ContratServiceIpml;

@RestController
@RequestMapping("/api/v1")
public class ContratController {

	@Autowired
	private ContratServiceIpml contratServiceIpml;
	
	@GetMapping("/contrat")
	public ResponseEntity<List<Contrat>> getAll(){
		return ResponseEntity.ok(contratServiceIpml.getAll());
	}
	@PostMapping("/contrat")
	public  ResponseEntity<Contrat> save(@RequestBody Contrat C){
		return ResponseEntity.ok(contratServiceIpml.save(C));
	}
	
	
}
