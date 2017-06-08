package priority;

public class PriorityObject {

	private String objectName;
	private int priority;
	private long creationTime;

	public PriorityObject(String elementName, int priority) {
		setObjectName(elementName);
		setPriority(priority);
		setCreationTime();
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

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime() {
		creationTime = System.currentTimeMillis();
	}

}
