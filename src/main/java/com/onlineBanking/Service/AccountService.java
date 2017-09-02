package com.onlineBanking.Service;

import com.onlineBanking.domain.PrimaryAccount;
import com.onlineBanking.domain.SavingsAccount;

/**
 * Created by tigrangyozalyan on 8/2/17.
 */
public interface AccountService
{
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
}
