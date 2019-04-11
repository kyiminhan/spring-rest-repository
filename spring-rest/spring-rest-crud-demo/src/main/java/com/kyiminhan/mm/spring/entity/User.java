package com.kyiminhan.mm.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.uuid.Generators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class User.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.entity </BR>
 *        User.java </BR>
 */
@Table

/**
 * Gets the uuid.
 *
 * @return the uuid
 */
@Getter

/**
 * Sets the uuid.
 *
 * @param uuid the new uuid
 */
@Setter
@Entity

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Builder

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@ToString

/**
 * Instantiates a new user.
 */
@NoArgsConstructor

/**
 * Instantiates a new user.
 *
 * @param Id        the id
 * @param firstName the first name
 * @param lastName  the last name
 * @param email     the email
 * @param phone     the phone
 * @param address   the address
 * @param version   the version
 * @param uuid      the uuid
 */
@AllArgsConstructor

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long Id;

	/** The first name. */
	@Column
	private String firstName;

	/** The last name. */
	@Column
	private String lastName;

	/** The email. */
	@Column
	private String email;

	/** The phone. */
	@Column
	private String phone;

	/** The address. */
	@Column
	private String address;

	/** The version. */
	@Version
	@Column
	private int version;

	/** The uuid. */
	@Column(nullable = false, updatable = true, insertable = true)
	private String uuid;

	/**
	 * Load.
	 */
	@PrePersist
	@PreUpdate
	public void load() {
		this.uuid = Generators.timeBasedGenerator().generate().toString();
	}
}