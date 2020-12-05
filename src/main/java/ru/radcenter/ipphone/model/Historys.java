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

    public void clear(){
        historyArray.clear();
    }
}
