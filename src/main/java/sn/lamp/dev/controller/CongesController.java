package sn.lamp.dev.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;
import sn.lamp.dev.model.Conges;
import sn.lamp.dev.service.impl.CongeServiceIpml;
import sn.lamp.dev.service.impl.UploadImageImpl;

@RestController
@RequestMapping("api/v1")
@Tag(name ="Conges controller " ,description = "all crud Conges controller"  )
public class CongesController {

	@Autowired
	private CongeServiceIpml congeServiceIpml;
	@Autowired
	private UploadImageImpl imageImpl;
	@GetMapping("conges")
	public ResponseEntity<List<Conges>> getAll(){
		return ResponseEntity.ok(congeServiceIpml.getAll());
	}
	@PostMapping("conges")
	public ResponseEntity<String> save(Conges S,@RequestBody List<MultipartFile> files){
		for (MultipartFile file : files) {
		    String fil = file.getOriginalFilename();
		   String  fileName = FilenameUtils.getBaseName(fil) + "." + FilenameUtils.getExtension(fil);
		    File path = imageImpl.getPathService(fileName, "conges");

		    if (path != null) {
		        try {
		            FileUtils.writeByteArrayToFile(path, file.getBytes());
		        } catch (IOException e) {
		            // Handle the exception properly, log or rethrow if necessary
		            e.printStackTrace();
		        }
		    }
         S.setDemande(fileName);    // Assuming Per has a method like setCV(String cv) to set the CV filename
		}
		congeServiceIpml.save(S);
		return ResponseEntity.ok("add succefuly");
	}
	@PutMapping("conges")
	public ResponseEntity<String> update(Conges S,@RequestBody List<MultipartFile> files,@PathVariable Long id){
		Conges C=congeServiceIpml.findById(id);
		if(C == null) return null;
		for (MultipartFile file : files) {
		    String fil = file.getOriginalFilename();
		   String  fileName = FilenameUtils.getBaseName(fil) + "." + FilenameUtils.getExtension(fil);
		    File path = imageImpl.getPathService(fileName, "conges");

		    if (path != null) {
		        try {
		            FileUtils.writeByteArrayToFile(path, file.getBytes());
		        } catch (IOException e) {
		            // Handle the exception properly, log or rethrow if necessary
		            e.printStackTrace();
		        }
		    }
         C.setDemande(fileName);    // Assuming Per has a method like setCV(String cv) to set the CV filename
		}
		C.setFin(S.getFin());
		C.setDebut(S.getDebut());
		C.setNature(S.getNature());
		C.setStatut(S.getStatut());
		C.setLibelle(S.getLibelle());
		congeServiceIpml.save(S);
		return ResponseEntity.ok("add succefuly");
	}
}
