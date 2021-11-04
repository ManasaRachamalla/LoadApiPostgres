package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApiData;
import com.example.demo.repository.ApiRepo;

@RestController
@RequestMapping("api/v1")
public class ApiController {
	
	@Autowired
	private ApiRepo _apiRepo ;
	
	
	@GetMapping("load")
	public List<ApiData> getLoadDetails(){
		return _apiRepo.findAll();
	}
	
	@GetMapping("load/{loadId}")
	public Optional<ApiData> getDetailsbyId(@PathVariable (value = "loadId") Long loadId) {
		//return this._apiRepo.getById(shipperId);
		return _apiRepo.findById(loadId);
	}

	@PostMapping("load")
	public String postLoadDetails(@RequestBody ApiData apidata) {
		 _apiRepo.save(apidata);
		 return "loads details added successfully";
	}
	
	@PutMapping("load/{loadId}")
	public ApiData updateLoadDetails(@PathVariable  (value = "loadId") Long loadId ,  @RequestBody ApiData apidataDetails) {
		ApiData apiData = _apiRepo.findById(loadId).orElse(null);
			
		apiData.setComment(apidataDetails.getComment());
		apiData.setLoadingPoint(apidataDetails.getLoadingPoint());
		apiData.setNoOfTrucks(apidataDetails.getNoOfTrucks());
		apiData.setProductType(apidataDetails.getProductType());
		apiData.setShipperId(apidataDetails.getShipperId());
		apiData.setTruckType(apidataDetails.getTruckType());
		apiData.setUnloadingPoint(apidataDetails.getUnloadingPoint());
		apiData.setWeight(apidataDetails.getWeight());
		apiData.setDate(apidataDetails.getDate());
		//apiData.setLoadId(apidataDetails.getLoadId());
		
		return _apiRepo.save(apiData);
		//return ResponseEntity.ok(_apiRepo.save(apiData));
		 
	}
	
	@DeleteMapping("load/{loadId}")
	public Map<String, Boolean> deleteLoadDetails(@PathVariable(value = "loadId") Long loadId ){
		ApiData apidata = _apiRepo.getById(loadId);
		_apiRepo.delete(apidata);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
