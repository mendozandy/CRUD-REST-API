/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.py.columbia.pr2.nildandrergio.springrestpaises.repository;

import com.py.columbia.pr2.nildandrergio.springrestpaises.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository <Pais,Long> {
    
}
