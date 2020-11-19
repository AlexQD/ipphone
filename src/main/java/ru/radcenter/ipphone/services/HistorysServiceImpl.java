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
    public void print(Historys historys){
        for (int i = 0; i < historys.getHistoryArray().size(); ++i) {
            System.out.println(historys.getHistoryArray().get(i).getUidAtc());

        }
    }

    public void delDublicate(Historys historys){
        HashMap<String, History> hashMap = new HashMap<>();
        for (int i = 0; i < historys.getHistoryArray().size(); ++i) {
            hashMap.put(historys.getHistoryArray().get(i).getClient(),historys.getHistoryArray().get(i));
        }
        historys.clear();
        historys.setHistoryArray( new ArrayList<>(hashMap.values()));
    }

    public Historys missingCall(Historys historys, History history){
        Historys missingCallsClient = new Historys();
        for (int i = 0; i < historys.getHistoryArray().size(); ++i) {
            if (historys.getHistoryArray().get(i).getClient().equals(history.getClient())){
                missingCallsClient.add(historys.getHistoryArray().get(i));
            }
        }
        return missingCallsClient;
    }



}
