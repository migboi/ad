package serpis.ad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="pedido")

public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "Cliente")
	
	private Cliente cliente;
	
	private double importe;

	@OneToMany(mappedBy = "pedido",orphanRemoval =true)
	private List<Pedidolinea> pedidoLineas = new ArrayList<Pedidolinea>();
	
	
	

	public List<Pedidolinea> getPedidoLineas() {
		return pedidoLineas;
	}


	public void setPedidoLineas(List<Pedidolinea> pedidoLineas) {
		this.pedidoLineas = pedidoLineas;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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



	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", pedidoLineas=" + pedidoLineas + "]";
	}
	
	
	
	
	
	

}
