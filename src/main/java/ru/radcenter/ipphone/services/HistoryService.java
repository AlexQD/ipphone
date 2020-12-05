package ru.radcenter.ipphone.services;

import ru.radcenter.ipphone.dto.HistoryDto;
import ru.radcenter.ipphone.model.History;

public interface HistoryService {
    public void save(History history);
}
