package com.onlineBanking.Service;

import com.onlineBanking.domain.PrimaryAccount;
import com.onlineBanking.domain.SavingsAccount;

import java.security.Principal;

/**
 * Created by tigrangyozalyan on 8/2/17.
 */
public interface AccountService
{
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
}
