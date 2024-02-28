package org.amigoscode.fraud.repository;

import org.amigoscode.fraud.models.entity.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudRepository extends JpaRepository<Fraud,Integer> {
    Optional<Fraud> findByCustomerId(Integer customerId);
}
