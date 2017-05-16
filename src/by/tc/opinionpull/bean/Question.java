package by.tc.opinionpull.bean;

import java.util.List;

public class Question {

	Integer id;
	String title;
	Topic topic;
	List<Answer> answers;

	public Question () {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}

		if (this.getClass() != o.getClass()) {
			return false;
		}

		Question that = (Question) o;


		if (getId()==null) {
			if (that.getId() != null) {
				return false;
			}
		} else if (!getId().equals(that.getId())) {
			return false;
		}

		if (getTopic()==null) {
			if (that.getTopic() != null) {
				return false;
			}
		} else if (!getTopic().equals(that.getTopic())) {
			return false;
		}
		if (getTitle()==null) {
			if (that.getTitle() != null) {
				return false;
			}
		} else if (!getTitle().equals(that.getTitle())) {
			return false;
		}

		if (getAnswers()==null) {
			if (that.getAnswers() != null) {
				return false;
			}
		} else if (!getAnswers().equals(that.getAnswers())) {
			return false;
		}




		return true;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getTopic() != null ? getTopic().hashCode() : 0);
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + (getAnswers() != null ? getAnswers().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Question{" +
				"id=" + id +
				", topic='" + topic + '\'' +
				", title='" + title + '\'' +
				", answers=" + answers +
				'}';
	}
}
