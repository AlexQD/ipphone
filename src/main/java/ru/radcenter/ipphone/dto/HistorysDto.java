package ru.radcenter.ipphone.dto;

import ru.radcenter.ipphone.model.History;

import java.util.ArrayList;

public class HistorysDto {
    private ArrayList<History> historyArray;

    public HistorysDto(){
        historyArray = new ArrayList<>();
    }

    public ArrayList<History> getHistoryArray() {
        return historyArray;
    }

    public void setHistoryArray(ArrayList<History> historyArray) {
        this.historyArray = historyArray;
    }
}
