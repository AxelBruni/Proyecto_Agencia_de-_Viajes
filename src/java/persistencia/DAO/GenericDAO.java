package persistencia.DAO;

import java.io.Serializable;
import java.util.List;


// Interfase que indica los métodos relativos al CRUD de las clases entidad.
public interface GenericDAO <T, Id extends Serializable> {
    
    T buscarPorId(int id);
    List<T> buscarTodos();
    void editar(T objeto);
    void eliminar(T objeto);
    void insertar(T objeto);
    
    
}
