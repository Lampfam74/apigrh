package sn.lamp.dev.controller;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import sn.lamp.dev.Utilitis.Constant;
import sn.lamp.dev.model.Personal;
import sn.lamp.dev.model.Pointages;
import sn.lamp.dev.service.impl.PersonalServiceIpml;
import sn.lamp.dev.service.impl.PointagesServiceIpml;

@RestController
@RequestMapping("/api/v1")
@Tag(name ="Pointage controller " ,description = "all crud Pointage controller"  )
public class PointagesController {

	@Autowired
	private PointagesServiceIpml pointagesServiceIpml;
	@Autowired
	private PersonalServiceIpml personalServiceIpml;

	@GetMapping("/pointages")
	public List<Pointages> getAll() {
		return pointagesServiceIpml.getAll();
	}

	 @RequestMapping(value = "/pointages", method = {RequestMethod.POST, RequestMethod.PUT})
	 @PostMapping
	 @PutMapping
	public String addPointages(Pointages P){
		//variable
	
		
		Pointages Per = new Pointages();
		String response = new String();
		Pointages p = new Pointages();
		//logique
		
		Personal perso = personalServiceIpml.findByToken(P.getToken());
		System.out.println("********************"+perso.getToken());
		System.out.println("Token :"+perso.getToken()+ " vs Request token : " +P.getToken());
		if( perso.getToken().equals(perso.getToken())) {
			System.out.println("true :"+ true);
		}
		Per = pointagesServiceIpml.findByToken(P.getToken(),P.getDate());
		long count=pointagesServiceIpml.count_pointage(P.getToken(),P.getDate());
		System.out.println("******************** count: "+ count);
		if(perso!= null) {
    	if(count <1){
				if(P.getType().equals(Constant.ENTREE)){
					P.setSortie(Time.valueOf("00:00:00"));
					pointagesServiceIpml.save(P);
					response="entree effectuer successfuly";
				}
				if(P.getType().equals(Constant.SORTIE)){
					if(P.getSortie() == null) {
					//P.setType(Constant.SORTIE);
					Per.setId(Per.getId());
					Per.setSortie(P.getEntree());
					pointagesServiceIpml.save(Per);
				    response="Sortie effectuer successfuly";
					}
			}
	    }else {
	    	response="deja pointee different ";
	    }
    	} else {
    		response="token doest not exist ";
    	}
		return response;
	}
}