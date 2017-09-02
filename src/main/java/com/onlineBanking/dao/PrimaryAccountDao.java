package com.onlineBanking.dao;

import com.onlineBanking.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tigrangyozalyan on 8/31/17.
 */
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);

}
