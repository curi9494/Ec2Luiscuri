package EC2LuisCuri.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EC2LuisCuri.DTO.BodegaDTORequest;
import EC2LuisCuri.DTO.BodegaDTOResponse;
import EC2LuisCuri.Model.Bodega;
import EC2LuisCuri.Repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository repository;
	
	
	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		Bodega b= new Bodega();
		
		b.setNombre(bodega.getNombrebod());
		b.setDireccion(bodega.getDirbod());
		repository.save(b);
		
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodega) {
Bodega b= new Bodega();
		
		b.setNombre(bodega.getNombrebod());
		b.setDireccion(bodega.getDirbod());
		b.setIdbodega(bodega.getIdbod());
		repository.saveAndFlush(b);
		
	}

	@Override
	public void eliminarBodega(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<BodegaDTOResponse> listarBodegas() {

		List<BodegaDTOResponse>listar = new ArrayList<>();
		BodegaDTOResponse dto = null;
		List<Bodega> b= repository.findAll();
		
		for(Bodega bodega : b) {
			
			dto= new BodegaDTOResponse();
			
			dto.setIdbod(bodega.getIdbodega());
			dto.setNombrebod(bodega.getNombre());
			dto.setDirbod(bodega.getDireccion());
			
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {

		Bodega bodega = repository.findById(id).orElse(null);
		BodegaDTOResponse dto= new BodegaDTOResponse();
		
		dto = new BodegaDTOResponse();
		
		dto.setIdbod(bodega.getIdbodega());
		dto.setNombrebod(bodega.getNombre());
		dto.setDirbod(bodega.getDireccion());	
		
		
		return dto;
	}

}
