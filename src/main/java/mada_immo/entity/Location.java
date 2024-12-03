package mada_immo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mada_immo.entity.olona.Client;
import mada_immo.entity.trano.Bien;
import mada_immo.entity.trano.TypeBien;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_location" )
    private Long idLocation;

    @Column( name = "date_debut" )
    private LocalDate dateDebut;

    private int duree;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_bien" )
    private Bien bien;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_client" )
    private Client client;
}
