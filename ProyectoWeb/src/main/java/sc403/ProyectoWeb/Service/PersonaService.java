
package sc403.ProyectoWeb.Service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc403.ProyectoWeb.Dao.PersonaDao;
import sc403.ProyectoWeb.Domain.Persona;
import sc403.ProyectoWeb.Interfaces.PersonaServiceI;

@Service
public class PersonaService implements PersonaServiceI {
    
    
    @Autowired
    private PersonaDao personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> getPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    public Persona getpersona(Persona persona) {
        return personaDao.findById(persona.getId()).orElse(null);
    }
    
    
}
