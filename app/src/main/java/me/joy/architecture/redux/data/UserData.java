package me.joy.architecture.redux.data;

/**
 * Created by Joy on 2019/6/10
 */
public class UserData {

  private String userName;
  private String pwd;

  public UserData(String userName, String pwd) {
    this.userName = userName;
    this.pwd = pwd;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return "UserData{" +
        "userName='" + userName + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
}
