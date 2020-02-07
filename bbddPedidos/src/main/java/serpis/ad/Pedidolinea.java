package serpis.ad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.ForeignKey;

@Entity()
public class Pedidolinea implements List<Pedidolinea> {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "pedido")
	private Pedidos pedido;
	
	
	@ManyToOne
	@JoinColumn(name = "Articulo",
			foreignKey = @ForeignKey(name = "id"))
	private Articulo articulo;
	
	
	
	private double precio;
	
	
	private int unidades;
	
	private double importe;
	
	//////
	
	private Pedidolinea() {}
	
	public Pedidolinea(Pedidos pedido) {
		this.pedido = pedido;
		if(pedido.getPedidoLineas() == null)
			pedido.setPedidoLineas(new ArrayList<Pedidolinea>());
		pedido.getPedidoLineas().add(this);
		
}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pedidos getPedido() {
		return pedido;
	}
	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		
		this.articulo = articulo;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getImporte() {
		return importe;
	}
	
	public void setImporte(double importe) {
		
		this.importe =importe;
	}

	@Override
	public String toString() {
		return "Pedidolinea [id=" + id + ", importe=" + importe + "]";
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Pedidolinea> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Pedidolinea e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Pedidolinea> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Pedidolinea> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedidolinea get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedidolinea set(int index, Pedidolinea element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Pedidolinea element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedidolinea remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Pedidolinea> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Pedidolinea> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedidolinea> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
