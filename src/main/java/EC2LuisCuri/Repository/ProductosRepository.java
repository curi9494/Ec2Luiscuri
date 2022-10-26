package EC2LuisCuri.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC2LuisCuri.Model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}
