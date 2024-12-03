package mada_immo.repository;


import mada_immo.entity.olona.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query( "SELECT a " +
            "FROM Admin a " +
            "WHERE a.login = :login AND a.mdp = :mdp" )
    Admin findByAuthentication( @Param( "login" ) String login, @Param( "mdp" ) String mdp );
}
