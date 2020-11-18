package ru.radcenter.ipphone.model;

import org.springframework.beans.factory.annotation.Autowired;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.repository.HistoryRepository;
import ru.radcenter.ipphone.services.HistoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Historys {
    private ArrayList<History> historyArray;

    @Autowired
    private HistoryService historyService;

    public Historys(){
        historyArray = new ArrayList<>();
    }

    public ArrayList<History> getHistoryArray() {
        return historyArray;
    }

    public void setHistoryArray(ArrayList<History> historyArray) {
        this.historyArray = historyArray;
    }

    public void add(History history){
        historyArray.add(history);
    }


    public void print(){
        for (int i = 0; i < historyArray.size(); ++i) {
            System.out.println(historyArray.get(i).getUidAtc());

        }
    }

    public Historys missingCall(History history){
        Historys missingCallsClient = new Historys();
        for (int i = 0; i < historyArray.size(); ++i) {
            if (historyArray.get(i).getClient().equals(history.getClient())){
                missingCallsClient.add(historyArray.get(i));
            }
        }
        return missingCallsClient;
    }

    public void delDublicate(){
        HashMap<String, History> hashMap = new HashMap<>();
        for (int i = 0; i < historyArray.size(); ++i) {
            hashMap.put(historyArray.get(i).getClient(),historyArray.get(i));
        }
        historyArray.clear();
        historyArray = new ArrayList<>(hashMap.values());
    }


    public void saveBd(){
        for (int i = 0; i < historyArray.size(); ++i) {
            historyService.save(historyArray.get(i));
        }
    }

//    public static Historys missing_call(Historys historys){
//        for (int i = 0; i < historys.getHistory_array().size(); ++i) {
//            if (historys.getHistory_array().get(i).getType().equals("missed")){
//
//            }
//            //System.out.println(history_array.get(i).getUid_atc());
//
//        }
//    }
}
