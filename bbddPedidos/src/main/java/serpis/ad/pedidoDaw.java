package serpis.ad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class pedidoDaw {
	
	
	
	public static void insertarPedido(){
		
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("serpis.ad.bbddpedidos");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		
		Pedidos pedido=new Pedidos();
		
		pedido.setFecha(LocalDateTime.now());
		
	
		pedido.setCliente(buscarCliente());
		
		System.out.println("Intoruce el precio del pedido");
		double precio=sc.nextDouble();
		pedido.setImporte(precio);
	
		 entityManager.persist(pedido);
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 entityManagerFactory.close();
		
	}
	
	
	private static Cliente buscarCliente() {
		
		Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce id de la cliente a buscar");
			
			int id=Integer.parseInt(sc.nextLine());
			
			  EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
			  ArrayList<Cliente> clientes =  (ArrayList<Cliente>) entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
			  entityManager.close();
			 String mensaje = null;
			 Cliente cliente = new Cliente();
			 
			for (Cliente clienteA : clientes)
				if (clienteA.getId() == id) {
					cliente=clienteA;
					
				}
			
			return cliente;
	}
	
	
	
	public static void pedido() {
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		while(opcion==-1) {
			
		    
			System.out.println("1-Insertar pedido");
			System.out.println("2-Eliminar eliminar pedido");
			System.out.println("3-Listar todos pedido");
			System.out.println("4-buscar pedido");
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
					 
					 pedidoDaw.insertarPedido();
					
					break;
					
				 case 2:
			
					 
					 break;
					 
				 case 3:
					 
					 break; 

				 case 4:
					
					 break;
				 case 5:
					 
					 break;
				default:
					break;
				}
	  
		}
		
		
		
	}

}
