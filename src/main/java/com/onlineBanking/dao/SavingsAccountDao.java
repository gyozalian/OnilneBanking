package com.onlineBanking.dao;

import com.onlineBanking.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tigrangyozalyan on 8/31/17.
 */
public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int AccountNumber);
}
