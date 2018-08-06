package DAOImplementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DAOInterface.DAOInterfaceEstudiante;
import POJOS.Estudiante;

public class DAOImplementacionEstudiante implements DAOInterfaceEstudiante{
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public DAOImplementacionEstudiante(){
		
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJPAEjercicio");
		
	}

	public Estudiante consultar(int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Estudiante estudiante = entityManager.find(Estudiante.class, id);
		entityManager.close();
		
		return estudiante;
	}

	public Estudiante actualizar(int id, String nombre, String telefono, String correo) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Estudiante estudiante = entityManager.find(Estudiante.class, id);
		System.out.println("Antes de actualizar --- " + estudiante);
		estudiante.setNombre(nombre);
		estudiante.setTelefono(telefono);
		estudiante.setCorreo(correo);
		entityManager.getTransaction().commit();
		System.out.println("despues de actualizar ----- " + estudiante);
		entityManager.close();
		
		return estudiante;
	}

	public boolean eliminar(int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Estudiante estudiante = entityManager.find(Estudiante.class, id);
		entityManager.remove(estudiante);
		entityManager.getTransaction().commit();
		
		System.out.println("Se elimino la entidad ----" + estudiante);
		entityManager.close();
		
		return true;
	}

	public Estudiante insertar(String nombre, String telefono, String correo) {

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre(nombre);
		estudiante.setTelefono(telefono);
		estudiante.setCorreo(correo);
		
		entityManager.persist(estudiante);
		entityManager.getTransaction().commit();
		entityManager.close();

		return estudiante;
	}

	public void close() {
		
		entityManagerFactory.close();
		
	}

	public List<String> consultaEscalarRetornarCorreos() {
		// TODO Auto-generated method stub
		entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT e.correo FROM Estudiante e");
		List<String> listaCorreos = (List<String>)query.getResultList();
		
		return listaCorreos;
	}

	public String consultaEstudiantePorNombreNamedQuery(int id) {
		
		entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("retornarNombresEstudiantesPorId");
		query.setParameter("id", id);
		
		String salida = (String) query.getSingleResult();
		return salida;
	}

	public List<String> consultaEstudiantesNombresNamedQuiery() {
		// TODO Auto-generated method stub
		entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("retornarNombresEstudiantes");
		
		List<String> listaNombres = (List<String>) query.getResultList();
		
		return listaNombres;
	}

}
