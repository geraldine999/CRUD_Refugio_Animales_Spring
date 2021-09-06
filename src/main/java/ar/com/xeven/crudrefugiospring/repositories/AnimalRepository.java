package ar.com.xeven.crudrefugiospring.repositories;

import ar.com.xeven.crudrefugiospring.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List <Animal> findAll();

    Animal getById(Integer idAnimal);

    void deleteById(Integer id);


    @Query("SELECT DISTINCT animal.color FROM Animal animal")
    List<String> findDistinctByColor();


    List<Animal> getAnimalByColor(String color);

    List<Animal> getAnimalByNombreContaining(String nombre);

    List<Animal> getAnimalsByEdadBetween(Integer edadDesde, Integer edadHasta);



}