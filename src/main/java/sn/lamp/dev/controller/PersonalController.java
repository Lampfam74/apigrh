package sn.lamp.dev.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;
import sn.lamp.dev.model.Personal;
import sn.lamp.dev.service.impl.PersonalServiceIpml;
import sn.lamp.dev.service.impl.UploadImageImpl;

@RestController
@RequestMapping("api/v1/")
@Tag(name ="Personnal controller " ,description = "all crud personnal controller"  )
public class PersonalController {
	@Autowired
	private PersonalServiceIpml personalServiceIpml;
	@Autowired
	private UploadImageImpl imageImpl;
	public String fileName;
	@GetMapping("/personals")
	public ResponseEntity<List<Personal>> getAll(){
		return  (ResponseEntity.ok(personalServiceIpml.getAll()));
	}
	@PostMapping("/personals")
	public ResponseEntity<Personal> addPersonal(@RequestBody Personal P){
		System.out.println(P+"..............................Bismilah barké Mame Lamp---------------++++++++++++++++++++" + P.getFiles());
		//P.setFiles(files);
		return ResponseEntity.ok(personalServiceIpml.save(P));
	}
	@PostMapping("/personalsUpload")
	public ResponseEntity<String> addPersonal(@RequestBody List<MultipartFile> files,Personal P){
		for (MultipartFile file : files) {
		    String fil = file.getOriginalFilename();
		     fileName = FilenameUtils.getBaseName(fil) + "." + FilenameUtils.getExtension(fil);
		    File path = imageImpl.getPathService(fileName, "DOC");

		    if (path != null) {
		        try {
		            FileUtils.writeByteArrayToFile(path, file.getBytes());
		        } catch (IOException e) {
		            // Handle the exception properly, log or rethrow if necessary
		            e.printStackTrace();
		        }
		    }
           P.setCV(fileName);    // Assuming Per has a method like setCV(String cv) to set the CV filename
		}
		personalServiceIpml.save(P);
		return ResponseEntity.ok("add succefuly");
	//return ResponseEntity.ok(personalServiceIpml.save(P));
		//return ResponseEntity.ok(personalServiceIpml.save(P));
	}
	@GetMapping("/personals/{id}")
	public ResponseEntity<Personal> getById(@PathVariable Long id){
		Personal Per=new Personal();
		try {
			Per = personalServiceIpml.findById(id)
					.orElseThrow(() -> new Exception("Personal not exist with id :" + id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(Per);
	}
	@PutMapping("/personals/{id}")
	public ResponseEntity<Personal> UpdatePersonal(@RequestBody Personal P,@PathVariable Long id){
		Personal Per =new Personal();
		try {
			Per = personalServiceIpml.findById(id)
					.orElseThrow(() -> new Exception("Personal not exist with id :" + id));
			Per.setPrenom(P.getPrenom());
			Per.setNom(P.getNom());
			Per.setGenre(P.getGenre());
			Per.setDateNaissance(P.getDateNaissance());
			Per.setDiplome(P.getDiplome());
			Per.setToken(P.getToken());
			Per.setCV(P.getCV());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(personalServiceIpml.save(Per));
	}
	@DeleteMapping("/personals/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteById(@PathVariable Long id){
		try {
			personalServiceIpml.findById(id).
			orElseThrow(()->new Exception("personals not found "+id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete successfuly" , true);
		return ResponseEntity.ok(response);
	}
}
