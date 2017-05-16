package by.tc.opinionpull.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		// один мегабайт
		factory.setSizeThreshold(1024*1024);

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

				if (item.isFormField()) {
					//если принимаемая часть данных является полем формы
					formItem.put(item.getFieldName(), item.getString());
				} else {
					//в противном случае рассматриваем как файл
					processUploadedFile(item);
				}
			}
			processFormField(formItem);
		} catch (Exception e) {
			//TODO
			return;
		}
	}

	private void processUploadedFile(FileItem item) throws Exception {
		File uploadetFile = null;
		String path;
		//выбираем файлу имя пока не найдём свободное
		do{
			/*String*/ path = getServletContext().getRealPath("/images/"+random.nextInt() + item.getName());
			uploadetFile = new File(path);
		}while(uploadetFile.exists());
		//создаём файл
		uploadetFile.createNewFile();
		//записываем в него данные
		item.write(uploadetFile);
		//System.out.print(path);

	}


	private void processFormField(Map<String, String> item) {
		//TODO
	}
}
