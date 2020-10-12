package kr.or.ddit.job.model;

public class JobVo {

	private String job_id;
	private String job_title;
	private String min_salary;
	private String max_salary;
	private String create_date;
	private String update_date;

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(String min_salary) {
		this.min_salary = min_salary;
	}

	public String getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(String max_salary) {
		this.max_salary = max_salary;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "JobVo [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((job_id == null) ? 0 : job_id.hashCode());
		result = prime * result + ((job_title == null) ? 0 : job_title.hashCode());
		result = prime * result + ((max_salary == null) ? 0 : max_salary.hashCode());
		result = prime * result + ((min_salary == null) ? 0 : min_salary.hashCode());
		result = prime * result + ((update_date == null) ? 0 : update_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobVo other = (JobVo) obj;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (job_id == null) {
			if (other.job_id != null)
				return false;
		} else if (!job_id.equals(other.job_id))
			return false;
		if (job_title == null) {
			if (other.job_title != null)
				return false;
		} else if (!job_title.equals(other.job_title))
			return false;
		if (max_salary == null) {
			if (other.max_salary != null)
				return false;
		} else if (!max_salary.equals(other.max_salary))
			return false;
		if (min_salary == null) {
			if (other.min_salary != null)
				return false;
		} else if (!min_salary.equals(other.min_salary))
			return false;
		if (update_date == null) {
			if (other.update_date != null)
				return false;
		} else if (!update_date.equals(other.update_date))
			return false;
		return true;
	}

}
