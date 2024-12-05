package mada_immo.dto.money;

import lombok.Data;
import mada_immo.entity.LocationFille;

@Data
public class TurnoverProprioResponse {
    private Long idProprio;
    private double montant;
    private LocationFille[] locationFilles;

    private void setMontant() {
        double montant = 0;
        for ( LocationFille location : locationFilles ) {
            montant += location.getLoyerApresDeductionCommission();
        }
        this.setMontant( montant );
    }

    public void setLocationFilles( LocationFille[] locationFilles ) {
        this.locationFilles = locationFilles;
        this.setMontant();
    }

    public TurnoverProprioResponse( Long idProprio, LocationFille[] locationFilles ) {
        this.setIdProprio( idProprio );
        this.setLocationFilles( locationFilles );
    }
}
