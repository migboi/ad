package serpis.ad;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class categoriaDaw {
	
	
	public static void insertarCategoria(){
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("serpis.ad.bbddpedidos");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria=new Categoria();
		System.out.println("Introduce el nombre de la categoria");
		
		String name=sc.next();
		categoria.setNombre(name);
	
		 entityManager.persist(categoria);
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 entityManagerFactory.close();
		
	}
	
	 public static void showAll() {
		 
		   EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
		   ArrayList<Categoria> categorias =  (ArrayList<Categoria>) entityManager.createQuery("from Categoria order by id", Categoria.class).getResultList();
		    entityManager.close();
	    	
	    	for (Categoria categoria : categorias)
	    		System.out.printf("%3d %s \n" ,categoria.getId(),categoria.getNombre());    	
	    }
	
	
 private static void buscar() {
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce id de la categoria a buscar");
			
			int id=Integer.parseInt(sc.nextLine());
			
			  EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
			  ArrayList<Categoria> categorias =  (ArrayList<Categoria>) entityManager.createQuery("from Categoria order by id", Categoria.class).getResultList();
			  entityManager.close();
			String mensaje = null;
			
			for (Categoria categoria : categorias)
				if (categoria.getId() == id) {
					mensaje="Nombre: "+categoria.getNombre()+",Id: "+categoria.getId();
					
				}
			
			System.out.println(mensaje);
		}
 
	public static void cat() {
		Scanner sc = new Scanner(System.in);
		
		int opcion=-1;
		while(opcion==-1) {
			
			System.out.println("1-Insertar categoria");
			System.out.println("2-Eliminar categoria");
			System.out.println("3-Listar categoria");
			System.out.println("4-Buscar categoria");
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
				categoriaDaw.insertarCategoria();
				 
				
				break;
				
			
			 case 2:
				 break;
				 
			 case 3:
				 categoriaDaw.showAll();
				 break;
				 
			 case 4:
				 categoriaDaw.buscar();
				 break;
				 
			 case 5:
				
				 break;

			default:
				break;
			}
		  
		}
	}

}
