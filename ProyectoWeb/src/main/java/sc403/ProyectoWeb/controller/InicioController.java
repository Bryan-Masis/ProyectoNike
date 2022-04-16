package sc403.ProyectoWeb.controller;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sc403.ProyectoWeb.Domain.Persona;
import sc403.ProyectoWeb.Service.PersonaService;
import sc403.ProyectoWeb.Domain.Evento;
import sc403.ProyectoWeb.Domain.Persona1;
import sc403.ProyectoWeb.Service.EventoService;
import sc403.ProyectoWeb.Service.PersonaService1;


@Controller
@Slf4j
public class InicioController {

    @Autowired
    private PersonaService1 personaService1;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private EventoService eventoService;
    
    @GetMapping("")
    public String pagina( ){
    return "inicio";
    }
    
     @GetMapping("login")
    public String login( ){
    return "login";
    }
    
    @GetMapping("campanaRio")
    public String pagina2( ){
    return "campanaRio";
    }
    
    @GetMapping("campanaPlaya")
    public String pagina3( ){
    return "campanaPlaya";
    }
    
   
    @GetMapping("/index")
    public String inicio(Model model) {
        
        var personas1 = personaService1.getPersonas();
        
        model.addAttribute("personas1", personas1);
        
        var personas = personaService.getPersonas();
        
        model.addAttribute("personas", personas);
        
        model.addAttribute("totalPersonas",(personas.size()+ personas1.size()));
        
        return "index";
    }
 
    @GetMapping("/voluntarios")
    public String voluntarios(Model model) {
        
        var personas = personaService.getPersonas();
        
        model.addAttribute("personas", personas);
        
        model.addAttribute("totalPersonas",personas.size());
        
        return "voluntarios";
    }
    
    @GetMapping("/voluntarios1")
    public String voluntarios1(Model model) {
        
        var personas1 = personaService1.getPersonas();
        
        model.addAttribute("personas1", personas1);
        
        model.addAttribute("totalPersonas",personas1.size());
        
        return "voluntarios1";
    }
    

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "actualizar";
    }
    
    @GetMapping("/agregar1")
    public String agregar(Persona1 persona) {
        return "actualizar1";
    }
    // Llama a un nuevo agregar en la pagina de Campaña Rio
    @GetMapping("/agregarRio")
    public String agregarRio(Persona persona) {
        return "actualizar";
    }
    
    // Llama a un nuevo agregar en la pagina de Campaña Playa
    @GetMapping("/agregarPlaya")
    public String agregarPlaya(Persona1 persona1) {
        return "actualizar1";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model) {
        persona = personaService.getpersona(persona);
        model.addAttribute("persona", persona);
        return "actualizar";
    }
    
    @GetMapping("/editar1/{id}")
    public String editar1(Persona1 persona1, Model model) {
        persona1 = personaService1.getpersona(persona1);
        model.addAttribute("persona1", persona1);
        return "actualizar1";
    }
    
     @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/index";
    }
    
    @GetMapping("/eliminar1/{id}")
    public String eliminar(Persona1 persona1) {
        personaService1.eliminar(persona1);
        return "redirect:/index";
    }
    
    @GetMapping("/guardar")
    public String guardar(Persona persona) {
        personaService.guardar(persona);
        return "redirect:/voluntarios";
    }
    
    @GetMapping("/guardar1")
    public String guardar(Persona1 persona1) {
        personaService1.guardar(persona1);
        return "redirect:/voluntarios1";
    }
    
    @GetMapping("/eventos")
    public String eventos(Model model) {
         var eventos = eventoService.getEventos();
        
        model.addAttribute("eventos", eventos);
        
        model.addAttribute("totalEventos",eventos.size());
        
        return "eventos";
    }
    
    @GetMapping("/editarEvento/{id}")
    public String editarEvento(Evento evento, Model model) {
        evento = eventoService.getEvento(evento);
        model.addAttribute("evento", evento);
        return "actualizarEvento";
    }
    
    @GetMapping("/eliminarEvento/{id}")
    public String eliminarevento(Evento evento) {
        eventoService.eliminar(evento);
        return "redirect:/eventos";
    }
    
    @GetMapping("/agregarEvento")
    public String agregar(Evento evento) {
        return "actualizarEvento";
    }
    
    @GetMapping("/guardarEvento")
    public String guardarevento(Evento evento) {
        eventoService.guardar(evento);
        return "redirect:/eventos";
    }

}
