/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc403.ProyectoWeb.Dao;

import org.springframework.data.repository.CrudRepository;
import sc403.ProyectoWeb.Domain.Evento;

/**
 *
 * @author danfe
 */
public interface EventoDao extends 
        CrudRepository<Evento, Long>{
    
}
