package mada_immo.repository;


import mada_immo.entity.olona.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query( "SELECT c " +
            "FROM Client c " +
            "WHERE c.email = :email" )
    Client findByAuthentication( @Param( "email" ) String email );
}
