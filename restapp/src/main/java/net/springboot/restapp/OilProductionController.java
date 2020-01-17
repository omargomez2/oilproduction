/*
 * Author: Omar S. Gómez
 * Date: January 2020
 * Course: Software Architectures
 */

package net.springboot.restapp;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class OilProductionController {
	
	@Autowired
    private OilProductionService service;


	@PostMapping("/production")
    public OilProduction add(@RequestBody OilProduction oilProduction) {
        //System.out.println(oilProduction.toString());
		OilProduction op = service.create(oilProduction);
		return op;
    }
	
	@GetMapping("/production")
    public List<OilProduction> getProduction() {
        return service.getAllProduction();
    }

    @GetMapping("/production/{id}")
    public ResponseEntity<OilProduction> getProductionById(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
        OilProduction oilProduction = service.getProductionById(id);
        return ResponseEntity.ok().body(oilProduction);
    }
    
    
    @GetMapping("/production/average")
    public Result getAverage() throws RecordNotFoundException {
        return service.getAverageProduction();
    }
	
    
    //@GetMapping("/production/avg")
    //public Map<String, Integer> getAverage2() {
    //	HashMap<String, Integer> map = new HashMap<>();
    //    map.put("avg", service.getAVG());
    //    return map;
    //}
    
}
