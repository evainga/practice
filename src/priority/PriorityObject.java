package priority;

import java.time.ZonedDateTime;

public class PriorityObject {

	private String objectName;
	private int priority;
	private ZonedDateTime creationTime;

	public PriorityObject(String elementName, int priority) {
		setObjectName(elementName);
		setPriority(priority);
		setCreationTime(ZonedDateTime.now());
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
	}

}
