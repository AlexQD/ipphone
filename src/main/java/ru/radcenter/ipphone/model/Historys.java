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
    private ArrayList<History> history_array;

    @Autowired
    private HistoryService historyService;

    public Historys(){
        history_array = new ArrayList<>();
    }

    public ArrayList<History> getHistory_array() {
        return history_array;
    }

    public void setHistory_array(ArrayList<History> history_array) {
        this.history_array = history_array;
    }

    public void add(History history){
        history_array.add(history);
    }


    public void print(){
        for (int i = 0; i < history_array.size(); ++i) {
            System.out.println(history_array.get(i).getUid_atc());

        }
    }

    public Historys missing_call(History history){
        Historys missing_calls_client = new Historys();
        for (int i = 0; i < history_array.size(); ++i) {
            if (history_array.get(i).getClient().equals(history.getClient())){
                missing_calls_client.add(history_array.get(i));
            }
        }
        return missing_calls_client;
    }

    public void del_dublicate(){
        HashMap<String, History> hashMap = new HashMap<>();
        for (int i = 0; i < history_array.size(); ++i) {
            hashMap.put(history_array.get(i).getClient(),history_array.get(i));
        }
        history_array.clear();
        history_array = new ArrayList<>(hashMap.values());
    }


    public void save_bd(){
        for (int i = 0; i < history_array.size(); ++i) {
            historyService.save(history_array.get(i));
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
