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

import EC2LuisCuri.DTO.BodegaDTORequest;
import EC2LuisCuri.DTO.BodegaDTOResponse;
import EC2LuisCuri.Service.BodegaService;

@Controller
@RequestMapping("/bodega/v1")
public class BodegaController {
	
	@Autowired
	private BodegaService service;
	
	
	//LISTAR TODO
		@RequestMapping("/listar")
		public @ResponseBody ResponseEntity<List<BodegaDTOResponse>> listar(){
			
			return new ResponseEntity<List<BodegaDTOResponse>>(service.listarBodegas(),HttpStatus.OK);
		}
		
		
		//OBTENER POR ID:
		@GetMapping("/{id}")
		public @ResponseBody BodegaDTOResponse ObtenerItemId(@PathVariable Integer id) {
			return service.obtenerBodegaId(id);
		}
		
		//ELIMINAR:
		@RequestMapping(path="/eliminar/{id}",  method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminar(@PathVariable Integer id){
			BodegaDTOResponse bodega = service.obtenerBodegaId(id);
			if(bodega != null) {
				service.eliminarBodega(id);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//GUARDAR:
		@RequestMapping(path = "/guardar", method = RequestMethod.POST)
		public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bodega){
			service.guardarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		//ACTUALIZAR:
		@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
		public ResponseEntity<Void> actualizar(@RequestBody BodegaDTORequest bodega){
			
			BodegaDTOResponse bodegas= service.obtenerBodegaId(bodega.getIdbod());
			
			if(bodegas !=null) {
				service.actualizarBodega(bodega);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//LISTAR POR ID:
		
		@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
		public ResponseEntity<BodegaDTOResponse> obtenerId(@PathVariable Integer id){
			
			BodegaDTOResponse bodegas=service.obtenerBodegaId(id);
			
			if(bodegas!= null) {
				return new ResponseEntity<BodegaDTOResponse>(service.obtenerBodegaId(id), HttpStatus.OK);
			}
			return new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
		}



}
