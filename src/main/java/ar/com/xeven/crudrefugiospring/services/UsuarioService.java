package ar.com.xeven.crudrefugiospring.services;

import ar.com.xeven.crudrefugiospring.entities.Usuario;
import ar.com.xeven.crudrefugiospring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void save(Usuario usuario) {
        String claveHasheada = encoder.encode(usuario.getClave());
        usuario.setClave(claveHasheada);
        usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id_usuario) {
        usuarioRepository.deleteById(id_usuario);
    }

    public Usuario getUsuarioById(Integer id_usuario) {
        return usuarioRepository.findById(id_usuario).orElse(null);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
