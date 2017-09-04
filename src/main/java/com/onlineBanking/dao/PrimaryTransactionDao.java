package com.onlineBanking.dao;

import com.onlineBanking.domain.PrimaryTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tigrangyozalyan on 9/3/17.
 */
public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction,Long> {

    List<PrimaryTransaction> findAll();

}
