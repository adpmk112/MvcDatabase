package ace.project.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String userid;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String password;

}
