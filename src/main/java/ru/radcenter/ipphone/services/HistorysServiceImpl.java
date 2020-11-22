package ru.radcenter.ipphone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.radcenter.ipphone.dto.HistorysDto;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.model.Historys;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void print(HistorysDto historys){

        historys.getHistoryArray().forEach(history -> {
            System.out.println(history.getUidAtc());
        });
    }

    public void delDublicate(Historys historys){
        HashMap<String, History> hashMap = new HashMap<>();
        historys.getHistoryArray().forEach(history -> {
            hashMap.put(history.getClient(), history);
        });
        historys.clear();
        historys.setHistoryArray( new ArrayList<>(hashMap.values()));
    }

    public Historys missingCall(Historys historys, History history){
        Historys missingCallsClient = new Historys();
        historys.getHistoryArray().forEach(history1 -> {
           if (history1.getClient().equals(history.getClient())){
               missingCallsClient.add(history1);
           }
        });
        return missingCallsClient;
    }



}
