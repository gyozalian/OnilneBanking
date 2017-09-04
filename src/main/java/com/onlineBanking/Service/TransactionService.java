package com.onlineBanking.Service;

import com.onlineBanking.domain.PrimaryTransaction;
import com.onlineBanking.domain.SavingsTransaction;

import java.util.List;

/**
 * Created by tigrangyozalyan on 9/3/17.
 */
public interface TransactionService  {

     List<PrimaryTransaction> findPrimaryTransactionList (String username);
     List<SavingsTransaction> savingsTransactionsList (String username);
     void savePrimaryTransaction (PrimaryTransaction primaryTransaction);
     void saveSavingsTransaction (SavingsTransaction savingsTransaction);


    }
