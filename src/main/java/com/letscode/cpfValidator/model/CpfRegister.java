package com.letscode.cpfValidator.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "Register")
@Data
public class CpfRegister {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String uuid;

}
