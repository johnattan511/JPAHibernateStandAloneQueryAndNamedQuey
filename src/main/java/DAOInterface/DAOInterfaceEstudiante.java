package DAOInterface;

import java.util.List;

import POJOS.Estudiante;

public interface DAOInterfaceEstudiante {
	
    public Estudiante consultar(int id);
    
    public Estudiante actualizar(int id, String nombre, String telefono, String correo);
    
    public boolean eliminar(int id);
    
    public Estudiante insertar(String nombre, String telefono, String correo);
    
    public void close();
    
    public List<String> consultaEscalarRetornarCorreos();
    
    public String consultaEstudiantePorNombreNamedQuery(int id);
    
    public List<String> consultaEstudiantesNombresNamedQuiery();
    
}
