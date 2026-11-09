package com.thiago.usuario.infraestructure.repository;

import com.thiago.usuario.infraestructure.entidy.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
