package com.py.columbia.pr2.nildandrergio.springrestpaises.controller;


import com.py.columbia.pr2.nildandrergio.springrestpaises.exception.ResourceNotFoundException;
import com.py.columbia.pr2.nildandrergio.springrestpaises.model.Pais;
import com.py.columbia.pr2.nildandrergio.springrestpaises.repository.PaisRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pais"})
public class PaisController {

    @Autowired(required = true)
    private PaisRepository paisRepository;


    @GetMapping
    public Page<Pais> getPaises(Pageable pageable) {
        return paisRepository.findAll(pageable);
    }


    @PostMapping
    public Pais crearPais(@Valid @RequestBody Pais pais) {
        return paisRepository.save(pais);
    }

    @PutMapping("/{paisId}")
    public Pais actualizarPais(@PathVariable Long paisId,
                                   @Valid @RequestBody Pais paisRequest) {
        return paisRepository.findById(paisId)
                .map(paisBD -> {
                    paisBD.setNombre(paisRequest.getNombre());
                    paisBD.setDescripcion(paisRequest.getDescripcion());
                    return paisRepository.save(paisBD);
                }).orElseThrow(() -> new ResourceNotFoundException("No existe la pregunta con id " + paisId));
    }


    @DeleteMapping("/{paisId}")
    public ResponseEntity<?> eliminarPais(@PathVariable Long paisId) {
        return paisRepository.findById(paisId)
                .map(paisBD -> {
                    paisRepository.delete(paisBD);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("No existe el pais con id " + paisId));
    }
}