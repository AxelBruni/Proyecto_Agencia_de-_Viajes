package persistencia.DAO.JPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import logica.Usuario;
import persistencia.DAO.UsuarioDAO;


public class UsuarioDAOJPAImp extends GenericDAOJPAImp <Usuario, Integer> implements UsuarioDAO {
    
    @Override
    public List<Usuario> buscarTodos() {
        
        EntityManager em = getEntityManager();
        

        try {
            TypedQuery consulta = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            return consulta.getResultList();
        }
        finally {
            em.close();
        }   
    }

        
}

