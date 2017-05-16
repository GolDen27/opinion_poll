package by.tc.opinionpull.bean;

import java.util.List;

public class Poll {
	Integer id;
	String titlePoll;
	String description;
	Topic topic;
	List<Question> questions;


	public Poll(){}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitlePoll() {
		return titlePoll;
	}

	public void setTitlePoll(String titlePoll) {
		this.titlePoll = titlePoll;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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

		Poll that = (Poll) o;


		if (getId()==null) {
			if (that.getId() != null) {
				return false;
			}
		} else if (!getId().equals(that.getId())) {
			return false;
		}

		if (getTitlePoll()==null) {
			if (that.getTitlePoll() != null) {
				return false;
			}
		} else if (!getTitlePoll().equals(that.getTitlePoll())) {
			return false;
		}

		if (getDescription()==null) {
			if (that.getDescription() != null) {
				return false;
			}
		} else if (!getDescription().equals(that.getDescription())) {
			return false;
		}

		if (getTopic()==null) {
			if (that.getTopic() != null) {
				return false;
			}
		} else if (!getTopic().equals(that.getTopic())) {
			return false;
		}

		if (getTitlePoll()==null) {
			if (that.getTitlePoll() != null) {
				return false;
			}
		} else if (!getTitlePoll().equals(that.getTitlePoll())) {
			return false;
		}

		return true;

	}


	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getTitlePoll() != null ? getTitlePoll().hashCode() : 0);
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		result = 31 * result + (getTopic() != null ? getTopic().hashCode() : 0);
		result = 31 * result + (getQuestions() != null ? getQuestions().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Poll{" +
				"id=" + id +
				", titlePoll='" + titlePoll + '\'' +
				", description='" + description + '\'' +
				", topic='" + topic + '\'' +
				", questions=" + questions +
				'}';
	}
}
