package exam_vo.passwordChange;

public class SavePassword implements java.io.Serializable{
	private String initialpassword;// 原密码
	private String newpassword;// 新密码
	private String confirmpassword;// 确认密码
	
	private String user_code;

	public String getInitialpassword() {
		return initialpassword;
	}

	public void setInitialpassword(String initialpassword) {
		this.initialpassword = initialpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	

	
}
