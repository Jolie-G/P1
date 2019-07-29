package com.revature.beans;

public class Reimbursement {
private int reimId;
private int reimauthorId;
private int reimresolverId;
private int reimStatusId;
private String receiptImage;
public Reimbursement() {
	super();
	// TODO Auto-generated constructor stub
}
public Reimbursement(int reimId, int reimauthorId, int reimresolverId, int reimStatusId, String receiptImage) {
	super();
	this.reimId = reimId;
	this.reimauthorId = reimauthorId;
	this.reimresolverId = reimresolverId;
	this.reimStatusId = reimStatusId;
	this.receiptImage = receiptImage;
}
public int getReimId() {
	return reimId;
}
public void setReimId(int reimId) {
	this.reimId = reimId;
}
public int getReimauthorId() {
	return reimauthorId;
}
public void setReimauthorId(int reimauthorId) {
	this.reimauthorId = reimauthorId;
}
public int getReimresolverId() {
	return reimresolverId;
}
public void setReimresolverId(int reimresolverId) {
	this.reimresolverId = reimresolverId;
}
public int getReimStatusId() {
	return reimStatusId;
}
public void setReimStatusId(int reimStatusId) {
	this.reimStatusId = reimStatusId;
}
public String getReceiptImage() {
	return receiptImage;
}
public void setReceiptImage(String receiptImage) {
	this.receiptImage = receiptImage;
}
@Override
public String toString() {
	return "Reimbursement [reimId=" + reimId + ", reimauthorId=" + reimauthorId + ", reimresolverId=" + reimresolverId
			+ ", reimStatusId=" + reimStatusId + ", receiptImage=" + receiptImage + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((receiptImage == null) ? 0 : receiptImage.hashCode());
	result = prime * result + reimId;
	result = prime * result + reimStatusId;
	result = prime * result + reimauthorId;
	result = prime * result + reimresolverId;
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
	Reimbursement other = (Reimbursement) obj;
	if (receiptImage == null) {
		if (other.receiptImage != null)
			return false;
	} else if (!receiptImage.equals(other.receiptImage))
		return false;
	if (reimId != other.reimId)
		return false;
	if (reimStatusId != other.reimStatusId)
		return false;
	if (reimauthorId != other.reimauthorId)
		return false;
	if (reimresolverId != other.reimresolverId)
		return false;
	return true;
}

}
