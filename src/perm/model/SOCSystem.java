package perm.model;

public class SOCSystem {
	protected String prevailingWageSocCode;
	protected String prevailingWageSocTitle;
	
	public SOCSystem(String prevailingWageSocCode, String prevailingWageSocTitle) {
		super();
		this.prevailingWageSocCode = prevailingWageSocCode;
		this.prevailingWageSocTitle = prevailingWageSocTitle;
	}

	public SOCSystem(String prevailingWageSocCode) {
		super();
		this.prevailingWageSocCode = prevailingWageSocCode;
	}

	public String getPrevailingWageSocCode() {
		return prevailingWageSocCode;
	}

	public void setPrevailingWageSocCode(String prevailingWageSocCode) {
		this.prevailingWageSocCode = prevailingWageSocCode;
	}

	public String getPrevailingWageSocTitle() {
		return prevailingWageSocTitle;
	}

	public void setPrevailingWageSocTitle(String prevailingWageSocTitle) {
		this.prevailingWageSocTitle = prevailingWageSocTitle;
	}
	
	

}
