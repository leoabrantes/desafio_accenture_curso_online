package com.accenture.desafio_accenture_curso_online.controladores;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.desafio_accenture_curso_online.dto.AlunoDto;
import com.accenture.desafio_accenture_curso_online.servico.AlunoServico;


@RestController
@RequestMapping(value = "/alunos")
public class AlunoControlador {
	
	@Autowired
	private AlunoServico AlunoServico;
	
	@GetMapping
	public ResponseEntity<Page<AlunoDto>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "20") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<AlunoDto> list = AlunoServico.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDto> findById(@PathVariable Long id){
		AlunoDto dto = AlunoServico.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AlunoDto> delete(@PathVariable Long id){
		AlunoServico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoDto> update(@PathVariable Long id, @RequestBody AlunoDto dto){
		dto = AlunoServico.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDto> insert(@RequestBody AlunoDto AlunoDto){
		AlunoDto = AlunoServico.insert(AlunoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(AlunoDto.getId()).toUri();		
		return ResponseEntity.created(uri).body(AlunoDto);
	}
	
	

}
