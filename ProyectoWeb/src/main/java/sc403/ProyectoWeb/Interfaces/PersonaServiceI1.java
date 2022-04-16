
package sc403.ProyectoWeb.Interfaces;

import java.util.List;
import sc403.ProyectoWeb.Domain.Persona1;


public interface PersonaServiceI1 {
    public List<Persona1> getPersonas();

    public void guardar(Persona1 persona1);

    public void eliminar(Persona1 persona1);

    public Persona1 getpersona(Persona1 persona1);
}
