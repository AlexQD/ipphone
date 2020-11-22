package ru.radcenter.ipphone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.radcenter.ipphone.dto.HistoryDto;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.repository.AccountRepository;
import ru.radcenter.ipphone.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService{


    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void save(History history){
        historyRepository.save(history);
    };
}
