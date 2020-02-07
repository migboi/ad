package serpis.ad;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArticuloDaw {

	
	public static void insertararArticulo(){
		
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("serpis.ad.bbddpedidos");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Articulo articulo=new Articulo();
		System.out.println("Introduce el nombre del articulo");
		String name=sc.nextLine();
	
		articulo.setNombre(name);
		
		System.out.println("Introduce el precio del articulo");
		double precio=sc.nextDouble();
		articulo.setPrecio(precio);
	
		System.out.println("Introduce la categoria del  articulo");
		int cat=sc.nextInt();
		articulo.setCategoria(cat);
	
		 entityManager.persist(articulo);
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 entityManagerFactory.close();
	
	
		
	}
	
	 public static void showAll() {
		 
		   EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
		   ArrayList<Articulo> articulos =  (ArrayList<Articulo>) entityManager.createQuery("from Articulo order by id", Articulo.class).getResultList();
		    entityManager.close();
	    	
	    	for (Articulo articulo : articulos)
	    		System.out.printf("%3d %s \n" , articulo.getId(),articulo.getNombre(),articulo.getPrecio(),articulo.getCategoria());    	
	    }
	
 private static void buscar() {
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce id de la articulo a buscar");
			
			int id=Integer.parseInt(sc.nextLine());
			
			  EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
			  ArrayList<Articulo> articulos =  (ArrayList<Articulo>) entityManager.createQuery("from Articulo order by id", Articulo.class).getResultList();
			  entityManager.close();
			String mensaje = null;
			
			for (Articulo articulo : articulos)
				if (articulo.getId() == id) {
					mensaje="Nombre: "+articulo.getNombre()+",Id: "+articulo.getId()+",precio: "+articulo.getPrecio()+", categoria:"+articulo.getCategoria();
					
				}
			
			System.out.println(mensaje);
		}
 

 
 private static void eliminar() {
	 
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Introduce id del articulo a eliminar");
		
		int id=Integer.parseInt(sc.nextLine());
		
		   EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
		   ArrayList<Articulo> articulos =  (ArrayList<Articulo>) entityManager.createQuery("from Articulo order by id", Articulo.class).getResultList();
			entityManager.getTransaction().begin();
			
		String mensaje = null;
		
		for (Articulo articulo : articulos)
			
			if (articulo.getId() == id) {
				
		    	entityManager.remove(articulo);
		    	entityManager.getTransaction().commit();
		    	entityManager.close();
				System.out.println("articulo eliminado");
				break;
			}
		//System.out.println("No se puedo eliminar el pedido");
	}
 
 

	 

 
	public static void articulo() {
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		while(opcion==-1) {
			
			System.out.println("1-Insertar Ariculos");
			System.out.println("2-Eliminar Articulos");
			System.out.println("3-Listar Articulos");
			System.out.println("4-Buscar Articulo");
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
				 ArticuloDaw.insertararArticulo();
				 
				
				break;
				
			
			 case 2:
				 eliminar();
				 break;
				 
			 case 3:
				 ArticuloDaw.showAll();
				 break;
				 
			 case 4:
				 ArticuloDaw.buscar();
				 break;
				 
			 case 5:
				 break;

			default:
				break;
			}
		  
		}
	}
}
