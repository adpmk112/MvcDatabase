package ace.project.persistance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestStudentDto {
	
	private int id;
	private String name, birth, gender, phone, education;
}
