package tn.tcon.tenancy.bean;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserBean extends User {

	public UserBean(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			Long id, String name, String schemaNom) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
		this.name = name;
		this.schemaNom = schemaNom;
	}

	public UserBean(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id,
			String name, String schemaNom) {
		super(username, password, authorities);
		this.id = id;
		this.name = name;
		this.schemaNom = schemaNom;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String schemaNom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchemaNom() {
		return schemaNom;
	}

	public void setSchemaNom(String schemaNom) {
		this.schemaNom = schemaNom;
	}

}
