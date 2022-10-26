package EC2LuisCuri.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import EC2LuisCuri.DTO.ProductoDTORequest;
import EC2LuisCuri.DTO.ProductoDTOResponse;
import EC2LuisCuri.Service.ProductosService;



@Controller
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	private ProductosService service;
	
	
	//LISTAR TODO
		@RequestMapping("/listar")
		public @ResponseBody ResponseEntity <List<ProductoDTOResponse>> listar() {
			
			
			return new ResponseEntity<List<ProductoDTOResponse>>( service.listarProductos(), HttpStatus.OK);
		}
		
		//OBTENER POR ID:
		@GetMapping("/{id}")
		public  @ResponseBody ProductoDTOResponse ObtenerProductoId(@PathVariable Integer id) {
			return service.obtenerProductoId(id);
		}
		
		
		//ELIMINAR
		@DeleteMapping("/{id}")
		public void EliminarProducto(@PathVariable Integer id) {
			service.eliminarProducto(id);
		}
		
		
		//GUARDAR
		@RequestMapping(path = "/guardar", method = RequestMethod.POST)
		public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest productos) {
			service.guardarProducto(productos);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		
		//ELIMINAR
		@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
			
			ProductoDTOResponse producto=service.obtenerProductoId(id);
			
			if(producto != null) {
				service.eliminarProducto(id);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//ACTUALIZAR
		@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
		public ResponseEntity<Void> actualizar(@RequestBody ProductoDTORequest productos) {
			
			ProductoDTOResponse producto=service.obtenerProductoId(productos.getIdprod());
			
			if(producto != null) {
				service.actualizarProducto(productos);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		//LISTAR POR ID
		@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
		public ResponseEntity<ProductoDTOResponse> obtenerId(@PathVariable Integer id) {
			
			ProductoDTOResponse p=service.obtenerProductoId(id);
			
			if(p != null) {			
				
				return new ResponseEntity<ProductoDTOResponse>(service.obtenerProductoId(id), HttpStatus.OK);
			}
			return new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
		}

}
