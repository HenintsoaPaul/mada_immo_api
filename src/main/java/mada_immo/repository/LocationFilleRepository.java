package mada_immo.repository;


import mada_immo.entity.LocationFille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface LocationFilleRepository extends JpaRepository<LocationFille, Long> {
    @Query( "SELECT lf " +
            "FROM LocationFille lf " +
            "   join Location l on lf.locationMere.idLocation = l.idLocation " +
            "WHERE lf.dateLocation between :d1 and :d2 " +
            "   and l.client.idClient = :idClient" )
    LocationFille[] findAllInIntvlByIdClient(
            @Param( "d1" ) LocalDate d1,
            @Param( "d2" ) LocalDate d2,
            @Param( "idClient" ) Long idClient
    );

    @Query( "SELECT lf " +
            "FROM LocationFille lf " +
            "   join Location l on lf.locationMere.idLocation = l.idLocation " +
            "WHERE lf.dateLocation between :d1 and :d2 " +
            "   and l.bien.proprio.idProprio = :idProprio" )
    LocationFille[] findAllInIntvlByIdProprio(
            @Param( "d1" ) LocalDate d1,
            @Param( "d2" ) LocalDate d2,
            @Param( "idProprio" ) Long idProprio
    );

    @Query( "SELECT lf " +
            "FROM LocationFille lf " +
            "WHERE lf.dateLocation between :d1 and :d2" )
    LocationFille[] findAllInIntvl( LocalDate d1, LocalDate d2 );
}
