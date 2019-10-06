package br.com.myreview.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.myreview.enums.Cities;
import br.com.myreview.enums.Districts;
import br.com.myreview.enums.States;
import br.com.myreview.model.Establishment;
import br.com.myreview.repository.EstablishmentRepository;

@CrossOrigin
@RestController
@RequestMapping("/establishments")
public class HomeController {
	
	@Autowired
	private EstablishmentRepository establishmentRepository;
	
	
	@GetMapping
	public List<Establishment> home() {
		List<Establishment> estabList;
		estabList = establishmentRepository.findByOrderByStarsDesc();
		
		return estabList;

	}
	
	@GetMapping("/{state}")
	public ResponseEntity<List<Establishment>> establishmentState(@PathVariable(name="state") States acronymState){
		List<Establishment> estabStateList;
		estabStateList = establishmentRepository.findByStateOrderByStarsDesc(acronymState);
		
		if(estabStateList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estabStateList);
	}
	
	@GetMapping("/{state}/{city}")
	public ResponseEntity<List<Establishment>> establishmentStateCity(@PathVariable(name="state") States acronymState, 
			@PathVariable(name="city") Cities acronymCity){
		List<Establishment> estabStateCityList;
		estabStateCityList = establishmentRepository.findByStateAndCityOrderByStarsDesc(acronymState, acronymCity);
		
		if(estabStateCityList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		
		return ResponseEntity.ok(estabStateCityList);
	}
	
	@GetMapping("/{state}/{city}/{district}")
	public ResponseEntity<List<Establishment>> establishmentStateCityDistrict(@PathVariable(name="state") String acronymState, 
			@PathVariable(name="city") Cities acronymCity, @PathVariable(name="district") Districts acronymDistrict){
		List<Establishment> estabStateCityDistrictList;
		estabStateCityDistrictList = establishmentRepository.findByStateAndCityAndDistrictOrderByStarsDesc(acronymState, acronymCity, acronymDistrict);
		
		if(estabStateCityDistrictList.isEmpty()) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estabStateCityDistrictList);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Establishment createEstablishment(@Valid @RequestBody Establishment establishment) {
		Optional<Establishment> registredEstablishments = establishmentRepository.findById(establishment.getId());
		
		if(registredEstablishments.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já exixste um restaurante neste email ou CNPJ!");
		}
		return establishmentRepository.save(establishment);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Establishment updateEstablishment(@Valid @RequestBody Establishment establishment) {
		Optional<Establishment> registredEstablishments = establishmentRepository.findById(establishment.getId());
		
		if(!registredEstablishments.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este estabelecimento não existe!");
		}
		return establishmentRepository.saveAndFlush(establishment);
	}
	
	@DeleteMapping
	public ResponseEntity<Establishment> deleteEstablishment(@Valid @RequestBody Establishment establishment) {
		Optional<Establishment> registredEstablishments = establishmentRepository.findById(establishment.getId());
		
		if(!registredEstablishments.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este estabelecimento não existe!");
		}
		establishmentRepository.delete(establishment);
		return ResponseEntity.ok(establishment);
	}
}
