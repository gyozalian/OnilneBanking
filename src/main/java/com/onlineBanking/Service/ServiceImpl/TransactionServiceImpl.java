package com.onlineBanking.Service.ServiceImpl;

import com.onlineBanking.Service.TransactionService;
import com.onlineBanking.Service.UserService;
import com.onlineBanking.dao.PrimaryTransactionDao;
import com.onlineBanking.dao.SavingsTransactionDao;
import com.onlineBanking.domain.PrimaryTransaction;
import com.onlineBanking.domain.SavingsTransaction;
import com.onlineBanking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tigrangyozalyan on 9/3/17.
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryTransactionDao primaryTransactionDao;

    @Autowired
    private SavingsTransactionDao savingsTransactionDao;

    public List<PrimaryTransaction> findPrimaryTransactionList (String username){
        User user = userService.findByUsername(username);

        List<PrimaryTransaction> primaryTransactions = user.getPrimaryAccount().getPrimaryTransactionList();

        return primaryTransactions;
    }

    public List<SavingsTransaction> findSavingsTransactionList (String username){
        User user = userService.findByUsername(username);

        List<SavingsTransaction> savingsTransactions = user.getSavingsAccount().getSavingsTransactionList();

        return savingsTransactions;
    }

    public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }

    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }

    public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }

    public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }

}
