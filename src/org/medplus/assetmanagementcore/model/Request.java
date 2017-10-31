package org.medplus.assetmanagementcore.model;

import java.util.Date;

import org.medplus.assetmanagementcore.utils.AssetType;

public class Request {
	
private String employeeId;

private AssetType assetType;

private Date requestDate;

public String getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}

public AssetType getAssetType() {
	return assetType;
}

public void setAssetType(AssetType assetType) {
	this.assetType = assetType;
}

public Date getRequestDate() {
	return requestDate;
}

public void setRequestDate(Date requestDate) {
	this.requestDate = requestDate;
}

public String toString() {
	return "Request [employeeId=" + employeeId + ", assetType=" + assetType
			+ ", requestDate=" + requestDate + "]";
}

}
