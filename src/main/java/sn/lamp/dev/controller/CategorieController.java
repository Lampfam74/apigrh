package sn.lamp.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import sn.lamp.dev.model.Categorie;
import sn.lamp.dev.service.CategorieService;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@Tag(name ="Categorie controller " ,description = "all crud categorie controller"  )
//@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;
	
//	@ApiOperation(value = "View a list of available employees", response = List.class)
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Successfully retrieved list"),
//        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    })
	@GetMapping("/categorie")
	public List<Categorie> getAllCategrie() {
		return categorieService.getAll();

	}
//	@ApiOperation(value = "add an Categorie")
	@RequestMapping("/categorie")
	public void save(Categorie cat) {
		 categorieService.save(cat);
	}
//	@ApiOperation(value = "Get an Categorie by Id")
	@GetMapping("/categorie/{id}")
	public Categorie findById( Long id) {
		categorieService.findById(id);
		return categorieService.findById(id);
		
	}
//	@ApiOperation(value = "update an Categorie by Id")
	@PutMapping("/categorie/{id}")
	public Categorie Update(
//			@ApiParam(value = "Categorie object store in database table", required = true) @Validated
			@RequestBody Categorie cat,@PathVariable Long id) {
		Categorie c=categorieService.findById(id);
		c.setLibelle(cat.getLibelle());
		c.setDescription(cat.getDescription());
		return categorieService.save(c);
		
	}
//	@ApiOperation(value = "Delete an Categorie by Id")
	@DeleteMapping("categorie/{id}")
	public String delete(
//			 @ApiParam(value = "Categorie Id to Delete  employee object", required = true)
			@PathVariable Long id) {
		categorieService.deleteById(id);
		return "deleted succefuly";
	}

}
