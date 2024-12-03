package mada_immo.entity.trano;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table( name = "type_bien" )
@NoArgsConstructor
public class TypeBien {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_type_bien" )
    private Long idTypeBien;

    private String nom;

    private double commission;
}
