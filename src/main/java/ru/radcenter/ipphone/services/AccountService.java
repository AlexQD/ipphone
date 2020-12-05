package ru.radcenter.ipphone.services;

import ru.radcenter.ipphone.dto.AccountDto;
import ru.radcenter.ipphone.model.Account;
import ru.radcenter.ipphone.model.History;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
    List<Account> getAccounts();
    void save(AccountDto accountDto);

    Account getAccounttoHistory(History history);
}
