package org.amigoscode.customer.services;

import lombok.RequiredArgsConstructor;
import org.amigoscode.customer.models.domain.CustomerRegisterRequest;
import org.amigoscode.customer.models.dto.BaseDTO;
import org.amigoscode.customer.models.entity.Customer;
import org.amigoscode.customer.repository.CustomerRepository;
import org.amigoscode.customer.utilities.RestTemplateUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplateUtility restTemplateUtility;

    @Value("${application.fraud.server.base.url}")
    private String baseUrl;

    public BaseDTO registerCustomer(CustomerRegisterRequest request){

        Customer customer=Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);
        String url=baseUrl+"/v1/fraud/checkFraudster?customerId="+customer.getId();
        BaseDTO checkFraudResponse;
        checkFraudResponse=restTemplateUtility.sendRequest(url, HttpMethod.GET,null);
        return checkFraudResponse;
    }
}
