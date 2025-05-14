package projeto_integrador1.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import projeto_integrador1.model.Registro;



public class RegistroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    
    public void cadastrarRegistro(Registro registro){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(registro);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Registro> listarRegistros() {
        EntityManager em = emf.createEntityManager();
        List<Registro> registros = em.createQuery("SELECT r FROM Registro r", Registro.class).getResultList();
        em.close();
        return registros;
}
    
    public List<Registro> filtrarPorRegistro(String registro) {
    EntityManager em = emf.createEntityManager();
    List<Registro> registros = em.createQuery(
            "SELECT r FROM Registro r WHERE r.curso_departamento = :registro", Registro.class)
            .setParameter("registro", registro)
            .getResultList();
    em.close();
    return registros;
}

    public void excluir(Registro registro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Registro r =em.find(Registro.class, registro.getId());
            if(r != null) {
                em.remove(r);
              }
            em.getTransaction().commit();
            }
            finally {
            em.close();
        }
    }

    
}
