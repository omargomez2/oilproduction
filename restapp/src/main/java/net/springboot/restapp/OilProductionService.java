/*
 * Author: Omar S. Gómez
 * Date: January 2020
 * Course: Software Architectures
 */
package net.springboot.restapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OilProductionService {
	
	@Autowired
	OilProductionRepository repo;

	
	public List<OilProduction> getAllProduction() {
	        List<OilProduction> result = (List<OilProduction>) repo.findAll();
	         
	        if(result.size() > 0) {
	            return result;
	        } else {
	            return new ArrayList<OilProduction>();
	        }
	    }
	     
	    public OilProduction getProductionById(Long id) throws RecordNotFoundException {
	        Optional<OilProduction> oilProduction = repo.findById(id);
	         
	        if(oilProduction.isPresent()) {
	            return oilProduction.get();
	        } else {
	            throw new RecordNotFoundException("No record found for given id");
	        }
	    }
	    
	    public Result getAverageProduction() throws RecordNotFoundException {
	        Optional<Result> avgProduction = repo.getAverageProduction();
	         
	        if(avgProduction.isPresent()) {
	            return avgProduction.get();
	        } else {
	            throw new RecordNotFoundException("No records found");
	        }
	    }
	    
	    //public Integer getAVG() {
	    //    return repo.getAVGProduction();
	    //}
}
