package persistencia.DAO.JPA;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import logica.Cliente;
import persistencia.DAO.ClienteDAO;


public class ClienteDAOJPAImp extends GenericDAOJPAImp <Cliente, Integer> implements ClienteDAO{

    @Override
    public Cliente buscarClientePorDni(int dni) {
     
        EntityManager em = getEntityManager();
        
        //Cliente cliente = null;
        try {
            TypedQuery consulta = em.createQuery("SELECT c FROM cliente c JOIN persona p on c.idCliente = p.idPersona WHERE p.dni=:id", Cliente.class);
            consulta.setParameter("dni", dni);
            return (Cliente)consulta.getSingleResult();
        }
        finally {
            em.close();
        }   
    }
    
    
    
}
