package mada_immo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mada_immo.entity.olona.Client;
import mada_immo.entity.trano.Bien;

import java.time.LocalDate;

@Data
@Entity
@Table( name = "location_fille" )
@NoArgsConstructor
public class LocationFille {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_location_fille" )
    private Long idLocationFille;

    @Column( name = "date_location" )
    private LocalDate dateLocation;

    @Column( name = "montant_loyer" )
    private double montantLoyer;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_location_mere" )
    private Location location_mere;
}
