package fon.bg.ac.rs.retailApp.models;

import java.util.Date;
//import javax.persistence.*;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordered_textile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedTextile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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