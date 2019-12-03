/**
 * 
 */
package com.cognizant.moviecruiser.dao;

/**
 * @ created by madhangi 761100
 *
 */
public class FavouriteEmptyException extends Exception {
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param message
	 */
	public FavouriteEmptyException(String message) {
		super();
		this.message = message;
	}
}
