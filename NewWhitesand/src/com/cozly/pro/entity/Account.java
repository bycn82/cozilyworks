package com.cozly.pro.entity;

import com.cozly.pro.entity.base.BaseAccount;



public class Account extends BaseAccount {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Account () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Account (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Account (
		java.lang.Integer id,
		java.lang.String cozid,
		java.lang.String username,
		java.lang.String password) {

		super (
			id,
			cozid,
			username,
			password);
	}

/*[CONSTRUCTOR MARKER END]*/


}