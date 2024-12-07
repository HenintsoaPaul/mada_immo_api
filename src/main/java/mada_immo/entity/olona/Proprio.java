package mada_immo.entity.olona;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mada_immo.entity.trano.BienViews;

@Data
@Entity
@NoArgsConstructor
public class Proprio {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_proprio" )
    @JsonView( BienViews.Basic.class )
    private Long idProprio;

    @JsonView( BienViews.Basic.class )
    private String nom;

    @Column( name = "num_tel" )
    private String numTel;
}
