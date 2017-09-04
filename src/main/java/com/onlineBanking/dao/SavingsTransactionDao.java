package com.onlineBanking.dao;

import com.onlineBanking.domain.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tigrangyozalyan on 9/3/17.
 */
public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}
