
package sc403.ProyectoWeb.Interfaces;

import java.util.List;
import sc403.ProyectoWeb.Domain.Persona;

public interface PersonaServiceI {
    public List<Persona> getPersonas();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona getpersona(Persona persona);
}
