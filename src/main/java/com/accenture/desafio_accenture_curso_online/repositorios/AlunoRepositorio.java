package com.accenture.desafio_accenture_curso_online.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.desafio_accenture_curso_online.entidades.Aluno;

public interface AlunoRepositorio extends JpaRepository <Aluno, Long> {
	
	Optional<Aluno> findById(Long id);
	
}
