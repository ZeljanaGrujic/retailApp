package fon.bg.ac.rs.retailApp.dtos;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fon.bg.ac.rs.retailApp.models.Client;
import fon.bg.ac.rs.retailApp.models.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceSellingDto {


    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;


    private InvoiceStatus invoiceStatus;
    private Integer invoicestatusid;


    private Client client;
    private Integer clientid;

    private String specialRemarks;
    private int totalCost;
}
