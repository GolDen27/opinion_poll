package by.tc.opinionpull.service;

import by.tc.opinionpull.bean.*;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;

public interface TestService {

	void addTest (String idPoll, String idQuestion, String idAnswer, String loginUser) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException;
	Test getTest (String idPoll, String idQuestion, String idAnswer, String loginUser) throws ServiceException, ServiseIllegalArgumentException ;
	void changeTest (String oldIdPoll, String oldIdQuestion, String oldIdAnswer, String oldLoginUser, String newIdPoll, String newIdQuestion, String newIdAnswer, String newLoginUser) throws ServiceException, ServiseIllegalArgumentException ;
	void deleteTest (String idPoll, String idQuestion, String idAnswer, String loginUser) throws ServiceException, ServiseIllegalArgumentException ;


}
