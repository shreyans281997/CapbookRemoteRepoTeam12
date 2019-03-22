package com.cg.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FriendRequest {
	@Id
	@SequenceGenerator(name="friendRequest",initialValue=1,allocationSize=100000,sequenceName="request_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendRequest")
	private Integer requestId;
	private String senderEmailId;
	private String receiverEmailId;
	private String status="pending";
	
	public FriendRequest() {}

	public FriendRequest(Integer requestId, String senderEmailId, String receiverEmailId, String status) {
		super();
		this.requestId = requestId;
		this.senderEmailId = senderEmailId;
		this.receiverEmailId = receiverEmailId;
		this.status = status;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public String getReceiverEmailId() {
		return receiverEmailId;
	}
	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FriendRequest [requestId=" + requestId + ", senderEmailId=" + senderEmailId + ", receiverEmailId="
				+ receiverEmailId + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((receiverEmailId == null) ? 0 : receiverEmailId.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((senderEmailId == null) ? 0 : senderEmailId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		FriendRequest other = (FriendRequest) obj;
		if (receiverEmailId == null) {
			if (other.receiverEmailId != null)
				return false;
		} else if (!receiverEmailId.equals(other.receiverEmailId))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (senderEmailId == null) {
			if (other.senderEmailId != null)
				return false;
		} else if (!senderEmailId.equals(other.senderEmailId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
