package ru.radcenter.ipphone.dto;

import lombok.Data;

import java.util.Date;

@Data
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

}
