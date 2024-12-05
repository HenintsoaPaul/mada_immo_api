package mada_immo.service;

import lombok.RequiredArgsConstructor;
import mada_immo.dto.money.TurnoverProprioResponse;
import mada_immo.entity.LocationFille;
import mada_immo.repository.LocationFilleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LocationFilleService {
    private final DateService dateService;
    private final LocationFilleRepository locationFilleRepository;

    public double findLoyerInIntvl( LocalDate dateDebut, LocalDate dateFin, Long idClient ) {
        double loyer = 0;
        LocalDate d1 = dateService.getFirstDayOfMonth( dateDebut ),
                d2 = dateService.getLastDayOfMonth( dateFin );
        for ( LocationFille lf : locationFilleRepository.findAllInIntvlByIdClient( d1, d2, idClient ) ) {
            loyer += lf.getLoyer();
        }
        return loyer;
    }

    public TurnoverProprioResponse findTurnoverProprioInIntvl( LocalDate dateDebut, LocalDate dateFin, Long idProprio ) {
        LocalDate d1 = dateService.getFirstDayOfMonth( dateDebut ),
                d2 = dateService.getLastDayOfMonth( dateFin );
        LocationFille[] locations = locationFilleRepository.findAllInIntvlByIdProprio( d1, d2, idProprio );
        return new TurnoverProprioResponse( idProprio, locations );
    }
}
