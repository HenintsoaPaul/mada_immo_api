package mada_immo.controller;

import lombok.RequiredArgsConstructor;
import mada_immo.dto.auth.AuthAdminRequest;
import mada_immo.dto.auth.AuthClientRequest;
import mada_immo.dto.auth.AuthProprioRequest;
import mada_immo.entity.olona.Admin;
import mada_immo.entity.olona.Client;
import mada_immo.entity.olona.Proprio;
import mada_immo.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController( "/auth" )
public class AuthController {
    private final AuthService authService;

    @PostMapping( "/admin" )
    public Admin authAdmin( @RequestBody AuthAdminRequest request ) {
        return authService.authAdmin( request );
    }

    @PostMapping( "/proprio" )
    public Proprio authProprio( @RequestBody AuthProprioRequest request ) {
        return authService.authProprio( request );
    }

    @PostMapping( "/client" )
    public Client authClient( @RequestBody AuthClientRequest request ) {
        return authService.authClient( request );
    }
}
