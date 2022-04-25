package com.letscode.cpfValidator.service;

import com.letscode.cpfValidator.model.CpfRegister;
import com.letscode.cpfValidator.repository.CpfRepository;
import com.letscode.cpfValidator.request.CpfRequest;
import com.letscode.cpfValidator.response.CpfResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CpfServiceImpl implements CpfService {

    private final CpfRepository cpfRepository;

    @Override
    public CpfResponse execute(CpfRequest cpfRequest) {
        Optional<CpfRegister> existentRegister = cpfRepository.findFirstByCpf(cpfRequest.getCpf());
        String uuid = UUID.randomUUID().toString();
        if(existentRegister.isEmpty()) {
            CpfRegister registroCPF = new CpfRegister();
            registroCPF.setCpf(cpfRequest.getCpf());
            registroCPF.setNome(cpfRequest.getName());
            registroCPF.setUuid(uuid);
            cpfRepository.save(registroCPF);
        }else{
            uuid = existentRegister.get().getUuid();
        }

        CpfResponse cpfResponse = CpfResponse.fromRequest(cpfRequest);
        cpfResponse.setId(uuid);


        return cpfResponse;
    }
}
