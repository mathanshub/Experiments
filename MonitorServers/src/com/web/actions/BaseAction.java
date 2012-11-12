package com.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Class design to gain access to default struts action elements
 * 
 */
public class BaseAction extends ActionSupport {

	public static final String TOKEN = "token";
	private static final long serialVersionUID = 1L;
	private String token;

	/**
	 * 
	 * @return The active request on the servlet
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 
	 * @return The response to be sent to the client
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();

	}

	/**
	 * 
	 * @return The active session
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * Generates a unique action token value
	 * 
	 * @return Unique action token value
	 */
	public void generateToken() {
		String uuid = RandomStringUtils.randomAlphanumeric(5);
		String token = getToken();
		if (token.length() > 0) {
			this.token = this.token.concat(",").concat(uuid);
		} else {
			this.token = uuid;
		}
	}

	/**
	 * Returns action token value
	 * 
	 * @return The action token name
	 */
	public String getToken() {
		String value = "";
		if (null != token) {
			value = this.token;
		}
		return value;
	}

	/**
	 * Set the token
	 * 
	 * @param token
	 */
	public void setToken(String token) {
		this.token = StringUtils.trim(token);
	}

	/**
	 * Retrieve the session attribute based on the composite key [attributeName +
	 * token]
	 * 
	 * @param attributeName
	 *            The requested attribute name
	 * @return The session object associated to the requested attribute name
	 */
	public Object getSessionAttribute(String attributeName) {
		Object obj = null;
		String compositeAttributeName = attributeName.concat(getToken());

		// Try to retrieve the object based on the composite key.
		obj = getSession().getAttribute(compositeAttributeName);
		if (null == obj) {
			// Inspect the parent attribute attribute name
			int index = compositeAttributeName.lastIndexOf(',');
			if (index > 0) {
				String parentCompositeAttributeName = compositeAttributeName
						.substring(0, index);
				if (null != parentCompositeAttributeName) {
					// Try to retrieve the object based on the parent
					obj = getSession().getAttribute(
							parentCompositeAttributeName);
				}

				if (obj == null) {
					index = compositeAttributeName.indexOf(',');

					if (index > 0) {
						parentCompositeAttributeName = compositeAttributeName
								.substring(0, index);

						if (null != parentCompositeAttributeName) {
							// Try to retrieve the object based on the parent
							obj = getSession().getAttribute(
									parentCompositeAttributeName);
						}
					}
				}
			}
		}
		if (obj == null) {
			// Last chance
			obj = getSession().getAttribute(attributeName);
		}
		return obj;
	}

	/**
	 * Set the session attribute name according to the composite key
	 * [attributeName + token]
	 * 
	 * @param attributeName
	 *            The attribue name
	 * @param obj
	 *            The object associated to the composite key [attributeName +
	 *            actionTokenName]
	 */
	public void setSessionAttribute(String attributeName, Object obj) {
		String compositeAttributeName = attributeName.concat(getToken());
		getSession().setAttribute(compositeAttributeName, obj);
	}

	/**
	 * Removes the attributeName from the session
	 * 
	 * @param attributeName
	 *            The attribue name
	 */
	public void removeSessionAttribute(String attributeName) {
		getSession().removeAttribute(attributeName);
	}

	public void saveToken() {
		// Overwrite the action token name if defined as a query string
		// parameter
		String tokenParamValue = getRequest().getParameter(TOKEN);
		if (null != tokenParamValue) {
			this.token = tokenParamValue;
		}
	}

}
