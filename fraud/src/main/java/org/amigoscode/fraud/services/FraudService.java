package org.amigoscode.fraud.services;

import lombok.RequiredArgsConstructor;
import org.amigoscode.fraud.models.dto.BaseDTO;
import org.amigoscode.fraud.models.entity.Fraud;
import org.amigoscode.fraud.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;

    public BaseDTO fraudCheck(Integer customerId){
        Optional<Fraud> fraud= fraudRepository.findByCustomerId(customerId);
        Boolean isFraud= fraud.isPresent() && fraud.get().getIsFraudster();

        BaseDTO baseDto=  BaseDTO.getSuccess();
        baseDto.setData(isFraud);
        return baseDto;
    }
}
