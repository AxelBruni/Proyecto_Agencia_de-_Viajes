package persistencia;

import java.util.ArrayList;
import java.util.List;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.TipoPago;
import logica.Usuario;
import logica.Venta;
import persistencia.DAO.ClienteDAO;
import persistencia.DAO.EmpleadoDAO;
import persistencia.DAO.JPA.ClienteDAOJPAImp;
import persistencia.DAO.JPA.EmpleadoDAOJPAImp;
import persistencia.DAO.JPA.PaqueteTuristicoDAOJPAImp;
import persistencia.DAO.JPA.ServicioTuristicoDAOJPAImp;
import persistencia.DAO.JPA.TipoPagoDAOJPAImp;
import persistencia.DAO.JPA.UsuarioDAOJPAImp;
import persistencia.DAO.JPA.VentaDAOJPAImp;
import persistencia.DAO.PaqueteTuristicoDAO;
import persistencia.DAO.ServicioTuristicoDAO;
import persistencia.DAO.TipoPagoDAO;
import persistencia.DAO.UsuarioDAO;
import persistencia.DAO.VentaDAO;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author axelb
 */
public class ControladoraPersistencia {
      
    private ClienteDAO clienteJPA = new ClienteDAOJPAImp();
    private EmpleadoDAO empleadoJPA = new EmpleadoDAOJPAImp();
    private PaqueteTuristicoDAO paqueteJPA = new PaqueteTuristicoDAOJPAImp();
    //private PersonaJpaController personaJPA = new PersonaJpaController();
    private ServicioTuristicoDAO servicioJPA = new ServicioTuristicoDAOJPAImp();
    private UsuarioDAO usuarioJPA = new UsuarioDAOJPAImp();
    private VentaDAO ventaJPA = new VentaDAOJPAImp();
    private TipoPagoDAO tipoPagoJPA = new TipoPagoDAOJPAImp();
    
    public ControladoraPersistencia() {     
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Clientes">
    public void crearCliente(Cliente cliente) {       
        clienteJPA.insertar(cliente);
    }

    public void borrarCliente(Cliente cliente) throws NonexistentEntityException{    
        clienteJPA.eliminar(cliente);
    }
    
    public void actualizarCliente(Cliente cliente) throws Exception{
        clienteJPA.editar(cliente);
    }
            
    public List<Cliente> mostrarClientes(){
        return clienteJPA.buscarTodos();
    }
    
    public Cliente buscarCliente(int id) {
        return clienteJPA.buscarPorId(id);
    }
    
    public Cliente buscarClientePorDni(int dni){
        return clienteJPA.buscarClientePorDni(dni);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Empleados">
    public void crearEmpleado(Empleado empleado){
        empleadoJPA.insertar(empleado);
    }        
    public void borrarEmpleado(Empleado empleado) throws NonexistentEntityException{
        empleadoJPA.eliminar(empleado);
    }        
    public void actualizarEmpleado(Empleado empleado) throws Exception{
        empleadoJPA.editar(empleado);
    }        
    public List<Empleado> mostrarEmpleados(){
        return empleadoJPA.buscarTodos();        
    }
    
    public Empleado buscarEmpleado(int idEmp) {
        return empleadoJPA.buscarPorId(idEmp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Paquetes Turísticos">
    public void crearPaqueteTuristico(PaqueteTuristico paquete){
        paqueteJPA.insertar(paquete);
    }
    public void borrarPaqueteTuristico(PaqueteTuristico paquete) throws NonexistentEntityException{
        paqueteJPA.eliminar(paquete);
    }        
    public void actualizarPaqueteTuristico(PaqueteTuristico paquete) throws Exception{
        paqueteJPA.editar(paquete);
    }
    public List<PaqueteTuristico> mostrarPaquetesTuristicos(){
        return paqueteJPA.buscarTodos();
    }
    
    public PaqueteTuristico buscarPaquete(int codPaq) {
        return paqueteJPA.buscarPorId(codPaq);
    }
    // </editor-fold>
       
    // <editor-fold defaultstate="collapsed" desc="CRUD Servicios Turísticos ">

    public void crearServicioTuristico(ServicioTuristico servicio) {
        servicioJPA.insertar(servicio);
    }
    public void borrarServicioTuristico(ServicioTuristico servicio) throws NonexistentEntityException {
        servicioJPA.eliminar(servicio);
    }        
    public void actualizarServicioTuristico(ServicioTuristico servicio) throws Exception {
        servicioJPA.editar(servicio);
    }

    public List<ServicioTuristico> mostrarServiciosTuristicos() {
        return servicioJPA.buscarTodos();
    }
 
    public ServicioTuristico buscarServicio(int cod) {
        return servicioJPA.buscarPorId(cod);
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Usuarios ">
    public void crearUsuario(Usuario usuario) {
        usuarioJPA.insertar(usuario);
    }
    public void borrarUsuario(Usuario usuario) throws NonexistentEntityException {
        usuarioJPA.eliminar(usuario);
    }        
    public void actualizarUsuario(Usuario usuario) throws Exception {
        usuarioJPA.editar(usuario);
    }
    public List<Usuario> mostrarUsuarios() {
        return usuarioJPA.buscarTodos();
    }
    
    public Usuario buscarUsuario(int id) {
        return usuarioJPA.buscarPorId(id);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Ventas ">
    public void crearVenta(Venta venta) {
        ventaJPA.insertar(venta);
    }
    public void borrarVenta(Venta venta) throws NonexistentEntityException {
        ventaJPA.eliminar(venta);
    }        
    public void actualizarVenta(Venta venta) throws Exception {
        ventaJPA.editar(venta);
    }
    public List<Venta> mostrarVentas() {
        return ventaJPA.buscarTodos();
    }
    
    public Venta buscarVenta(int id) {
        return ventaJPA.buscarPorId(id);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Tipos de Pago ">
    public void crearTipoPago(TipoPago tipoPago) {
        tipoPagoJPA.insertar(tipoPago);
    }
    public void borrarTipoPago(TipoPago tipoPago) throws NonexistentEntityException {
        tipoPagoJPA.eliminar(tipoPago);
    }        
    public void actualizarTipoPago(TipoPago tipoPago) throws Exception {
        tipoPagoJPA.editar(tipoPago);
    }
    public List<TipoPago> mostrarTipoPagos() {
        return tipoPagoJPA.buscarTodos();
    }
    
    public TipoPago buscarTipoPago(int id){
        return tipoPagoJPA.buscarPorId(id);
    }
    // </editor-fold>


    
}
