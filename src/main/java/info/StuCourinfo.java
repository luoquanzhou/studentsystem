package info;



public class StuCourinfo {
		private String stuid;
		private String stucouid;
		private String stucouname;
		private String stustytime;
		private String stuscore;
		private String stustatime;
		private String teaname;
		private String teaid;
		public StuCourinfo() {
			super();
		}
		
		public StuCourinfo(String stuid, String stucouid, String stucouname, String stustytime, String stuscore,
				String stustatime, String teaname, String teaid) {
			super();
			this.stuid = stuid;
			this.stucouid = stucouid;
			this.stucouname = stucouname;
			this.stustytime = stustytime;
			this.stuscore = stuscore;
			this.stustatime = stustatime;
			this.teaname = teaname;
			this.teaid = teaid;
		}

		
		public String getStuid() {
			return stuid;
		}

		public void setStuid(String stuid) {
			this.stuid = stuid;
		}

		public String getStucouid() {
			return stucouid;
		}

		public void setStucouid(String stucouid) {
			this.stucouid = stucouid;
		}

		public String getStucouname() {
			return stucouname;
		}

		public void setStucouname(String stucouname) {
			this.stucouname = stucouname;
		}

		public String getStustytime() {
			return stustytime;
		}

		public void setStustytime(String stustytime) {
			this.stustytime = stustytime;
		}

		public String getStuscore() {
			return stuscore;
		}

		public void setStuscore(String stuscore) {
			this.stuscore = stuscore;
		}

		public String getStustatime() {
			return stustatime;
		}

		public void setStustatime(String stustatime) {
			this.stustatime = stustatime;
		}

		public String getTeaname() {
			return teaname;
		}

		public void setTeaname(String teaname) {
			this.teaname = teaname;
		}

		public String getTeaid() {
			return teaid;
		}

		public void setTeaid(String teaid) {
			this.teaid = teaid;
		}

		@Override
		public String toString() {
			return stuid + "," + stucouid + "," + stucouname + ","
					+ stustytime + "," + stuscore + "," + stustatime + "," + teaname
					+ "," + teaid;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((stucouname == null) ? 0 : stucouname.hashCode());
			result = prime * result + ((stuid == null) ? 0 : stuid.hashCode());
			result = prime * result + ((stucouid == null) ? 0 : stucouid.hashCode());
			result = prime * result + ((stuscore == null) ? 0 : stuscore.hashCode());
			result = prime * result + ((stustatime == null) ? 0 : stustatime.hashCode());
			result = prime * result + ((stustytime == null) ? 0 : stustytime.hashCode());
			result = prime * result + ((teaid == null) ? 0 : teaid.hashCode());
			result = prime * result + ((teaname == null) ? 0 : teaname.hashCode());
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
			StuCourinfo other = (StuCourinfo) obj;
			if (stucouname == null) {
				if (other.stucouname != null)
					return false;
			} else if (!stucouname.equals(other.stucouname))
				return false;
			if (stuid == null) {
				if (other.stuid != null)
					return false;
			} else if (!stuid.equals(other.stuid))
				return false;
			if (stucouid == null) {
				if (other.stucouid != null)
					return false;
			} else if (!stucouid.equals(other.stucouid))
				return false;
			if (stuscore == null) {
				if (other.stuscore != null)
					return false;
			} else if (!stuscore.equals(other.stuscore))
				return false;
			if (stustatime == null) {
				if (other.stustatime != null)
					return false;
			} else if (!stustatime.equals(other.stustatime))
				return false;
			if (stustytime == null) {
				if (other.stustytime != null)
					return false;
			} else if (!stustytime.equals(other.stustytime))
				return false;
			if (teaid == null) {
				if (other.teaid != null)
					return false;
			} else if (!teaid.equals(other.teaid))
				return false;
			if (teaname == null) {
				if (other.teaname != null)
					return false;
			} else if (!teaname.equals(other.teaname))
				return false;
			return true;
		}
		
		
}
