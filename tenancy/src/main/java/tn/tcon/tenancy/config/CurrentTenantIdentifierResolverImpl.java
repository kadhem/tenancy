package tn.tcon.tenancy.config;

import org.apache.log4j.Logger;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

/**
 * It specify what Tenant should be use when the hibernate session is created.
 * 
 * @author jm
 */
@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	Logger logger = Logger.getLogger(getClass());

	private final String DEFAULT_TENANTID = "dbtcon";

	@Override
	public String resolveCurrentTenantIdentifier() {

		String tenant = resolveTenantByHttpSession();
		logger.trace("Tenant resolved: " + tenant);
		return tenant;
	}

	/**
	 * Get tenantId in the session attribute KEY_TENANTID_SESSION
	 * 
	 * @return TenantId on KEY_TENANTID_SESSION
	 */
	public String resolveTenantByHttpSession() {
		// ServletRequestAttributes attr = (ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes();
		// // If session attribute exists returns tenantId saved on the session
		// if (attr != null) {
		// HttpSession session = attr.getRequest().getSession(false); // true
		// // ==
		// // allow
		// // create
		// if (session != null) {
		// String tenant = (String) session.getAttribute(KEY_TENANTID_SESSION);
		// if (tenant != null) {
		// return tenant;
		// }
		// }
		// }
		// otherwise return default tenant
		logger.trace("Tenant resolved in session is: " + DEFAULT_TENANTID);
		return DEFAULT_TENANTID;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}
}