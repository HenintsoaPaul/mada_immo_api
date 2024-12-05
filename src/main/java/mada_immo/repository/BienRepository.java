package mada_immo.repository;


import mada_immo.entity.trano.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BienRepository extends JpaRepository<Bien, Long> {
    @Query( "SELECT b " +
            "FROM Bien b " +
            "WHERE b.proprio.idProprio = :idProprio" )
    List<Bien> findAllByIdProprio( @Param( "idProprio" ) Long idProprio );
}
