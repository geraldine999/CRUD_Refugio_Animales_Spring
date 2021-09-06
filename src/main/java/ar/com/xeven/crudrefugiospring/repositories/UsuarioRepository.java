package ar.com.xeven.crudrefugiospring.repositories;

import ar.com.xeven.crudrefugiospring.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
