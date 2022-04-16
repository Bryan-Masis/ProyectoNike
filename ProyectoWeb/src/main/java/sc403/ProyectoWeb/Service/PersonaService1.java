
package sc403.ProyectoWeb.Service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc403.ProyectoWeb.Dao.PersonaDao1;
import sc403.ProyectoWeb.Domain.Persona1;
import sc403.ProyectoWeb.Interfaces.PersonaServiceI1;

@Service
public class PersonaService1 implements PersonaServiceI1 {
    
    
    @Autowired
    private PersonaDao1 personaDao1;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona1> getPersonas() {
        return (List<Persona1>) personaDao1.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona1 persona1) {
        personaDao1.save(persona1);
    }

    @Override
    public void eliminar(Persona1 persona1) {
        personaDao1.delete(persona1);
    }

    @Override
    public Persona1 getpersona(Persona1 persona1) {
        return personaDao1.findById(persona1.getId()).orElse(null);
    }
    
    
}
