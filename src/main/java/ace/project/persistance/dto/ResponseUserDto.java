package ace.project.persistance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserDto {
	private String userId;
	private String email;
	private String password;
}
