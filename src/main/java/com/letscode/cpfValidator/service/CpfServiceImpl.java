package com.letscode.cpfValidator.service;

import com.letscode.cpfValidator.model.CpfRegister;
import com.letscode.cpfValidator.repository.CpfRepository;
import com.letscode.cpfValidator.request.CpfRequest;
import com.letscode.cpfValidator.response.CpfResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CpfServiceImpl implements CpfService {

    private final CpfRepository cpfRepository;

    public boolean cpfPrize() {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(6) + 1;
        System.out.println("Número gerado: " + valor);
        if (valor %2 == 0) {
            return true;
        }
        return false;
    }

    public void addWinner(CpfRequest cpfRequest) {
        CpfRegister cpfRegister = new CpfRegister();
        cpfRegister.setCpf(cpfRequest.getCpf());
        cpfRegister.setNome(cpfRequest.getName());

        cpfRepository.save(cpfRegister);
    }

    @Override
    public List<CpfRegister> getAll() {
        return cpfRepository.findAll();
    }
}
