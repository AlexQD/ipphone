package ru.radcenter.ipphone.services;

import ru.radcenter.ipphone.dto.HistoryDto;
import ru.radcenter.ipphone.dto.HistorysDto;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.model.Historys;

public interface HistorysService {
    void save(HistorysDto historysDto);
    void print(HistorysDto historyDto);
}
