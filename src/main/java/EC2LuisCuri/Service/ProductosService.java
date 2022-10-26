package EC2LuisCuri.Service;

import java.util.List;

import EC2LuisCuri.DTO.ProductoDTORequest;
import EC2LuisCuri.DTO.ProductoDTOResponse;



public interface ProductosService {
	
	void guardarProducto(ProductoDTORequest producto);
	void actualizarProducto(ProductoDTORequest producto);
	void eliminarProducto(Integer id);
	List<ProductoDTOResponse> listarProductos();
	ProductoDTOResponse obtenerProductoId(Integer id);

}
