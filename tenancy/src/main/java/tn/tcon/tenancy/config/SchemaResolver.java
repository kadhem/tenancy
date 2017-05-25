package tn.tcon.tenancy.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import tn.tcon.tenancy.domain.User;

@Component
public class SchemaResolver implements CurrentTenantIdentifierResolver {

	private String tenantIdentifier = "dbtcon2";

	@Override
	public String resolveCurrentTenantIdentifier() {
		// retrieve tenant from logged in user
		try {
			User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (usr != null)
				return usr.getTenantName();
		} catch (Exception e) {
		}
		return tenantIdentifier;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return false;
	}

	public void setTenantIdentifier(String tenantIdentifier) {
		this.tenantIdentifier = tenantIdentifier;
	}
}