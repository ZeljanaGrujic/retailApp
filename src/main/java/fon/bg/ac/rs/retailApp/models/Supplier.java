package fon.bg.ac.rs.retailApp.models;

import javax.persistence.*;

//import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "suplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String fullName;
    private String phone;
    private String email;
    private String companyName;
    private String details;


//    @ManyToOne
//    @JoinColumn(name = "countryid", insertable = false, updatable = false)
//    private Country country;
//    private Integer countryid;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false, updatable = false)
    private Location location;
    private Integer locationid;


}