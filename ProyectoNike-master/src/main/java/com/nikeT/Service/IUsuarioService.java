package com.nikeT.Service;

import com.nikeT.Entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioService {

    public List<Usuario> getAllUsers();

    public void saveUser(Usuario usuario);

    public Usuario getUserById(long id);

    public void delete(long id);
}
