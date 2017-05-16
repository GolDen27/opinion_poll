package by.tc.opinionpull.bean;

public class Answer {

	Integer id;
	String reply;

	public Answer () {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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

		Answer that = (Answer) o;


		if (getId()==null) {
			if (that.getId() != null) {
				return false;
			}
		} else if (!getId().equals(that.getId())) {
			return false;
		}

		if (getReply()==null) {
			if (that.getReply() != null) {
				return false;
			}
		} else if (!getReply().equals(that.getReply())) {
			return false;
		}


		return true;

	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getReply().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Answer{" +
				"id=" + id +
				", reply='" + reply + '\'' +
				'}';
	}
}
