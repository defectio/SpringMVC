package sec05_redirect;

import java.util.List;

public interface MemDAO {  

	public List<MemDTO> list();
	
	public void insertMethod(MemDTO dto);

}