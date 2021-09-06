package ar.com.xeven.crudrefugiospring.services;

import ar.com.xeven.crudrefugiospring.entities.Animal;
import ar.com.xeven.crudrefugiospring.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> mostrarTodosLosAnimales(){
      return animalRepository.findAll();
    }



    public List <Animal> getAnimalbyId(String id_animal) {
        try{
            return List.of( animalRepository.getById(Integer.parseInt(id_animal)));
        }catch (NumberFormatException e){
            return null;
        }

    }

    public void deleteById(Integer id_animal) {
        animalRepository.deleteById(id_animal);
    }

    public void save(Animal animal) {
        animalRepository.save(animal);
    }


    public List<String> getColores(){
        return animalRepository.findDistinctByColor();
    }


    public List<Animal> getAnimalesByColor(String color) {
        return animalRepository.getAnimalByColor(color);

    }

    public List<Animal> getAnimalByNombreContaining(String nombre) {
        return  animalRepository.getAnimalByNombreContaining(nombre);
    }

    public List<Animal> getAnimalesPorEdadDesdeYHasta(Integer edadDesde, Integer edadHasta) {
        return animalRepository.getAnimalsByEdadBetween(edadDesde, edadHasta);
    }
}
