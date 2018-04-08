package tk.aizydorczyk.gradebook.infrastructure.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.aizydorczyk.gradebook.infrastructure.utility.AlertUtil;
import tk.aizydorczyk.gradebook.infrastructure.utility.SystemContext;

@Service
public abstract class BaseService {

	@Autowired
	protected AlertUtil alertUtil;

	@Autowired
	protected SystemContext systemContext;

}
