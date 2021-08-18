/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.py.columbia.pr2.nildandrergio.springrestpaises.repository;

import com.py.columbia.pr2.nildandrergio.springrestpaises.model.Departamento;
import com.py.columbia.pr2.nildandrergio.springrestpaises.model.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository <Departamento,Long> {
    List <Departamento> FindByPaisId (Long id);

    public List<Departamento> findByPaisId(Long paisId);

    public Departamento save(Pais departamento);

}
