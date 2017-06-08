package by.tc.opinionpull.bean;

public class User {

    String login;
    String password;
    String surname;
    String name;
    Boolean typeOfUser;
    String photoPath;
    Integer age;
    Byte gender;
    String country;
    String phone;
    String siteLink;

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

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

        if (getGender()==null) {
            if (that.getGender() != null) {
                return false;
            }
        } else if (!getGender().equals(that.getGender())) {
            return false;
        }

        if (getCountry()==null) {
            if (that.getCountry() != null) {
                return false;
            }
        } else if (!getCountry().equals(that.getCountry())) {
            return false;
        }

        if (getPhone()==null) {
            if (that.getPhone() != null) {
                return false;
            }
        } else if (!getPhone().equals(that.getPhone())) {
            return false;
        }

        if (getSiteLink()==null) {
            if (that.getSiteLink() != null) {
                return false;
            }
        } else if (!getSiteLink().equals(that.getSiteLink())) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getTypeOfUser().hashCode();
        result = 31 * result + getPhotoPath().hashCode();
        result = 31 * result + getAge().hashCode();
        result = 31 * result + getGender().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getPhone().hashCode();
        result = 31 * result + getSiteLink().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", typeOfUser=" + typeOfUser +
                ", photoPath='" + photoPath + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", siteLink='" + siteLink + '\'' +
                '}';
    }
}
