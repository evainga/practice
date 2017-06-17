package de.stack;

public class StackObject {

	private String objectName;
	private int creationIndex;

	public StackObject(String objectName, int creationIndex) {
		this.objectName = objectName;
		this.creationIndex = creationIndex;

	}

	public String getObjectName() {
		return objectName;
	}

	public int getCreationIndex() {
		return creationIndex;
	}

}
