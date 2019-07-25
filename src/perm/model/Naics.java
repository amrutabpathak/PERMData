package perm.model;


/**
 * NAICSCode INT,
 * NAICSTitle VARCHAR(255)
 *
 */
public class Naics {
	protected int naicsCode;
	protected String naicsTitle;
	
	
	public Naics(int naicsCode, String naicsTitle) {
		super();
		this.naicsCode = naicsCode;
		this.naicsTitle = naicsTitle;
	}
	
	public Naics(int naicsCode) {
		this.naicsCode = naicsCode;
	}

	public Naics(int naicsCode) {
		super();
		this.naicsCode = naicsCode;
	}



	public int getNaicsCode() {
		return naicsCode;
	}


	public void setNaicsCode(int naicsCode) {
		this.naicsCode = naicsCode;
	}


	public String getNaicsTitle() {
		return naicsTitle;
	}


	public void setNaicsTitle(String naicsTitle) {
		this.naicsTitle = naicsTitle;
	}
	
	

}
