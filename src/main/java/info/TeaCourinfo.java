package info;



public class TeaCourinfo {
		private String couid;
		private String couname;
		private String coustytime;
		private String couscore;
		private String coustatime;
		private String couteaid;
		private String couteaname;
		
		public TeaCourinfo() {
			super();
			
		}

		public TeaCourinfo(String couid, String couname, String coustytime, String couscore, String coustatime,
				String couteaid, String couteaname) {
			super();
			this.couid = couid;
			this.couname = couname;
			this.coustytime = coustytime;
			this.couscore = couscore;
			this.coustatime = coustatime;
			this.couteaid = couteaid;
			this.couteaname = couteaname;
		}

		public String getCouid() {
			return couid;
		}

		public void setCouid(String couid) {
			this.couid = couid;
		}

		public String getCouname() {
			return couname;
		}

		public void setCouname(String couname) {
			this.couname = couname;
		}

		public String getCoustytime() {
			return coustytime;
		}

		public void setCoustytime(String coustytime) {
			this.coustytime = coustytime;
		}

		public String getCouscore() {
			return couscore;
		}

		public void setCouscore(String couscore) {
			this.couscore = couscore;
		}

		public String getCoustatime() {
			return coustatime;
		}

		public void setCoustatime(String coustatime) {
			this.coustatime = coustatime;
		}

		public String getCouteaid() {
			return couteaid;
		}

		public void setCouteaid(String couteaid) {
			this.couteaid = couteaid;
		}

		public String getCouteaname() {
			return couteaname;
		}

		public void setCouteaname(String couteaname) {
			this.couteaname = couteaname;
		}

		@Override
		public String toString() {
			return couid + "," + couname + "," + coustytime + ","
					+ couscore + "," + coustatime + "," + couteaid + "," + couteaname;
		}
		
		
}
