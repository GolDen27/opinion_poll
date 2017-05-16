package by.tc.opinionpull.bean;

public class Topic {

	Integer id;
	String title;

	public Topic () {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

		Topic that = (Topic) o;


		if (getId()==null) {
			if (that.getId() != null) {
				return false;
			}
		} else if (!getId().equals(that.getId())) {
			return false;
		}

		if (getTitle()==null) {
			if (that.getTitle() != null) {
				return false;
			}
		} else if (!getTitle().equals(that.getTitle())) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Topic{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
