package mada_immo.controller;

import lombok.RequiredArgsConstructor;
import mada_immo.dto.money.GainMensuel;
import mada_immo.dto.money.TurnoverAdminResponse;
import mada_immo.service.LocationFilleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController( "/admins" )
public class AdminController {
    private final LocationFilleService locationFilleService;

    @GetMapping( "/turnovers" )
    public TurnoverAdminResponse findTurnover(
            @RequestParam LocalDate dateDebut,
            @RequestParam LocalDate dateFin
    ) {
        return locationFilleService.findTurnoverAdminInIntvl( dateDebut, dateFin );
    }

    @GetMapping( "/gains" )
    public GainMensuel[] findGainMensuel(
            @RequestParam LocalDate dateDebut,
            @RequestParam LocalDate dateFin
    ) {
        return locationFilleService.findGainMensuelAdminInIntvl( dateDebut, dateFin );
    }
}
