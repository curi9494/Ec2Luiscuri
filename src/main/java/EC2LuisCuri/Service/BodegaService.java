package EC2LuisCuri.Service;

import java.util.List;

import EC2LuisCuri.DTO.BodegaDTORequest;
import EC2LuisCuri.DTO.BodegaDTOResponse;

public interface BodegaService {
	
	void guardarBodega(BodegaDTORequest bodega);
	void actualizarBodega(BodegaDTORequest bodega);
	void eliminarBodega(Integer id);
	List<BodegaDTOResponse> listarBodegas();
	BodegaDTOResponse obtenerBodegaId(Integer id); 

}
