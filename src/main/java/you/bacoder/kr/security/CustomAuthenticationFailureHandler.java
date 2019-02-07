package you.bacoder.kr.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import you.bacoder.kr.Config;

@Component("customAuthenticationFailureHandler")
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String loginidname;
	private String loginpasswordname;
	private String loginredirectname;
	private String exceptionmsgname;
	private String defaultFailureUrl;
	private final String EXCEPTION_MSG_SESSION = "Maximum sessions of 1 for this principal exceeded";
	
	public CustomAuthenticationFailureHandler() {
		this.loginidname = "loginid";
		this.loginpasswordname = "loginpwd";
		this.loginredirectname = "loginRedirect";
		this.exceptionmsgname = "securityexceptionmsg";
		this.defaultFailureUrl = "/login";
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String loginId = request.getParameter(this.loginidname);
		String loginPwd = request.getParameter(this.loginpasswordname);
		String loginRedirect = request.getParameter(this.loginredirectname);
		
		request.setAttribute(this.loginidname, loginId);
		request.setAttribute(this.loginpasswordname, loginPwd);
		request.setAttribute(this.loginredirectname, loginRedirect);
		
		logger.info("fail : " + loginRedirect);
		
		String exceptionMsg = exception.getMessage();
		if(exceptionMsg.equalsIgnoreCase(EXCEPTION_MSG_SESSION)) {
			exceptionMsg = Config.SESSION_LOGIN_FAIL;
		}
		request.setAttribute(this.exceptionmsgname, exceptionMsg);
		
		request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
	}

	public String getLoginidname() {
		return loginidname;
	}

	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}

	public String getLoginpasswordname() {
		return loginpasswordname;
	}

	public void setLoginpasswordname(String loginpasswordname) {
		this.loginpasswordname = loginpasswordname;
	}

	public String getLoginredirectname() {
		return loginredirectname;
	}

	public void setLoginredirectname(String loginredirectname) {
		this.loginredirectname = loginredirectname;
	}

	public String getExceptionmsgname() {
		return exceptionmsgname;
	}

	public void setExceptionmsgname(String exceptionmsgname) {
		this.exceptionmsgname = exceptionmsgname;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}
	
	
}
