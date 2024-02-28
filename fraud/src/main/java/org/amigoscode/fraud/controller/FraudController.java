package org.amigoscode.fraud.controller;

import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.amigoscode.fraud.models.dto.BaseDTO;
import org.amigoscode.fraud.services.FraudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/fraud")
public class FraudController {

    private final FraudService fraudService;

    @GetMapping("/checkFraudster")
    public ResponseEntity<BaseDTO<?>> checkCustomerFraudster(@RequestParam("customerId") Integer customerId){
        return ResponseEntity.ok(fraudService.fraudCheck(customerId));
    }
}
