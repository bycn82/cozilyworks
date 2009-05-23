package com.cozly.pro.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tbl_account table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tbl_account"
 */

public abstract class BaseAccount  implements Serializable {

	public static String REF = "Account";
	public static String PROP_COZID = "Cozid";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_EMAIL = "Email";
	public static String PROP_CREATEDAT = "Createdat";
	public static String PROP_ID = "Id";
	public static String PROP_REGISTEDIP = "Registedip";
	public static String PROP_UPDATEDAT = "Updatedat";
	public static String PROP_USERNAME = "Username";


	// constructors
	public BaseAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccount (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccount (
		java.lang.Integer id,
		java.lang.String cozid,
		java.lang.String username,
		java.lang.String password) {

		this.setId(id);
		this.setCozid(cozid);
		this.setUsername(username);
		this.setPassword(password);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cozid;
	private java.lang.String username;
	private java.lang.String password;
	private java.lang.String email;
	private java.util.Date createdat;
	private java.util.Date updatedat;
	private java.lang.String registedip;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: cozid
	 */
	public java.lang.String getCozid () {
		return cozid;
	}

	/**
	 * Set the value related to the column: cozid
	 * @param cozid the cozid value
	 */
	public void setCozid (java.lang.String cozid) {
		this.cozid = cozid;
	}



	/**
	 * Return the value associated with the column: username
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: createdat
	 */
	public java.util.Date getCreatedat () {
		return createdat;
	}

	/**
	 * Set the value related to the column: createdat
	 * @param createdat the createdat value
	 */
	public void setCreatedat (java.util.Date createdat) {
		this.createdat = createdat;
	}



	/**
	 * Return the value associated with the column: updatedat
	 */
	public java.util.Date getUpdatedat () {
		return updatedat;
	}

	/**
	 * Set the value related to the column: updatedat
	 * @param updatedat the updatedat value
	 */
	public void setUpdatedat (java.util.Date updatedat) {
		this.updatedat = updatedat;
	}



	/**
	 * Return the value associated with the column: registedip
	 */
	public java.lang.String getRegistedip () {
		return registedip;
	}

	/**
	 * Set the value related to the column: registedip
	 * @param registedip the registedip value
	 */
	public void setRegistedip (java.lang.String registedip) {
		this.registedip = registedip;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.cozly.pro.entity.Account)) return false;
		else {
			com.cozly.pro.entity.Account account = (com.cozly.pro.entity.Account) obj;
			if (null == this.getId() || null == account.getId()) return false;
			else return (this.getId().equals(account.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}