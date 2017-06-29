package jp.co.axiz.web.entity;

public class Admin {

	private String AdminId;
	private String AdminPass;
	private String AdminName;

	public Admin() {
	}


	public Admin(String adminId, String adminName, String adminPass) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.AdminId = adminId;
		this.AdminPass = adminPass;
		this.AdminName = adminName;

	}


	public String getAdminId() {
		return AdminId;
	}


	public void setAdminId(String adminId) {
		AdminId = adminId;
	}


	public String getAdminPass() {
		return AdminPass;
	}


	public void setAdminPass(String adminPass) {
		AdminPass = adminPass;
	}


	public String getAdminName() {
		return AdminName;
	}


	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

}