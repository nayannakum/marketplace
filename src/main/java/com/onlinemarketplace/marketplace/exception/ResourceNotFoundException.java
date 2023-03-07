package com.onlinemarketplace.marketplace.exception;

import org.bson.types.ObjectId;

public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private ObjectId fieldValue;
	
	
	 public ResourceNotFoundException(String resourceName, String fieldName, ObjectId objectId) {
		 super(String.format("%s not found with %s : '%s'", resourceName, fieldName, objectId)); // user not found with id : 1
		         this.resourceName = resourceName;
		         this.fieldName = fieldName;
		         this.fieldValue = objectId;
		     }


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public ObjectId getFieldValue() {
		return fieldValue;
	}


	public void setFieldValue(ObjectId fieldValue) {
		this.fieldValue = fieldValue;
	}

	 
	 
}
