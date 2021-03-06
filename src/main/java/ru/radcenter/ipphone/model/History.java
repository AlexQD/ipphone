package ru.radcenter.ipphone.model;



import org.springframework.beans.factory.annotation.Autowired;
import ru.radcenter.ipphone.services.AccountService;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="history")
public class History {

    @Id
    @Column(name="uid_atc")
    private Long uidAtc;

    @Enumerated(EnumType.STRING)
    private TypeCall type;
    private String client; //номер клиента

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "account_id"), name = "account")
    private Account account;

    private String via; // номер клиента
    private Date start; // дата начала звонка
    private String wait; // ожидание;
    private String duration; // длителность разговора
    private String record;



    //Хранит информацию о всех вызовах с этого номера
    @Transient
    private Historys allCallThisNumber;


    public static final long HOUR = 3600*1000; // in milli-seconds.


    public Long getUidAtc() {
        return uidAtc;
    }

    public void setUidAtc(Long uidAtc) {
        this.uidAtc = uidAtc;
    }

    public String getType() {
        return type.toString();

    }

    //вывод информации во view
    public String getTypePrint() {
        return type.label;

    }


    public void setType(String type) {
        this.type = TypeCall.valueOf(type);
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getVia() {
       return this.via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Date getStart() {
        return new Date(start.getTime() + 4 * HOUR);
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


    public Historys getAllCallThisNumber() {
        return allCallThisNumber;
    }

    public void setAllCallThisNumber(Historys allCallThisNumber) {
        this.allCallThisNumber = allCallThisNumber;
    }

}
