package ru.radcenter.ipphone.dto;

import java.util.Date;

public class HistoryDto {
    private Long uidAtc;
    private String type;
    private String client; //номер клиента
    private String account;
    private String via; // номер клиента
    private Date start; // дата начала звонка
    private String wait; // ожидание;
    private String duration; // длителность разговора
    private String record;

    public Long getUidAtc() {
        return uidAtc;
    }

    public void setUidAtc(Long uidAtc) {
        this.uidAtc = uidAtc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getWait() {
        return wait;
    }

    public void setWait(String wait) {
        this.wait = wait;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
