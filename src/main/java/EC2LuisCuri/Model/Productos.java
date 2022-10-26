package EC2LuisCuri.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Productos")
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproducto;
	private String producto;
	private String descripcion;
	private String precio;
	private Integer stock;
	
	
	@OneToMany(mappedBy="producto")
	private List<Bodega> bodega = new ArrayList<>();
	
	
	@ManyToMany(cascade = {CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(
			name="productos_clientes",
			
			joinColumns = @JoinColumn(
					name="idcliente", nullable = false, unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreing key (idcliente) references Clientes(idcliente)")
			),
			
			inverseJoinColumns = @JoinColumn(
					name="idproducto", nullable = false, unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references Productos(id_producto)")
			)
			
						
	)	
	
	private List<Cliente> cliente = new ArrayList<>();
	
	
	public Integer getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	

}
