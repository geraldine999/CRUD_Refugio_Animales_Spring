package ar.com.xeven.crudrefugiospring.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="animales")
public class Animal implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_animal;
    private String nombre;
    private String color;
    private Integer edad;

    public Animal() {
    }

    public Animal(Integer id_animal, String nombre, String color, Integer edad) {
        this.id_animal = id_animal;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
    }

    public Animal(String nombre, String color, Integer edad) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
    }

    public Integer getIdanimal() {
        return id_animal;
    }

    public void setIdanimal(Integer id_animal) {
        this.id_animal = id_animal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id_animal=" + id_animal +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", edad=" + edad +
                '}';
    }
}


