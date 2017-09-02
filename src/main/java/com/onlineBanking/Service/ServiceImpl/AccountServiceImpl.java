package com.onlineBanking.Service.ServiceImpl;

import com.onlineBanking.Service.AccountService;
import com.onlineBanking.dao.PrimaryAccountDao;
import com.onlineBanking.dao.SavingsAccountDao;
import com.onlineBanking.Service.UserService;
import com.onlineBanking.domain.PrimaryAccount;
import com.onlineBanking.domain.SavingsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    private int accountGen(){
        return ++nextAccountNumber;
    }


}
