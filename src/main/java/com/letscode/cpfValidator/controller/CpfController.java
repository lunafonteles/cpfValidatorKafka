package com.letscode.cpfValidator.controller;

import com.letscode.cpfValidator.model.CpfRegister;
import com.letscode.cpfValidator.request.CpfRequest;
import com.letscode.cpfValidator.response.CpfResponse;
import com.letscode.cpfValidator.service.CpfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cpf")
@RequiredArgsConstructor
public class CpfController {
    private final CpfService cpfService;

    @PostMapping("validator")
    @ResponseStatus(code = HttpStatus.CREATED)
    public boolean cpfPrizeValidator(){
        return cpfService.cpfPrize();
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CpfRegister> getCpfWinners() {

        return cpfService.getAll();
    }
}


