package com.goapps.midday.valueobject.meal;

import java.util.List;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TakeStudentAttendanceVO {

	@NotNull
	private Long mealId;
	
	private Long schoolId;
	
	private List<StudentAttendance> studentAttendanceList;

	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public List<StudentAttendance> getStudentAttendanceList() {
		return studentAttendanceList;
	}

	public void setStudentAttendanceList(List<StudentAttendance> studentAttendanceList) {
		this.studentAttendanceList = studentAttendanceList;
	}
	

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}


	@NoArgsConstructor
	@AllArgsConstructor
	public static class StudentAttendance {
		private Long studentId;
		private Boolean present;
		private Boolean bookMeal;
		private Boolean confirmMeal;
		private String noMealCause;

		public Long getStudentId() {
			return studentId;
		}

		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		public Boolean getPresent() {
			return present;
		}

		public void setPresent(Boolean present) {
			this.present = present;
		}

		public Boolean getBookMeal() {
			return bookMeal;
		}

		public void setBookMeal(Boolean bookMeal) {
			this.bookMeal = bookMeal;
		}

		public Boolean getConfirmMeal() {
			return confirmMeal;
		}

		public void setConfirmMeal(Boolean confirmMeal) {
			this.confirmMeal = confirmMeal;
		}

		public String getNoMealCause() {
			return noMealCause;
		}

		public void setNoMealCause(String noMealCause) {
			this.noMealCause = noMealCause;
		}

	}

}
