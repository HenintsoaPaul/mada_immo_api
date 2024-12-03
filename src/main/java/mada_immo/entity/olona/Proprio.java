package mada_immo.entity.olona;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Proprio {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_proprio" )
    private Long idProprio;

    private String nom;

    @Column( name = "num_tel" )
    private String numTel;
}
