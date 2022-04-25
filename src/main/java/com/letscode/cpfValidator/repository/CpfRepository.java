package com.letscode.cpfValidator.repository;

import com.letscode.cpfValidator.model.CpfRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CpfRepository extends JpaRepository<CpfRegister, Long> {
    Optional<CpfRegister> findFirstByCpf(String cpf);
}
