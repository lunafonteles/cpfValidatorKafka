package com.letscode.cpfValidator.service;


import com.letscode.cpfValidator.model.CpfRegister;
import com.letscode.cpfValidator.request.CpfRequest;
import java.util.List;

public interface CpfService {
    boolean cpfPrize ();
    void addWinner(CpfRequest cpfRequest);
    List<CpfRegister> getAll();
}
