package ace.project.persistance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestStudentDto {
	
	private String studentId, name, birth, gender, phone, education;
}