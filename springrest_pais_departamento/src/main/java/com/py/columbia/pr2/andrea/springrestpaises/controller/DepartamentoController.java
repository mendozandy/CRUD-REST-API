package com.py.columbia.pr2.nildandrergio.springrestpaises.controller;

import com.py.columbia.pr2.nildandrergio.springrestpaises.exception.ResourceNotFoundException;
import com.py.columbia.pr2.nildandrergio.springrestpaises.model.Departamento;
import com.py.columbia.pr2.nildandrergio.springrestpaises.model.Pais;
import com.py.columbia.pr2.nildandrergio.springrestpaises.repository.PaisRepository;
import com.py.columbia.pr2.nildandrergio.springrestpaises.repository.DepartamentoRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartamentoController {

    private DepartamentoRepository departamentoRepository;
    private PaisRepository paisRepository;

    public DepartamentoController(DepartamentoRepository departamentoRepository, PaisRepository paisRepository) {
        this.departamentoRepository = departamentoRepository;
        this.paisRepository = paisRepository;
    }

    @GetMapping("/paises/{paisId}/departamentos")
    public List<Departamento> getDepartamentoByPaisId(@PathVariable Long paisId) {
        return departamentoRepository.findByPaisId(paisId);
    }

    @PostMapping("/paises/{paisId}/departamentos")
    public Departamento addDepartamento(@PathVariable Long paisId,
                            @Valid @RequestBody Pais departamento) {
        return paisRepository.findById(paisId)
                .map(pais -> {
                    departamento.setPais(pais);
                    return departamentoRepository.save(departamento);
                }).orElseThrow(() -> new ResourceNotFoundException("El pais no existe con id " + paisId));
    }
    
    @PutMapping("pais/{paisId}/departamentos/{departamentoId}")
    public Departamento updateDepartamento(@PathVariable Long paisId,
                               @PathVariable Long departamentoId,
                               @Valid @RequestBody Departamento departamentoRequest) {
        if(!paisRepository.existsById(paisId)) {
            throw new ResourceNotFoundException("Question not found with id " + paisId);
        }

        return departamentoRepository.findById(departamentoId)
                .map(departamentoBD -> {
                    departamentoBD.setNombre(departamentoRequest.getNombre());
                    return departamentoRepository.save(departamentoBD);
                }).orElseThrow(() -> new ResourceNotFoundException("El departamento no existe con id " + departamentoId));
    }

    @DeleteMapping("pais/{paisId}/departamentos/{departamentoId}")
    public ResponseEntity<?> deleteDepartamento(@PathVariable Long paisId,
                                          @PathVariable Long departamentoId) {
        if(!paisRepository.existsById(paisId)) {
            throw new ResourceNotFoundException("El pais no existe con id " + paisId);
        }

        return departamentoRepository.findById(departamentoId)
                .map(departamentoBD -> {
                    departamentoRepository.delete(departamentoBD);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("El departamento no existe con id id " + departamentoId));

    }
}
            
  