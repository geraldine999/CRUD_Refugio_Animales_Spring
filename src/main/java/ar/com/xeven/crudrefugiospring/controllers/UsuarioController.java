package ar.com.xeven.crudrefugiospring.controllers;

import ar.com.xeven.crudrefugiospring.entities.Animal;
import ar.com.xeven.crudrefugiospring.entities.Usuario;
import ar.com.xeven.crudrefugiospring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("nuevo")
    public String nuevoUsuario(Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return "guardar-usuario";
    }

    @PostMapping("guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping("borrar/{id_usuario}")
    public String borrarUsuario(@PathVariable Integer id_usuario){
        usuarioService.deleteById(id_usuario);
        return "ver-usuarios";
    }

    @GetMapping("editar/{id_usuario}")
    public String editarUsuario(@PathVariable Integer id_usuario, Model modelo){
        modelo.addAttribute("usuario", usuarioService.getUsuarioById(id_usuario));
        return "guardar-usuario";
    }


    @GetMapping()
    public String mostrarTodosLosUsuarios(Model modelo){
        modelo.addAttribute("colores", usuarioService.getUsuarios());
        return "ver-usuarios";
    }
}
