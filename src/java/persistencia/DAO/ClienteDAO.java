
package persistencia.DAO;

import logica.Cliente;

public interface ClienteDAO extends GenericDAO <Cliente, Integer> {
    
    public abstract Cliente buscarClientePorDni(int dni);
    
}
