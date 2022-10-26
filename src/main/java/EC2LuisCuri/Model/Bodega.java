package EC2LuisCuri.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bodega")
public class Bodega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idbodega;
	private String nombre;
	private String direccion;
	
	@ManyToOne
	@JoinColumn(
			name="idproducto",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idproducto) references Producto(idproducto)")
			)
	
	private Productos producto;
	
	
	
	public Integer getIdbodega() {
		return idbodega;
	}
	public void setIdbodega(Integer idbodega) {
		this.idbodega = idbodega;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
