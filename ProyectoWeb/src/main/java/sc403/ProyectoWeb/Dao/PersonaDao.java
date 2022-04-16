
package sc403.ProyectoWeb.Dao;

import org.springframework.data.repository.CrudRepository;
import sc403.ProyectoWeb.Domain.Persona;

public interface PersonaDao extends 
        CrudRepository<Persona, Long> {
}
