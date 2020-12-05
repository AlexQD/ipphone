package ru.radcenter.ipphone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.radcenter.ipphone.dto.AccountDto;
import ru.radcenter.ipphone.model.Account;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccounttoHistory(History history){
        for (int i = 0; i < getAccounts().size(); ++i) {
            if (history.getAccount().equals(getAccounts().get(i).getAccount())){
                return getAccounts().get(i);
            }
        }
        return new Account();
    }

    @Override
    public void save(AccountDto accountDto) {
        Account account = new Account();
        account.setAccount(accountDto.getAccount());
        account.setAddress(accountDto.getAddress());
        account.setPhone(accountDto.getPhone());
        accountRepository.save(account);
    }

}
