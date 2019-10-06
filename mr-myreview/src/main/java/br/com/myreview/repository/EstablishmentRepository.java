package br.com.myreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myreview.enums.Cities;
import br.com.myreview.enums.Districts;
import br.com.myreview.enums.States;
import br.com.myreview.model.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
	List<Establishment> findByOrderByStarsDesc();
	
	List<Establishment> findByStateOrderByStarsDesc(States state);
	
	List<Establishment> findByStateAndCityOrderByStarsDesc(States state, Cities city);
	
	List<Establishment> findByStateAndCityAndDistrictOrderByStarsDesc(String state, Cities city, Districts district);
	
}
