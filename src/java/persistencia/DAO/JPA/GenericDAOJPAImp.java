package persistencia.DAO.JPA;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import persistencia.DAO.GenericDAO;

// Clase abstracta que implemeta los métodos del CRUD comunes a cada clase entidad.
public abstract class GenericDAOJPAImp <T, Id extends Serializable> implements GenericDAO <T, Id> {
    
    private Class <T> claseDePersistencia;
    private EntityManagerFactory emf = null;
    
    public GenericDAOJPAImp() {
        this.emf = Persistence.createEntityManagerFactory("TPAgenciaDeViajesPU");
        this.claseDePersistencia = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public T buscarPorId(int id) {
        
        EntityManager em = getEntityManager();
        
        T objeto = null;
        try {
            objeto = (T) em.find(claseDePersistencia, id);
            return objeto;
        }
        finally {
            em.close();
        }
}

    @Override
    public List<T> buscarTodos() {
               
        EntityManager em = getEntityManager();
        List<T> listaDeObjetos = null;
        try {
            TypedQuery<T> consulta = em.createQuery("SELECT o FROM " + claseDePersistencia.getSimpleName() + " o " + "WHERE o.habilitado=1", claseDePersistencia);
            listaDeObjetos = consulta.getResultList();
            return listaDeObjetos;
        }
        finally {
            em.close();
        }
   
    }

    @Override
    public void editar(T objeto) {
        
        EntityManager em = getEntityManager();
        
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(objeto);
            transaction.commit();
        }
        catch (PersistenceException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            em.close();
        }
    }
        

    @Override
    public void eliminar(T objeto) {
       
        EntityManager em = getEntityManager();
        
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(objeto);
            transaction.commit();
        }
        catch (PersistenceException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            em.close();
        }
        
    }
    
    public void insertar(T objeto) {
        
        EntityManager em = getEntityManager();
        
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(objeto);
            transaction.commit();
        }
        catch (PersistenceException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            em.close();
        }
    }
    
    
    
    
}
