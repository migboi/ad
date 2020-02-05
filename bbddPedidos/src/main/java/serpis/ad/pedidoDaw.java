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
		Pedidolinea pedidolinea=new Pedidolinea(pedido);
		pedido.setCliente(buscarCliente());
		pedido.setFecha(LocalDateTime.now());
		
		
		
		Articulo articulo1 =pedidoDaw.buscarAr();
		System.out.println(articulo1.getNombre());
		pedidolinea.setArticulo(articulo1);
		
		System.out.println("Introduce el numero de unidades");
		int uni=sc.nextInt();
		pedidolinea.setUnidades(uni);
		pedidolinea.setPrecio(articulo1.getPrecio());
		//System.out.println(line.getPrecio());
		pedidolinea.setImporte(pedidolinea.getPrecio()*pedidolinea.getUnidades());
		System.out.println(pedidolinea.getImporte());
		
		
		
		pedido.setImporte(pedidolinea.getImporte());
		//pedido.setPedidoLineas());
		System.out.println("*******************************************");
		
		//pedido.setPedidoLineas(pedidolinea);
	
		System.out.println(pedido);
		//entityManager.persist(pedidolinea);
		 entityManager.persist(pedido);
		
	
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 entityManagerFactory.close();
		
	}
	
	 private static  Articulo buscarAr() {
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce id de la articulo a buscar");
			
			int id=Integer.parseInt(sc.nextLine());
			
			  EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
			  ArrayList<Articulo> articulos =  (ArrayList<Articulo>) entityManager.createQuery("from Articulo order by id", Articulo.class).getResultList();
			  entityManager.close();
			String mensaje = null;
			Articulo articulo1=new Articulo();
			
			for (Articulo articulo : articulos)
				if (articulo.getId() == id) {
					articulo1=articulo;
					
				}
			return articulo1;
			
		}
	
	private static Object Integer(int ar) {
		// TODO Auto-generated method stub
		return null;
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
			System.out.println(cliente.getNombre());
			return cliente;
	}
	
	
	 public static void showAll() {
		 
		   EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
		   ArrayList<Pedidos> pedidos =  (ArrayList<Pedidos>) entityManager.createQuery("from Pedidos order by id", Pedidos.class).getResultList();
		   String mensaje = null;
	  	for (Pedidos pedido : pedidos) {
	  		mensaje="Nombre: "+pedido.getCliente().getNombre()+",Id: "+pedido.getId()+",Importe: "+pedido.getImporte()+", fecha: "+pedido.getFecha();
	  		System.out.println(mensaje);
	  	}
	  	entityManager.close();	
	  
	  }
	 
	 
 private static void buscar() {
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduce id del pedido a buscar");
			
			int id=Integer.parseInt(sc.nextLine());
			
			   EntityManager entityManager = ContainerEntitityManager.entityManagerFactory.createEntityManager();
			   ArrayList<Pedidos> pedidos =  (ArrayList<Pedidos>) entityManager.createQuery("from Pedidos order by id", Pedidos.class).getResultList();
			  entityManager.close();
			String mensaje = null;
			
			for (Pedidos pedido : pedidos)
				if (pedido.getId() == id) {
					mensaje="Nombre: "+pedido.getCliente().getNombre()+",Id: "+pedido.getId()+",Importe: "+pedido.getImporte()+",Fecha: "+pedido.getFecha();
					
				}
			
			System.out.println(mensaje);
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
					 showAll();
					 break; 

				 case 4:
					buscar();
					 break;
				 case 5:
					 
					 break;
				default:
					break;
				}
	  
		}
		
		
		
	}

}
