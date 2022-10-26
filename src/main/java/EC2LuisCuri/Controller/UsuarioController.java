package EC2LuisCuri.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import EC2LuisCuri.DTO.UsuarioDTORequest;
import EC2LuisCuri.DTO.UsuarioDTOResponse;
import EC2LuisCuri.Security.JWTUtil;
import EC2LuisCuri.Security.UserDetailService;



@RestController
public class UsuarioController {
	
	@Autowired
	private JWTUtil util;
    
    @Autowired
    private UserDetailService service;

	@RequestMapping(path="/creartoken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request){
		
		
		UserDetails user = service.loadUserByUsername(request.getUsuario());
		
		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
		
	
	}

}
