package org.amigoscode.customer.controller;

import lombok.RequiredArgsConstructor;
import org.amigoscode.customer.models.domain.CustomerRegisterRequest;
import org.amigoscode.customer.models.dto.BaseDTO;
import org.amigoscode.customer.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/registerCustomer")
    public ResponseEntity<BaseDTO> registerCustomer(@RequestBody CustomerRegisterRequest request){
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }
}
