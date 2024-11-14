package com.accenture.desafio_accenture_curso_online.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.desafio_accenture_curso_online.dto.AlunoDto;
import com.accenture.desafio_accenture_curso_online.entidades.Aluno;
import com.accenture.desafio_accenture_curso_online.excecoes.DatabaseException;
import com.accenture.desafio_accenture_curso_online.excecoes.ResourceNotFoundException;
import com.accenture.desafio_accenture_curso_online.repositorios.AlunoRepositorio;

import jakarta.persistence.EntityNotFoundException;

public class AlunoServico {
	
	@Autowired
	private AlunoRepositorio repositorio;
		
	@Transactional(readOnly = true)
	public AlunoDto findById(Long id) {
		Optional<Aluno> obj = repositorio.findById(id);
		Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		return new AlunoDto(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<AlunoDto> findAllPaged(PageRequest pageRequest){
		Page<Aluno> list = repositorio.findAll(pageRequest);
		
		return list.map(x -> new AlunoDto(x));
	}
	
	@Transactional
	public AlunoDto update(Long id, AlunoDto alunoDto) {
		try {
			Aluno aluno = repositorio.getOne(id);
			aluno.setNome(alunoDto.getNome());
			aluno.setEmail(alunoDto.getEmail());
			aluno.setDataCadastro(alunoDto.getDataCadastro());
			return new AlunoDto(aluno);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
	}

	@Transactional
	public AlunoDto insert(AlunoDto AlunoDto) {
		Aluno aluno = new Aluno();
		aluno.setNome(AlunoDto.getNome());
		aluno.setEmail(AlunoDto.getEmail());
		aluno.setDataCadastro(AlunoDto.getDataCadastro());
		aluno = repositorio.save(aluno);
		return new AlunoDto(aluno);

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



