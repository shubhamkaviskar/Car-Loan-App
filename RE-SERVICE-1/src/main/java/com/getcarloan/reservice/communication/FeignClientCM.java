package com.getcarloan.reservice.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.getcarloan.reservice.entities.CIBILScore;


@FeignClient (url="http://localhost:8082/cmService",name="CREDIT-MANEGER")
public interface FeignClientCM {

	@GetMapping("/cibilScoreCheckByCid/{cid}")
	public ResponseEntity<CIBILScore> cibilScoreCheckByCid(@PathVariable Integer cid);
	
}
