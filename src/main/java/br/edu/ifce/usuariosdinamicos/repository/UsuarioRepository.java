package br.edu.ifce.usuariosdinamicos.repository;

import br.edu.ifce.usuariosdinamicos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
