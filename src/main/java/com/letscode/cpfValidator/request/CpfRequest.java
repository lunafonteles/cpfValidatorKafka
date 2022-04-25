package com.letscode.cpfValidator.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CpfRequest {
    @NotBlank(message = "Nome a ser cadastrado é um item obrigatório")
    private String name;
    @org.hibernate.validator.constraints.br.CPF(message = "Adicione um CPF válido")
    private String Cpf;
}
