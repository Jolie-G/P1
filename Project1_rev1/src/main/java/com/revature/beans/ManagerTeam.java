package com.revature.beans;

public class ManagerTeam {
	int teamid;
	int supermanagerid;
	int managerid;
	int employeeid;
	public ManagerTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerTeam(int teamid, int supermanagerid, int managerid, int employeeid) {
		super();
		this.teamid = teamid;
		this.supermanagerid = supermanagerid;
		this.managerid = managerid;
		this.employeeid = employeeid;
	}
	@Override
	public String toString() {
		return "ManagerTeam [teamid=" + teamid + ", supermanagerid=" + supermanagerid + ", managerid=" + managerid
				+ ", employeeid=" + employeeid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeid;
		result = prime * result + managerid;
		result = prime * result + supermanagerid;
		result = prime * result + teamid;
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
		ManagerTeam other = (ManagerTeam) obj;
		if (employeeid != other.employeeid)
			return false;
		if (managerid != other.managerid)
			return false;
		if (supermanagerid != other.supermanagerid)
			return false;
		if (teamid != other.teamid)
			return false;
		return true;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public int getSupermanagerid() {
		return supermanagerid;
	}
	public void setSupermanagerid(int supermanagerid) {
		this.supermanagerid = supermanagerid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	

}
