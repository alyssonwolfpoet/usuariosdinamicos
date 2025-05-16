package br.edu.ifce.usuariosdinamicos.repository;

import br.edu.ifce.usuariosdinamicos.entity.Usuario;
import br.edu.ifce.usuariosdinamicos.entity.Raca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UsuarioCustomRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Usuario> findAllUsuarios(String nome, String email, String cpf,
                                         Raca raca, Date dataInicio, Date dataFim) {
        String jpql = "SELECT u FROM Usuario u WHERE 1=1";

        if (nome != null) jpql += " AND u.nome = :nome";
        if (email != null) jpql += " AND u.email = :email";
        if (cpf != null) jpql += " AND u.cpf = :cpf";
        if (raca != null) jpql += " AND u.raca = :raca";
        if (dataInicio != null) jpql += " AND u.dataNascimento >= :dataInicio";
        if (dataFim != null) jpql += " AND u.dataNascimento <= :dataFim";

        var query = em.createQuery(jpql, Usuario.class);

        if (nome != null) query.setParameter("nome", nome);
        if (email != null) query.setParameter("email", email);
        if (cpf != null) query.setParameter("cpf", cpf);
        if (raca != null) query.setParameter("raca", raca);
        if (dataInicio != null) query.setParameter("dataInicio", dataInicio);
        if (dataFim != null) query.setParameter("dataFim", dataFim);

        return query.getResultList();
    }
}
