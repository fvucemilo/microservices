package com.fvucemilo.fraud.dao;

import com.fvucemilo.fraud.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud, Long> {
}
