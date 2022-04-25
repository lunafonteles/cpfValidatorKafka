package com.letscode.cpfValidator.controller;

import com.letscode.cpfValidator.request.CpfRequest;
import com.letscode.cpfValidator.response.CpfResponse;
import com.letscode.cpfValidator.service.CpfServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cpf")
@RequiredArgsConstructor
public class CpfController {
    private final CpfServiceImpl cpfServiceImpl;

    @PostMapping("add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CpfResponse addCpf(@RequestBody CpfRequest cpfRequest){
        return cpfServiceImpl.execute(cpfRequest);
    }
}


