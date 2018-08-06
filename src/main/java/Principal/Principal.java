package Principal;

import java.util.List;

import DAOImplementacion.DAOImplementacionEstudiante;
import DAOInterface.DAOInterfaceEstudiante;
import POJOS.Estudiante;

public class Principal {
	
   public static void main(String[] args){
	   
	   DAOInterfaceEstudiante dao = new DAOImplementacionEstudiante();
	   
	   // Insert
	  /* dao.insertar("jonathan", "3012533108", "johnalexander_88@hotmail.com");
	   dao.insertar("andres", "4555", "andres.guerrero@hotmail.com");
	   dao.insertar("odila", "20367722", "odiliamo@hotmail.es");
	   dao.insertar("miguel", "19282414", "migazas3@hotmail.com");
	   dao.insertar("alejandro", "80725425", "kane914@hotmail.com");*/
	   
	   // Update
       //dao.actualizar(1, "pedro", "123456", "hk@hotmail.com");
       
       // Select
	  // Estudiante estudiante = dao.consultar(1);
	  // System.out.println("La consulta es: " + estudiante);
	   
	   // Delete
	  // dao.eliminar(1);
	   
	   List<String> listaCorreos = dao.consultaEscalarRetornarCorreos();
	   
	   for(String a : listaCorreos){
		   System.out.println("El correo es: " + a);
	   }
	   
	   List<String> listaNombres = dao.consultaEstudiantesNombresNamedQuiery();
	   
	   for(String a : listaNombres){
		   System.out.println("El nombre es: " + a);
	   }
	   
	   String nombrePorId = dao.consultaEstudiantePorNombreNamedQuery(4);
	   
	   System.out.println("El nombre del estudiante es : " + nombrePorId);
	   
	   // Cerrar Recursos
	   dao.close();

   }
}
