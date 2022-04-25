package com.letscode.cpfValidator.response;

import com.letscode.cpfValidator.request.CpfRequest;
import lombok.Data;

@Data
public class CpfResponse extends CpfRequest {
    private String id;

    public static CpfResponse fromRequest(CpfRequest cpfRequest) {
        var response = new CpfResponse();
        response.setCpf(cpfRequest.getCpf());
        response.setName(cpfRequest.getName());
        return response;
    }
}
