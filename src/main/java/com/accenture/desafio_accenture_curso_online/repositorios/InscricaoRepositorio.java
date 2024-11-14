package com.accenture.desafio_accenture_curso_online.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.desafio_accenture_curso_online.entidades.Inscricao;

public interface InscricaoRepositorio extends JpaRepository <Inscricao, Long> {
	
	Optional<Inscricao> findById(Long id);
	
}
