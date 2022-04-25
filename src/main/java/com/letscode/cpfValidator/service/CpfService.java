package com.letscode.cpfValidator.service;

import com.letscode.cpfValidator.request.CpfRequest;
import com.letscode.cpfValidator.response.CpfResponse;

public interface CpfService {
    public CpfResponse execute(CpfRequest cpfRequest);
}
