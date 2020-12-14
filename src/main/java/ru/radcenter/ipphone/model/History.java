package ru.radcenter.ipphone.model;



import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import ru.radcenter.ipphone.services.AccountService;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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

    //вывод информации во view
    public String getTypePrint() {
        return type.label;

    }

    public void setType(String type) {
        this.type = TypeCall.valueOf(type);
    }

    public Date getStart() {
        return new Date(start.getTime() + 4 * HOUR);
    }

}
