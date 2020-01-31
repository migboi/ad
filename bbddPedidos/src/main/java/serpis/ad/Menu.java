package serpis.ad;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Menu {

	
	public static void main(String[] args) {
		
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("serpis.ad.bbddpedidos");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
			
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int opcion=-1;
		int sel1=-1;
		int sel2=-1;
		int sel3=-1;
		
		
		
		while(opcion!=0) {
			
			System.out.println("1-Articulos ");
			System.out.println("2-Categorias");
			System.out.println("3-Clientes");
			System.out.println("4-Pedidos");
			System.out.println("0-salir");
			
			  try
              {
                  opcion = sc.nextInt();
              }
              catch(Exception e){
                 System.out.println("Formato no valido");
                 break;
              }
			  
			  ////
			  switch (opcion) {
			case 0:
				System.out.println("Se cerro el programa");
				break;
				
			case 1:
				
				ArticuloDaw.articulo();
				break;
				
			case 2:
				
				
				categoriaDaw.cat();	
				 break;   
				  
				   
			case 3:
				
			    
			    ClienteDaw.clie();
			    break;

			case 4:
				pedidoDaw.pedido();
				break;
			default:
				break;
			}
			  
		}

	}
}



