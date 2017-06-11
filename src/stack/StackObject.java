package stack;

import java.time.ZonedDateTime;

public class StackObject {

	private String objectName;
	private ZonedDateTime creationTime;

	public StackObject(String elementName) {
		setObjectName(elementName);
		setCreationTime();
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime() {
		creationTime = ZonedDateTime.now();
	}

}
