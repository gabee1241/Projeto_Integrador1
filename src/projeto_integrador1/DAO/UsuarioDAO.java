
package projeto_integrador1.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import projeto_integrador1.model.Usuario;


public class UsuarioDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    
    public Usuario buscarUsuario(String nome, String senha) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", Usuario.class)
                     .setParameter("nome", nome)
                     .setParameter("senha", senha)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    
}
