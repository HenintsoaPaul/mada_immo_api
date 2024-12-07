package mada_immo.controller;

import lombok.RequiredArgsConstructor;
import mada_immo.service.LocationFilleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/clients" )
public class ClientController {
    private final LocationFilleService locationFilleService;

    @GetMapping( "/{idClient}/loyer" )
    public double findLoyerByIdClient(
            @PathVariable Long idClient,
            @RequestParam LocalDate dateDebut,
            @RequestParam LocalDate dateFin
    ) {
        return locationFilleService.findLoyerInIntvl( dateFin, dateDebut, idClient );
    }
}
