package EC2LuisCuri.Service;

import java.util.List;

import EC2LuisCuri.DTO.ClienteDTORequest;
import EC2LuisCuri.DTO.ClienteDTOResponse;



public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id); 

}
