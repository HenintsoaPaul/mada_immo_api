package mada_immo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import mada_immo.dto.money.TurnoverProprioResponse;
import mada_immo.entity.trano.Bien;
import mada_immo.entity.trano.BienViews;
import mada_immo.repository.BienRepository;
import mada_immo.service.LocationFilleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/proprios" )
public class ProprioController {
    private final BienRepository bienRepository;
    private final LocationFilleService locationFilleService;

    @GetMapping( "/{idProprio}/biens" )
    @JsonView( BienViews.Basic.class )
    public List<Bien> findAllByIdProprio( @PathVariable Long idProprio ) {
        return bienRepository.findAllByIdProprio( idProprio );
    }

    @GetMapping( "/{idProprio}/turnovers" )
    public TurnoverProprioResponse findTurnover(
            @PathVariable Long idProprio,
            @RequestParam LocalDate dateDebut,
            @RequestParam LocalDate dateFin
    ) {
        return locationFilleService.findTurnoverProprioInIntvl( dateDebut, dateFin, idProprio );
    }
}
