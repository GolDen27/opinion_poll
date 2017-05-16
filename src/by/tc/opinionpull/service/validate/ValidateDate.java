package by.tc.opinionpull.service.validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidateDate {

	private final static Logger LOGGER = LogManager.getLogger();

	private ValidateDate () {}

	private final static Matcher getMatcher (String data, String exp) {
		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(data);
		LOGGER.debug(data + " " + matcher.matches());
		return matcher;
	}

	public final static boolean checkLogin (String login) {
		Matcher matcher = getMatcher(login, ValidateString.LOGIN);


		return matcher.matches();
	}

	public final static boolean checkPassword (String password) {
		Matcher matcher = getMatcher(password, ValidateString.PASSWORD);
		return matcher.matches();
	}

	public final static boolean checkWordWithBigLetter (String word) {
		Matcher matcher = getMatcher(word,ValidateString.WORD_WITH_BIG_LETTER);
		return matcher.matches();
	}

	public final static boolean checkWord (String word) {
		Matcher matcher = getMatcher(word, ValidateString.WORD);
		return matcher.matches();
	}

	public final static boolean checkPositiveNumber(String number) {
		Matcher matcher = getMatcher(number, ValidateString.POSITIVE_NUMBER);
		return matcher.matches();
	}

	public final static boolean checkPositiveRealNumber(String realNumber) {
		Matcher matcher = getMatcher(realNumber, ValidateString.POSITIVE_REAL_NUMBER);
		return matcher.matches();
	}

	public final static boolean checkNumber (String number) {
		Matcher matcher = getMatcher(number, ValidateString.NUMBER);
		return matcher.matches();
	}

	public final static boolean checkBooleanNumber (String bool) {
		Matcher matcher = getMatcher(bool,ValidateString.BOOLEAN_NUMBER);
		return matcher.matches();
	}

	public final static boolean checkText (String text) {
		Matcher matcher = getMatcher(text,ValidateString.TEXT);
		return matcher.matches();
	}



}
