package mada_immo.dto.money;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mada_immo.entity.LocationFille;

@Data
@EqualsAndHashCode( callSuper = true )
public class TurnoverProprioResponse extends TurnoverResponse {
    private Long idProprio;

    void setMontant() {
        double montant = 0;
        for ( LocationFille location : super.getLocationFilles() ) {
            montant += location.getLoyerApresDeductionCommission();
        }
        this.setMontant( montant );
    }

    public TurnoverProprioResponse( Long idProprio, LocationFille[] locationFilles ) {
        this.setIdProprio( idProprio );
        super.setLocationFilles( locationFilles );
    }
}
