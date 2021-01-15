package shop.steamowls.common;

import java.util.regex.Pattern;

public class RegExp {
	public static final int REGEXP_ID = 1;
	public static final int REGEXP_PW = 2;
	public static final int REGEXP_NAME = 3;
	public static final int REGEXP_TEL = 4;
	public static final int REGEXP_GENDER = 5;
	public static final int REGEXP_SMS_FL = 6;
	public static final int REGEXP_INFO_FL = 7;
	public static final int REGEXP_NUMBER = 8;

	public static boolean isValidExp(String data, int type) {
		boolean isValid = false;
		if (isEmpty(data)) {
			return isValid;
		}
		switch (type) {
		case REGEXP_ID:
			isValid = !Pattern.matches("^[a-z0-9]{4,10}$", data);
			break;
		case REGEXP_PW:
			isValid = !Pattern.matches("^[a-z0-9]{4,10}$", data);
			break;
		case REGEXP_NAME:
			isValid = !Pattern.matches("^[가-힣]{2,6}$", data);
			break;
		case REGEXP_TEL:
			isValid = !Pattern.matches("^[0-9]{11,11}$", data);
			break;
		case REGEXP_GENDER:
			isValid = !Pattern.matches("^[가-힣]{1,1}$", data);
			break;
		case REGEXP_SMS_FL:
			isValid = !Pattern.matches("^[a-z]{4,5}$", data);
			break;
		case REGEXP_INFO_FL:
			isValid = !Pattern.matches("^[a-z]{4,5}$", data);
			break;
		case REGEXP_NUMBER:
			isValid = !Pattern.matches("^[0-9]*$", data);
			break;
		}
		return isValid;
	}

	public static boolean isEmpty(String data) {
		if (data == null || data.equals("")) {
			return true;
		} else {
			return false;
		}
	}
}