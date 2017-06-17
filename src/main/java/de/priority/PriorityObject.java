package de.priority;

public class PriorityObject {

	private String objectName;
	private int priority;
	private int creationIndex;

	public PriorityObject(String objectName, int priority, int creationIndex) {
		this.priority = priority;
		this.objectName = objectName;
		this.creationIndex = creationIndex;
	}

	public String getObjectName() {
		return objectName;
	}

	public int getPriority() {
		return priority;
	}

	public int getCreationIndex() {
		return creationIndex;
	}

}
