package ace.project.persistance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseStudentDto {
	
	private String name, birth, gender, phone, education;
	private int id;
}
