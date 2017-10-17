package info;


public class Teainfo {
	private String teaid;
	private String teaname;
	private String teasex;
	private String teaage;
	private String teatel;
	private String teaadd;
	private String teajob;
	private String teaqq;
	private String teaemail;
	private String teaexp;
//	teaid varchar2(10) primary key,
//	teaname varchar2(20),
//	teasex varchar2(5),
//	teaage varchar2(3),
//	teatel varchar2(11),
//	teaadd varchar2(50),
//	teajob varchar2(20),
//	teaqq varchar2(11),
//	teaemail varchar2(30),
//	teaexp varchar2(50)
	public Teainfo() {
		super();
	}
	public Teainfo(String teaid, String teaname, String teasex, String teaage, String teatel, String teaadd,
			String teajob, String teaqq, String teaemail, String teaexp) {
		super();
		this.teaid = teaid;
		this.teaname = teaname;
		this.teasex = teasex;
		this.teaage = teaage;
		this.teatel = teatel;
		this.teaadd = teaadd;
		this.teajob = teajob;
		this.teaqq = teaqq;
		this.teaemail = teaemail;
		this.teaexp = teaexp;
	}
	public String getTeaid() {
		return teaid;
	}
	public void setTeaid(String teaid) {
		this.teaid = teaid;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	public String getTeasex() {
		return teasex;
	}
	public void setTeasex(String teasex) {
		this.teasex = teasex;
	}
	public String getTeaage() {
		return teaage;
	}
	public void setTeaage(String teaage) {
		this.teaage = teaage;
	}
	public String getTeatel() {
		return teatel;
	}
	public void setTeatel(String teatel) {
		this.teatel = teatel;
	}
	public String getTeaadd() {
		return teaadd;
	}
	public void setTeaadd(String teaadd) {
		this.teaadd = teaadd;
	}
	public String getTeajob() {
		return teajob;
	}
	public void setTeajob(String teajob) {
		this.teajob = teajob;
	}
	public String getTeaqq() {
		return teaqq;
	}
	public void setTeaqq(String teaqq) {
		this.teaqq = teaqq;
	}
	public String getTeaemail() {
		return teaemail;
	}
	public void setTeaemail(String teaemail) {
		this.teaemail = teaemail;
	}
	public String getTeaexp() {
		return teaexp;
	}
	public void setTeaexp(String teaexp) {
		this.teaexp = teaexp;
	}
	@Override
	public String toString() {
		return "Teainfo [teaid=" + teaid + ", teaname=" + teaname + ", teasex=" + teasex + ", teaage=" + teaage
				+ ", teatel=" + teatel + ", teaadd=" + teaadd + ", teajob=" + teajob + ", teaqq=" + teaqq
				+ ", teaemail=" + teaemail + ", teaexp=" + teaexp + "]";
	}



	

	
}
