package EC2LuisCuri.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import EC2LuisCuri.DTO.ClienteDTORequest;
import EC2LuisCuri.DTO.ClienteDTOResponse;
import EC2LuisCuri.Service.ClienteService;

@Controller
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	//LISTAR TODO
		@RequestMapping("/listar")
		public @ResponseBody ResponseEntity<List<ClienteDTOResponse>> listar(){
			
			return new ResponseEntity<List<ClienteDTOResponse>>(service.listarClientes(),HttpStatus.OK);
		}
		
		
		//OBTENER POR ID:
		@GetMapping("/{id}")
		public @ResponseBody ClienteDTOResponse ObtenerItemId(@PathVariable Integer id) {
			return service.obtenerClienteId(id);
		}
		
		//ELIMINAR:
		@RequestMapping(path="/eliminar/{id}",  method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminar(@PathVariable Integer id){
			ClienteDTOResponse cliente = service.obtenerClienteId(id);
			if(cliente != null) {
				service.eliminarCliente(id);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//GUARDAR:
		@RequestMapping(path = "/guardar", method = RequestMethod.POST)
		public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cliente){
			service.guardarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		//ACTUALIZAR:
		@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
		public ResponseEntity<Void> actualizar(@RequestBody ClienteDTORequest cliente){
			
			ClienteDTOResponse clientes= service.obtenerClienteId(cliente.getIdcli());
			
			if(clientes !=null) {
				service.actualizarCliente(cliente);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//LISTAR POR ID:
		
		@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
		public ResponseEntity<ClienteDTOResponse> obtenerId(@PathVariable Integer id){
			
			ClienteDTOResponse clientes=service.obtenerClienteId(id);
			
			if(clientes!= null) {
				return new ResponseEntity<ClienteDTOResponse>(service.obtenerClienteId(id), HttpStatus.OK);
			}
			return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
		}



}
