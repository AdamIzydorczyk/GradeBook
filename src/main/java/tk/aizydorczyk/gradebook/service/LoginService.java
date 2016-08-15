package tk.aizydorczyk.gradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.aizydorczyk.gradebook.controller.MainController;
import tk.aizydorczyk.gradebook.dao.LoginDao;
import tk.aizydorczyk.gradebook.enums.RoleType;

@Service
public class LoginService extends BaseService implements UserDetailsService {

	@Autowired
	private MainController mainController;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private LoginDao loginDao;

	@Transactional
	public void login(String login, String password) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login, password));

		if (authenticate.isAuthenticated()) {
			SecurityContextHolder
					.getContext()
					.setAuthentication(authenticate);

			switch (RoleType.getRoleByAuthenticate(authenticate)) {
				case STUDENT:
					mainController.changeToStudentLayout();
					break;
				case LECTURER:
					mainController.changeToLecturerLayout();
					break;
				case NONE:
					alertUtil.authorizationFailAlert();
					break;
			}
		}
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return loginDao.getAccountByUsername(userName);
	}
}
