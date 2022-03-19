package com.nikeT.Controller;

import com.nikeT.Entity.Usuario;
import com.nikeT.Service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/verUsuarios")
    public String Read(Model model) {
        List<Usuario> listaUsuario = usuarioService.getAllUsers();
        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuario", listaUsuario);
        return "VerUsuario";
    }

    @GetMapping("/crearUsuario")
    public String Create(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Registrarse";
    }

    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.saveUser(usuario);
        return "redirect:/VerUsuario";
    }

    @GetMapping("/nuevoUsuario")
    public String nuevaPerson(Usuario Usuario) {
        return "modificarUsuario";
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Long idUsuario) {
        usuarioService.delete(idUsuario);
        return "redirect/VerUsuario";
    }

    @GetMapping("/editUsuario/{id}")
    public String Update(@PathVariable("id") Long idUsuario, Model model) {
        Usuario s = usuarioService.getUserById(idUsuario);
        model.addAttribute("usuario", s);
        return "Registrarse";
    }
}
