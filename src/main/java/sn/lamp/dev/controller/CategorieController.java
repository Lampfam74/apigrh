package sn.lamp.dev.controller;

import java.util.List;

import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import sn.lamp.dev.model.Categorie;
import sn.lamp.dev.service.impl.CategorieServiceIpml;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@Tag(name ="Categorie controller " ,description = "all crud categorie controller"  )
//@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class CategorieController {

	@Autowired
	private CategorieServiceIpml categorieServiceIpml;
	
//	@ApiOperation(value = "View a list of available employees", response = List.class)
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Successfully retrieved list"),
//        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    })
	@GetMapping("/categorie")
	public ResponseEntity<List<Categorie>> getAllCategrie() {
		return ResponseEntity.ok(categorieServiceIpml.getAll());

	}
//	@ApiOperation(value = "add an Categorie")
	@PostMapping("/categorie")
	public ResponseEntity<Categorie> save(@RequestBody Categorie cat) {
		return ResponseEntity.ok(categorieServiceIpml.save(cat));
	}
//	@ApiOperation(value = "Get an Categorie by Id")
	@GetMapping("/categorie/{id}")
	public ResponseEntity<Categorie> findById(@PathVariable Long id) {
		categorieServiceIpml.findById(id);
		return ResponseEntity.ok(categorieServiceIpml.findById(id));
		
	}
//	@ApiOperation(value = "update an Categorie by Id")
	@PutMapping("/categorie/{id}")
	public ResponseEntity<Categorie> Update(
//			@ApiParam(value = "Categorie object store in database table", required = true) @Validated
			@RequestBody Categorie cat,@PathVariable Long id) {
		Categorie c=categorieServiceIpml.findById(id);
		c.setLibelle(cat.getLibelle());
		c.setDescription(cat.getDescription());
		return ResponseEntity.ok(categorieServiceIpml.save(c));
		
	}
//	@ApiOperation(value = "Delete an Categorie by Id")
	@DeleteMapping("categorie/{id}")
	public ResponseEntity<String> delete(
//			 @ApiParam(value = "Categorie Id to Delete  employee object", required = true)
			@PathVariable Long id) {
		categorieServiceIpml.deleteById(id);
		return ResponseEntity.ok("deleted succefuly");
	}

}
