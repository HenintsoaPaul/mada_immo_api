package mada_immo.dto.money;

import lombok.Data;
import mada_immo.entity.LocationFille;

@Data
public class TurnoverAdminResponse extends TurnoverResponse {
    void setMontant() {
        double montant = 0;
        for ( LocationFille location : super.getLocationFilles() ) {
            montant += location.getCommissionDeductible();
        }
        this.setMontant( montant );
    }

    public TurnoverAdminResponse( LocationFille[] locationFilles ) {
        super.setLocationFilles( locationFilles );
    }
}
