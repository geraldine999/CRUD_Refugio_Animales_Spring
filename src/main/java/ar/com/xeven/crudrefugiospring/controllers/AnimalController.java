package ar.com.xeven.crudrefugiospring.controllers;

import ar.com.xeven.crudrefugiospring.entities.Animal;
import ar.com.xeven.crudrefugiospring.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("animales")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public String mostrarTodosLosAnimales(Model modelo){
        modelo.addAttribute("colores", animalService.getColores());
        modelo.addAttribute("animales", animalService.mostrarTodosLosAnimales());
        return "ver-animales";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam Optional<String> nombreORid, @RequestParam Optional<String> color, @RequestParam Optional<Integer> edad){
        if(color.isPresent() && !color.get().equals("0"))
            return "redirect:/animales/color/"+color.get();
        if(edad.isPresent() && edad.get()>0)
            return "redirect:/animales/edad/0/"+edad.get();
        if(nombreORid.isPresent() && !nombreORid.get().isEmpty())
            try{
                Integer id = Integer.parseInt(nombreORid.get());
                return "redirect:/animales/id/"+id;
            }catch (NumberFormatException e){
                return "redirect:/animales/nombre/"+nombreORid.get();
            }
        return "redirect:/animales";
    }

    @GetMapping("/color/{color}")
    public String buscarPorColor(@PathVariable String color, Model modelo){
        modelo.addAttribute("colores", animalService.getColores());
        modelo.addAttribute("animales", animalService.getAnimalesByColor(color));
        return "ver-animales";
    }


    @GetMapping("id/{idanimal}")
    public String buscarPorId(@PathVariable String idanimal, Model modelo){
        modelo.addAttribute("colores", animalService.getColores());
        modelo.addAttribute("animales", animalService.getAnimalbyId(idanimal));
        return "ver-animales";
    }

    @GetMapping("nombre/{nombre}")
    public String buscarPorNombre(@PathVariable String nombre, Model modelo){
        modelo.addAttribute("colores", animalService.getColores());
        modelo.addAttribute("animales", animalService.getAnimalByNombreContaining(nombre));
        return "ver-animales";
    }

    @GetMapping("/edad/{edadDesde}/{edadHasta}")
    public String buscarPorEdad(@PathVariable Integer edadDesde, @PathVariable Integer edadHasta, Model modelo){
        modelo.addAttribute("colores", animalService.getColores());
        modelo.addAttribute("animales", animalService.getAnimalesPorEdadDesdeYHasta(edadDesde, edadHasta));
        return "ver-animales";
    }

    @GetMapping("editar/{idanimal}")
    public String editarAnimal(@PathVariable String idanimal, Model modelo){
        modelo.addAttribute("animal", animalService.getAnimalbyId(idanimal).get(0));
        return "guardar-animal";
    }

    @DeleteMapping("borrar/{idanimal}")
    public String borrarAnimal(@PathVariable Integer idanimal, Model modelo){
        animalService.deleteById(idanimal);
        return "ver-animales";
    }

    @GetMapping("nuevo")
    public String agregarAnimal(Model modelo){
        modelo.addAttribute("animal", new Animal());
        return "guardar-animal";
    }

    @PostMapping("guardar")
    public String saveAnimal(@ModelAttribute Animal animal){
        animalService.save(animal);
        return "redirect:/animales";
    }
}
