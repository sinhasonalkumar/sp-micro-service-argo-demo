package com.sonal.demosvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/canary")
@Tag(name = "Canary", description = "the canary Api")
public class CanaryController {

	@Value("${microservice.spms.canary.env}")
	private String environment;
	
	@Value("${microservice.spms.canary.name}")
	private String canaryName;
	
	@Operation(summary = "This web method check canary version for AB Testing")
    @GetMapping
    public ResponseEntity<Map<String,String>> getCanaryDetails() {
        Map<String, String> canaryAttributes = new HashMap<String, String>();
        canaryAttributes.put("environment", environment);
        canaryAttributes.put("canaryName", canaryName);
		return ResponseEntity.ok(canaryAttributes);
    }
}
