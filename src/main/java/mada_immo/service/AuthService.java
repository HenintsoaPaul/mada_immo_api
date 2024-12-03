package mada_immo.service;

import lombok.RequiredArgsConstructor;
import mada_immo.dto.auth.AuthAdminRequest;
import mada_immo.dto.auth.AuthClientRequest;
import mada_immo.dto.auth.AuthProprioRequest;
import mada_immo.entity.olona.Admin;
import mada_immo.entity.olona.Client;
import mada_immo.entity.olona.Proprio;
import mada_immo.repository.AdminRepository;
import mada_immo.repository.ClientRepository;
import mada_immo.repository.ProprioRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AdminRepository adminRepository;
    private final ProprioRepository proprioRepository;
    private final ClientRepository clientRepository;

    public Admin authAdmin( AuthAdminRequest req ) {
        return adminRepository.findByAuthentication( req.getLogin(), req.getMdp() );
    }

    public Proprio authProprio( AuthProprioRequest req ) {
        return proprioRepository.findByAuthentication( req.getNumTel() );
    }

    public Client authClient( AuthClientRequest req ) {
        return clientRepository.findByAuthentication( req.getEmail() );
    }
}
