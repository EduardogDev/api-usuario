package com.eduardodev.api_usuario.business;

import com.eduardodev.api_usuario.infrastructure.entities.Usuario;
import com.eduardodev.api_usuario.infrastructure.repository.UsuarioRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Usuario usuario){
        Optional<Usuario> usuarioExiste = usuarioRepository.findById(usuario.getID());

        if(usuarioExiste.isPresent()){
            return usuarioRepository.save(usuario);
        }return new Usuario();
    }

    public void deletarUsuario(String Id){
        usuarioRepository.deleteById(Id);
    }
}
