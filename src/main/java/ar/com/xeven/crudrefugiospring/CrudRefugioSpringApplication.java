package ar.com.xeven.crudrefugiospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class CrudRefugioSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudRefugioSpringApplication.class, args);
    }



}
