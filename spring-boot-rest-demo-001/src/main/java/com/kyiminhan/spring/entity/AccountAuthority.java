package com.kyiminhan.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kyiminhan.spring.types.Authority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AccountAuthority extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column
	private Authority authority;

	@ManyToOne(cascade = { CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.EAGER, targetEntity = Account.class, optional = true)
	@JoinColumn(name = "account_id")
	@JsonIgnore
	private Account account;

	@Builder
	public AccountAuthority(final Long id, final Authority authority, final Account account) {
		super(id);
		this.authority = authority;
		this.account = account;
	}
}