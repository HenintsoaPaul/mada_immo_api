package mada_immo.entity.olona;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_admin" )
    private Long idAdmin;

    private String nom;

    private String login;

    private String mdp;
}
