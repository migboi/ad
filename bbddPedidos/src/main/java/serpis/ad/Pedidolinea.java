package serpis.ad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.ForeignKey;

@Entity(name="Pedidolinea")
public class Pedidolinea {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "Pedidos",
			foreignKey = @ForeignKey(name = "id"))
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
		precio = articulo.getPrecio();
		unidades = unidades;
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
		
		this.importe =unidades*precio;
	}
	
	
	
}
