package mada_immo.dto.money;

import lombok.Data;
import mada_immo.entity.LocationFille;

@Data
public abstract class TurnoverResponse {
    private double montant;
    private LocationFille[] locationFilles;

    abstract void setMontant();

    protected void setLocationFilles( LocationFille[] locationFilles ) {
        this.locationFilles = locationFilles;
        this.setMontant();
    }
}
