package ru.radcenter.ipphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.radcenter.ipphone.model.History;

@Repository
public interface HistoryRepository  extends JpaRepository<History,Long>
{
}
