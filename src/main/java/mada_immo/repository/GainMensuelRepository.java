package mada_immo.repository;


import mada_immo.dto.money.GainMensuel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GainMensuelRepository {
    @Query( value = "SELECT month_year, gain FROM gain_mensuel", nativeQuery = true )
    List<GainMensuel> findGainInIntvl( LocalDate d1, LocalDate d2 );
}
