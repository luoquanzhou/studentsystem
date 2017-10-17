package info;



public class Stuinfo {
		private String stuid;
		private String stuname;
		private String stusex;
		private String stuage;
		private String stuadd;
		private String stutel;
		private String stuqq;
		private String stuemail;
		private String stuclass;
		private String stuprocour;
		public Stuinfo() {
			super();
		}
		public Stuinfo(String stuid, String stuname, String stusex, String stunum, String stuacc, String stutel,
				String stuqq, String stuemail, String stuclass, String stuprocour) {
			super();
			this.stuid = stuid;
			this.stuname = stuname;
			this.stusex = stusex;
			this.stuage = stunum;
			this.stuadd = stuacc;
			this.stutel = stutel;
			this.stuqq = stuqq;
			this.stuemail = stuemail;
			this.stuclass = stuclass;
			this.stuprocour = stuprocour;
		}
		public String getStuid() {
			return stuid;
		}
		public void setStuid(String stuid) {
			this.stuid = stuid;
		}
		public String getStuname() {
			return stuname;
		}
		public void setStuname(String stuname) {
			this.stuname = stuname;
		}
		public String getStusex() {
			return stusex;
		}
		public void setStusex(String stusex) {
			this.stusex = stusex;
		}
	
		public String getStuage() {
			return stuage;
		}
		public void setStuage(String stuage) {
			this.stuage = stuage;
		}
		public String getStuadd() {
			return stuadd;
		}
		public void setStuadd(String stuadd) {
			this.stuadd = stuadd;
		}
		
		public String getStutel() {
			return stutel;
		}
		public void setStutel(String stutel) {
			this.stutel = stutel;
		}
		public String getStuqq() {
			return stuqq;
		}
		public void setStuqq(String stuqq) {
			this.stuqq = stuqq;
		}
		public String getStuemail() {
			return stuemail;
		}
		public void setStuemail(String stuemail) {
			this.stuemail = stuemail;
		}
		public String getStuclass() {
			return stuclass;
		}
		public void setStuclass(String stuclass) {
			this.stuclass = stuclass;
		}
		public String getStuprocour() {
			return stuprocour;
		}
		public void setStuprocour(String stuprocour) {
			this.stuprocour = stuprocour;
		}
		@Override
		public String toString() {
			return stuid + "," + stuname + "," + stusex + "," + stuage
					+ "," + stuadd + "," + stutel + "," + stuqq + "," + stuemail
					+ "," + stuclass + "," + stuprocour;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((stuid == null) ? 0 : stuid.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Stuinfo other = (Stuinfo) obj;
			if (stuid == null) {
				if (other.stuid != null)
					return false;
			} else if (!stuid.equals(other.stuid))
				return false;
			return true;
		}
		
		
}
