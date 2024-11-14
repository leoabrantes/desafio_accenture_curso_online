package com.accenture.desafio_accenture_curso_online.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.desafio_accenture_curso_online.dto.CursoDto;
import com.accenture.desafio_accenture_curso_online.entidades.Curso;
import com.accenture.desafio_accenture_curso_online.excecoes.DatabaseException;
import com.accenture.desafio_accenture_curso_online.excecoes.ResourceNotFoundException;
import com.accenture.desafio_accenture_curso_online.repositorios.CursoRepositorio;

import jakarta.persistence.EntityNotFoundException;

public class CursoServico {
	
	@Autowired
	private CursoRepositorio repositorio;
		
	@Transactional(readOnly = true)
	public CursoDto findById(Long id) {
		Optional<Curso> obj = repositorio.findById(id);
		Curso entity = obj.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
		return new CursoDto(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<CursoDto> findAllPaged(PageRequest pageRequest){
		Page<Curso> list = repositorio.findAll(pageRequest);
		
		return list.map(x -> new CursoDto(x));
	}
	
	@Transactional
	public CursoDto update(Long id, CursoDto cursoDto) {
		try {
			Curso curso = repositorio.getOne(id);
			curso.setNome(cursoDto.getNome());
			curso.setDescricao(cursoDto.getDescricao());
			curso.setDataCriacao(cursoDto.getDataCriacao());
			return new CursoDto(curso);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
	}

	@Transactional
	public CursoDto insert(CursoDto CursoDto) {
		Curso curso = new Curso();
		curso.setNome(CursoDto.getNome());
		curso.setDescricao(CursoDto.getDescricao());
		curso.setDataCriacao(CursoDto.getDataCriacao());
		curso = repositorio.save(curso);
		return new CursoDto(curso);

	}

	

	public void delete(Long id) {

		try {
		repositorio.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de Integridade");
		}
	}
	
	
}



