package ru.radcenter.ipphone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.radcenter.ipphone.dto.HistorysDto;

@Service
public class HistorysServiceImpl implements  HistorysService {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private AccountService accountService;

    public void save(HistorysDto historysDto){
        for (int i = 0; i < historysDto.getHistoryArray().size(); ++i) {
            historyService.save(historysDto.getHistoryArray().get(i));
        }
    }
}
