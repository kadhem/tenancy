package tn.tcon.tenancy.config.multiTenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import tn.tcon.tenancy.bean.UserBean;

@Component
public class SchemaResolver implements CurrentTenantIdentifierResolver {

	private String tenantIdentifier = "dbtcon2";

	@Override
	public String resolveCurrentTenantIdentifier() {
		// retrieve tenant from logged in user
		try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				UserBean usr = (UserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (usr != null) {
					return usr.getSchemaNom();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
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