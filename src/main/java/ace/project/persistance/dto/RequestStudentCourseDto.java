package ace.project.persistance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestStudentCourseDto {
	private int studentId, courseId;
	private String studentName, birth, gender, phone, education, courseName;
}
