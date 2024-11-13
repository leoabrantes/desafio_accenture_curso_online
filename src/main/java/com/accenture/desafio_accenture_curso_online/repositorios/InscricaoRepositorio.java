package com.accenture.desafio_accenture_curso_online.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.desafio_accenture_curso_online.entidades.Curso;

public interface InscricaoRepositorio extends JpaRepository <Curso, Long> {
	
	Optional<Curso> findById(Long id);
	
}
