package by.tc.opinionpull.bean;

public class User {

    String login;
    String password;
    String surname;
    String name;
    Boolean typeOfUser;
    String photoPath;
    Integer age;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(Boolean typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

        User that = (User) o;


        if (getLogin()==null) {
            if (that.getLogin() != null) {
                return false;
            }
        } else if (!getLogin().equals(that.getLogin())) {
            return false;
        }

        if (getPassword()==null) {
            if (that.getPassword() != null) {
                return false;
            }
        } else if (!getPassword().equals(that.getPassword())) {
            return false;
        }

        if (getName()==null) {
            if (that.getName() != null) {
                return false;
            }
        } else if (!getName().equals(that.getName())) {
            return false;
        }

        if (getSurname()==null) {
            if (that.getSurname() != null) {
                return false;
            }
        } else if (!getSurname().equals(that.getSurname())) {
            return false;
        }

        if (getTypeOfUser()==null) {
            if (that.getTypeOfUser() != null) {
                return false;
            }
        } else if (!getTypeOfUser().equals(that.getTypeOfUser())) {
            return false;
        }


        if (getPhotoPath()==null) {
            if (that.getPhotoPath() != null) {
                return false;
            }
        } else if (!getPhotoPath().equals(that.getPhotoPath())) {
            return false;
        }

        if (getAge()==null) {
            if (that.getAge() != null) {
                return false;
            }
        } else if (!getAge().equals(that.getAge())) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getTypeOfUser() != null ? getTypeOfUser().hashCode() : 0);
        result = 31 * result + (getPhotoPath() != null ? getPhotoPath().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", typeOfUser=" + typeOfUser +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
