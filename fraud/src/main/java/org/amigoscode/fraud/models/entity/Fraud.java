package org.amigoscode.fraud.models.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fraud")
public class Fraud {

    @Id
    @SequenceGenerator(name = "customer_id_sequence",sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id_sequence")
    private Integer id;

    private Boolean isFraudster;
    private Integer customerId;
    private Timestamp createdAt;
}
