package info;

public class Userinfo {
	private String username;
	private String usertype;
	private String userpwd;
	
	public Userinfo() {
		super();
	}

	public Userinfo(String username, String usertype, String userpwd) {
		super();
		this.username = username;
		this.usertype = usertype;
		this.userpwd = userpwd;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return username + "," + usertype + "," + userpwd;
	}
	
	
}
