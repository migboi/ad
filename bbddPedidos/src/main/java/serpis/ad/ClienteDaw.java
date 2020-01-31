package serpis.ad;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.Main;

import antlr.collections.List;

public class ClienteDaw {
	
	
	public static void insertarcliente(){
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("serpis.ad.bbddpedidos");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Cliente cliente=new Cliente();
		System.out.println("Introduce el nombre del cliente");
		String name=sc.next();
	
		cliente.setNombre(name);
	
		 entityManager.persist(cliente);
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 entityManagerFactory.close();
		
	}
	
	 public static void showAll() {
		 
		   EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
		   ArrayList<Cliente> clientes =  (ArrayList<Cliente>) entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
		    entityManager.close();
	    	
	    	for (Cliente cliente : clientes)
	    		System.out.printf("%3d %s \n" , cliente.getId(), cliente.getNombre());    	
	    }
	 
	 
	 private static void buscar() {
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce id de la cliente a buscar");
			
			int id=Integer.parseInt(sc.nextLine());
			
			  EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
			  ArrayList<Cliente> clientes =  (ArrayList<Cliente>) entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
			  entityManager.close();
			String mensaje = null;
			
			for (Cliente cliente : clientes)
				if (cliente.getId() == id) {
					mensaje="Nombre: "+cliente.getNombre()+",Id: "+cliente.getId();
					
				}
			
			System.out.println(mensaje);
		}
	 

		/*private static ArrayList<Cliente> getAll() {
			
		    EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
		    ArrayList<Cliente> clientes =  (ArrayList<Cliente>) entityManager.createQuery("from Cliente order by id", 
		     		Cliente.class).getResultList();
		    entityManager.close();
		    return (ArrayList<Cliente>) clientes; 
		 }*/

	public static void clie() {
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		while(opcion==-1) {
			
		    
			System.out.println("1-Insertar cliente");
			System.out.println("2-Eliminar cliente");
			System.out.println("3-Listar todos clientes");
			System.out.println("4-buscar cliente");
		    System.out.println("5-Salir");
		    
			try
			{
	    	  opcion=sc.nextInt();
			}
			catch(Exception e){
				System.out.println("Formato no valido");
				break;
			}
			
			  switch (opcion) {
			    
				 case 1:
					 
					 ClienteDaw.insertarcliente();
					
					break;
					
				 case 2:
			
					 
					 break;
					 
				 case 3:
					 ClienteDaw.showAll();
					 break; 

				 case 4:
					 ClienteDaw.buscar();
					 break;
				 case 5:
					 
					 break;
				default:
					break;
				}
	  
		}
		
		
		
	}
	
	
	

}


