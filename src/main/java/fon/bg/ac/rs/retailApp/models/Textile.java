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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Textile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String uniqueCode;
    private double piecePrice;
    private String specialDescription;
    private int availableQuantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date acquisitionDate; //date for when it arrived at our store

    @ManyToOne
    @JoinColumn(name = "textiletypeid", insertable = false, updatable = false)
    private TextileType textileType;
    private Integer textiletypeid;


    @ManyToOne
    @JoinColumn(name = "textilemakeid", insertable = false, updatable = false)
    private TextileMake textleMake;
    private Integer textilemakeid;


    @ManyToOne
    @JoinColumn(name = "textilemodelid", insertable = false, updatable = false)
    private TextileModel textileModel;
    private Integer textilemodelid;


    @ManyToOne
    @JoinColumn(name = "textilestatusid", insertable = false, updatable = false)
    private TextileStatus textileStatus;
    private Integer textilestatusid;

    @ManyToOne
    @JoinColumn(name = "employeeid", insertable = false, updatable = false)
    private Employee inCharge;
    private Integer employeeid;

    @ManyToOne
    @JoinColumn(name = "supplierid", insertable = false, updatable = false)
    private Supplier supplier;
    private Integer supplierid;

}
