package com.accenture.desafio_accenture_curso_online.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.desafio_accenture_curso_online.dto.InscricaoDto;
import com.accenture.desafio_accenture_curso_online.entidades.Inscricao;
import com.accenture.desafio_accenture_curso_online.excecoes.DatabaseException;
import com.accenture.desafio_accenture_curso_online.excecoes.ResourceNotFoundException;
import com.accenture.desafio_accenture_curso_online.repositorios.InscricaoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InscricaoServico {
	
	@Autowired
	private InscricaoRepositorio repositorio;
		
	@Transactional(readOnly = true)
	public InscricaoDto findById(Long id) {
		Optional<Inscricao> obj = repositorio.findById(id);
		Inscricao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrado"));
		return new InscricaoDto(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<InscricaoDto> findAllPaged(PageRequest pageRequest){
		Page<Inscricao> list = repositorio.findAll(pageRequest);
		
		return list.map(x -> new InscricaoDto(x));
	}
	
	@Transactional
	public InscricaoDto update(Long id, InscricaoDto inscricaoDto) {
		try {
			Inscricao inscricao = repositorio.getOne(id);
			inscricao.setAluno_id(inscricaoDto.getAluno_id());
			inscricao.setCurso_id(inscricaoDto.getCurso_id());
			inscricao.setDataInscricao(inscricaoDto.getDataInscricao());
			return new InscricaoDto(inscricao);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
	}

	@Transactional
	public InscricaoDto insert(InscricaoDto InscricaoDto) {
		Inscricao inscricao = new Inscricao();
		inscricao.setAluno_id(InscricaoDto.getAluno_id());
		inscricao.setCurso_id(InscricaoDto.getCurso_id());
		inscricao.setDataInscricao(InscricaoDto.getDataInscricao());
		inscricao = repositorio.save(inscricao);
		return new InscricaoDto(inscricao);

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



