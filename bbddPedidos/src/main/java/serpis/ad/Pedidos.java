package serpis.ad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name="Pedido")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "Cliente")
	
	private Cliente cliente;
	
	
	
	private double importe;
	
	
	private ArrayList<Pedidolinea> pedidoLineas = new ArrayList<Pedidolinea>();
	
	

	public ArrayList<Pedidolinea> getPedidoLineas() {
		return pedidoLineas;
	}

	public void setPedidoLineas(ArrayList<Pedidolinea> pedidoLineas) {
		this.pedidoLineas = pedidoLineas;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	
	
	
	

}
