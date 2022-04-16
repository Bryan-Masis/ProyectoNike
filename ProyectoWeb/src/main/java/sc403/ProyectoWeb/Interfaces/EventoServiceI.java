/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc403.ProyectoWeb.Interfaces;

import java.util.List;
import sc403.ProyectoWeb.Domain.Evento;

/**
 *
 * @author danfe
 */
public interface EventoServiceI {
    public List<Evento> getEventos();

    public void guardar(Evento evento);

    public void eliminar(Evento evento);

    public Evento getEvento(Evento evento);
}
