package mada_immo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_location_mere", referencedColumnName = "id_location" )
    private Location locationMere;

    /**
     * @return le pourcentage de commission
     */
    public double getCommission() {
        return this.getLocationMere().getBien().getTypeBien().getCommission();
    }

    /**
     * @return le commission apres calcul depuis le loyerMensuel
     */
    public double getCommissionDeductible() {
        return this.getLoyer() * this.getCommission();
    }

    public double getLoyer() {
        return this.getLocationMere().getBien().getLoyerMensuel();
    }

    public double getLoyerApresDeductionCommission() {
        return this.getLoyer() - this.getCommissionDeductible();
    }
}
