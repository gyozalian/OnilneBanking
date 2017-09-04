package com.onlineBanking.Service.ServiceImpl;

import com.onlineBanking.Service.AccountService;
import com.onlineBanking.dao.PrimaryAccountDao;
import com.onlineBanking.dao.PrimaryTransactionDao;
import com.onlineBanking.dao.SavingsAccountDao;
import com.onlineBanking.Service.UserService;
import com.onlineBanking.dao.SavingsTransactionDao;
import com.onlineBanking.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

/**
 * Created by tigrangyozalyan on 8/2/17.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static int nextAccountNumber = 102235;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryTransactionDao primaryTransactionDao;

    @Autowired
    private SavingsTransactionDao savingsTransactionDao;

    public PrimaryAccount createPrimaryAccount(){
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }



    public SavingsAccount createSavingsAccount(){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }


    public void deposit(String accountType, double amount, Principal principal){
        User user = userService.findByUsername(principal.getName());

        if(accountType.equalsIgnoreCase("Primary")){

            PrimaryAccount primaryAccount = user.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));

            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date,"Deposit to Primary Account", "Account",
                                                                    "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);

        }
        else if (accountType.equalsIgnoreCase("Savings")){

            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));

            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to Savings Account", "Account", "Finished",
                                                                            amount, savingsAccount.getAccountBalance(), savingsAccount);

        }
    }

    public void withdraw(String accountType, double amount, Principal principal){
        User user = userService.findByUsername(principal.getName());

        if(accountType.equalsIgnoreCase("Primary")){

            PrimaryAccount primaryAccount = user.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));

            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "Account", "Finished", amount,
                                                                            primaryAccount.getAccountBalance(), primaryAccount);

        }
        else if(accountType.equalsIgnoreCase("Savings")){

            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));

            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Withdraw from Savings Account", "Account", "Finished", amount,
                                                                            savingsAccount.getAccountBalance(), savingsAccount);

        }
    }

    private int accountGen(){
        return ++nextAccountNumber;
    }



}
