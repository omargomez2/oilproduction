/*
 * Author: Omar S. Gómez
 * Date: January 2020
 * Course: Software Architectures
 */
package net.springboot.restapp;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OilProductionRepository extends CrudRepository<OilProduction, Long> {
	
	@Query("SELECT AVG(o.production) AS avg FROM OilProduction o")
	public Optional<Result> getAverageProduction();

	
	//@Query("SELECT AVG(o.production) AS avg FROM OilProduction o")
	//public Integer getAVGProduction();
}

