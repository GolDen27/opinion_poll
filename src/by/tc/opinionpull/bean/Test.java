package by.tc.opinionpull.bean;

public class Test {

	Poll poll;
	Question question;
	Answer answer;
	User user;

	public Test () {}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

		Test that = (Test) o;


		if (getPoll()==null) {
			if (that.getPoll() != null) {
				return false;
			}
		} else if (!getPoll().equals(that.getPoll())) {
			return false;
		}

		if (getQuestion()==null) {
			if (that.getQuestion() != null) {
				return false;
			}
		} else if (!getQuestion().equals(that.getQuestion())) {
			return false;
		}
		if (getAnswer()==null) {
			if (that.getAnswer() != null) {
				return false;
			}
		} else if (!getAnswer().equals(that.getAnswer())) {
			return false;
		}

		if (getUser()==null) {
			if (that.getUser() != null) {
				return false;
			}
		} else if (!getUser().equals(that.getUser())) {
			return false;
		}




		return true;
	}

	@Override
	public int hashCode() {
		int result = getPoll() != null ? getPoll().hashCode() : 0;
		result = 31 * result + (getQuestion() != null ? getQuestion().hashCode() : 0);
		result = 31 * result + (getAnswer() != null ? getAnswer().hashCode() : 0);
		result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Test{" +
				"poll=" + poll +
				", question=" + question +
				", answer=" + answer +
				", user=" + user +
				'}';
	}
}
