package by.tc.opinionpull.controller;

import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.service.UserService;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.factory.ServiceFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileUpload extends HttpServlet {

	private Random random = new Random();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// Создаём класс фабрику
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Максимальный размер буфера данных в байтах,
		// при его привышении данные начнут записываться на диск во временную директорию
		// пять мегабайт
		factory.setSizeThreshold(1024*1024*5);

		// устанавливаем временную директорию
		File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(tempDir);

		//Создаём загрузчик
		ServletFileUpload upload = new ServletFileUpload(factory);

		//максимальный размер данных который разрешено загружать в байтах
		//по умолчанию -1, без ограничений. Ставим 10 мегабайт.
		upload.setSizeMax(1024 * 1024 * 10);

		try {
			List<FileItem> items = upload.parseRequest(request);
			Map<String, String> formItem = new HashMap<String, String>();
			Iterator iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				String fileName;
				if (item.isFormField()) {
					//если принимаемая часть данных является полем формы
					formItem.put(item.getFieldName(), item.getString());
				} else {
					//в противном случае рассматриваем как файл
					formItem.put("photo-name",processUploadedFile(item));
				}
			}
			processFormField(formItem);
			HttpSession session = request.getSession(true);
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();
			User user = userService.getUser(formItem.get("user"));
			session.setAttribute("user", user);
			response.sendRedirect(JspPath.JSP_MAIN_PATH);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String processUploadedFile(FileItem item) throws Exception {
		File uploadetFile = null;
		//выбираем файлу имя пока не найдём свободное
		do{
			String path = getServletContext().getRealPath("/images/"+random.nextInt() + item.getName());
			uploadetFile = new File(path);
		}while(uploadetFile.exists());
		//создаём файл
		uploadetFile.createNewFile();
		//записываем в него данные
		item.write(uploadetFile);
		return uploadetFile.getName();

	}


	private void processFormField(Map<String, String> item) {
		//TODO
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		try {
			User user = userService.getUser(item.get("user"));
			String login = user.getLogin();
			String surname = user.getSurname();
			String name = user.getName();
			String typeOfUser = user.getTypeOfUser()?"1":"0";
			String photoPath = "/images/"+item.get("photo-name");
			String age = user.getAge().toString();
			String gender = user.getGender().toString();
			String country = user.getCountry();
			String phone = user.getPhone();
			String siteLink = user.getSiteLink();
			userService.changeUser(login, login, surname, name, typeOfUser, photoPath, age, gender, country, phone, siteLink);

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ServiseIllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
