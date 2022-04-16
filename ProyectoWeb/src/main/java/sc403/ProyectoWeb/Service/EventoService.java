/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc403.ProyectoWeb.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc403.ProyectoWeb.Dao.EventoDao;
import sc403.ProyectoWeb.Domain.Evento;
import sc403.ProyectoWeb.Interfaces.EventoServiceI;

/**
 *
 * @author danfe
 */
@Service
public class EventoService implements EventoServiceI{
    
    @Autowired
    private EventoDao eventoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> getEventos() {
        return (List<Evento>) eventoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Evento evento) {
        eventoDao.save(evento);
    }

    @Override
    public void eliminar(Evento evento) {
        eventoDao.delete(evento);
    }

    @Override
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getId()).orElse(null);
    }

    
}
