package fon.bg.ac.rs.retailApp.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedTextile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "textileid", insertable = false, updatable = false)
    private Textile textile;
    private Integer textileid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderedDate;

    private String orderedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    private String deliveryTime;

    private String piecePrice;
    private String specialNote;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false, updatable = false)
    private Client client;
    private Integer clientid;

}