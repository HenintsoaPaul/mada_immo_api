package mada_immo.dto.auth;

import lombok.Data;

@Data
public class AuthAdminRequest {
    private String login;
    private String mdp;
}
