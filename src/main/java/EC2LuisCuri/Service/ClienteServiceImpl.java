package EC2LuisCuri.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EC2LuisCuri.DTO.ClienteDTORequest;
import EC2LuisCuri.DTO.ClienteDTOResponse;
import EC2LuisCuri.Model.Cliente;
import EC2LuisCuri.Repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {

		Cliente c= new Cliente();
		
		c.setNombre(cliente.getNombrecli());
		c.setDni(cliente.getDnicli());
		c.setDireccion(cliente.getDircli());
		repository.save(c);
		
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		Cliente c= new Cliente();

		c.setNombre(cliente.getNombrecli());
		c.setDni(cliente.getDnicli());
		c.setDireccion(cliente.getDircli());
		c.setIdcliente(cliente.getIdcli());
		repository.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {

		List<ClienteDTOResponse> listar = new ArrayList<>();
		ClienteDTOResponse dto= null;
		List<Cliente> c= repository.findAll();
		
		for(Cliente cliente :c) {
			dto= new ClienteDTOResponse();
			
			dto.setIdcli(cliente.getIdcliente());
			dto.setNombrecli(cliente.getNombre());
			dto.setDnicli(cliente.getDni());
			dto.setDircli(cliente.getDireccion());
			
			listar.add(dto);
		}
		
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {

		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto= new ClienteDTOResponse();
		
		dto= new ClienteDTOResponse();
		dto.setIdcli(cliente.getIdcliente());
		dto.setNombrecli(cliente.getNombre());
		dto.setDnicli(cliente.getDni());
		dto.setDircli(cliente.getDireccion());	
		
		
		return dto;
	}
	

}
