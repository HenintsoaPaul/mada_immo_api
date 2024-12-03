package mada_immo.repository;


import mada_immo.entity.olona.Proprio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProprioRepository extends JpaRepository<Proprio, Long> {
    @Query( "SELECT p " +
            "FROM Proprio p " +
            "WHERE p.numTel = :numTel" )
    Proprio findByAuthentication( @Param( "numTel" ) String numTel );
}
