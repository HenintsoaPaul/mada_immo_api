package mada_immo.entity.trano;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mada_immo.entity.Region;
import mada_immo.entity.olona.Proprio;

@Data
@Entity
@NoArgsConstructor
public class Bien {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_bien" )
    @JsonView( BienViews.Basic.class )
    private Long idBien;

    @JsonView( BienViews.Basic.class )
    private String nom;

    private String description;

    @Column( name = "loyer_mensuel" )
    private double loyerMensuel;

    private String photos;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_type_bien" )
    private TypeBien typeBien;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_proprio" )
    @JsonView( BienViews.Basic.class )
    private Proprio proprio;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_region" )
    private Region region;
}
