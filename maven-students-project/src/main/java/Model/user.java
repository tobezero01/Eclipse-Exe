package Model;
// lưu thông tin người dùng
public class user {
	private String nameLogin;
    private String password;
	
	public user() {	}
	/**
	 * @param nameLogin
	 * @param passWord
	 */
	public user(String nameLogin, String passWord) {
		super();
		this.nameLogin = nameLogin;
		this.password = passWord;
	}
	public String getNameLogin() {
		return nameLogin;
	}
	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passWord) {
		this.password = passWord;
	}
     
}
