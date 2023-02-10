package fon.bg.ac.rs.retailApp.models;

import java.util.Date;

import javax.persistence.*;
//import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_buying")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class InvoiceBuying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;

    @ManyToOne
    @JoinColumn(name = "invoicestatusid", insertable = false, updatable = false)
    private InvoiceStatus invoiceStatus;
    private Integer invoicestatusid;

    @ManyToOne
    @JoinColumn(name = "supplierid", insertable = false, updatable = false)
    private Supplier supplier;
    private Integer supplierid;


    private String specialRemarks;
    private int totalCost;
}
