package cn.swiftPass.point.engine.common.util;

import cn.swiftPass.point.engine.common.enums.LangCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class CommonUtil {

    public static String dateToString(String format, Date date) {
        if (date == null) {
            return "";
        }
        if (format == null || format.trim().isEmpty()) {
            format = CommonConstants.STD_DATE_TIME_FORMAT;
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static LangCode getLangCodeFromHeader(HttpServletRequest httpRequest) {
        if (httpRequest == null) {
            return LangCode.EN;
        }
        String lang = httpRequest.getHeader(CommonConstants.HEADER_LANG);
        if (!validString(lang)) {
            return LangCode.EN;
        }
        return LangCode.get(lang);
    }

    public static Date stringToDate(String format, String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        if (format == null || format.trim().isEmpty()) {
            format = CommonConstants.STD_DATE_TIME_FORMAT;
        }
        try {
            return new SimpleDateFormat(format).parse(dateString);
        } catch (Exception e) {
            //LOG
        }
        return null;
    }

    public static String changeDateStringFormat(String fromFormat, String toFormat, String dateString) {
        if (!validString(dateString)) {
            return null;
        }
        if (!validString(fromFormat) && !validString(toFormat)) {
            return dateString;
        }
        if (!validString(fromFormat)) {
            fromFormat = CommonConstants.STD_DATE_TIME_FORMAT;
        }
        if (!validString(toFormat)) {
            toFormat = CommonConstants.STD_DATE_TIME_FORMAT;
        }
        return dateToString(toFormat, stringToDate(fromFormat, dateString));
    }

    public static boolean isValidDateString(String format, String dateStr) {
        if (!validString(dateStr)) {
            return false;
        }
        if (!validString(format)) {
            format = CommonConstants.STD_DATE_TIME_FORMAT;
        }
        try {
            new SimpleDateFormat(format.trim()).parse(dateStr.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getBaseUrl(HttpServletRequest httpRequest) {
        if (httpRequest == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(httpRequest.getScheme());
        sb.append("://");
        sb.append(httpRequest.getServerName());
        sb.append(":");
        sb.append(httpRequest.getServerPort());
        sb.append(httpRequest.getContextPath());
        return sb.toString();
    }

    public static boolean validNumber(Number value) {
        return value != null && value.floatValue() > 0;
    }

    public static boolean validLong(Long val) {
        return val != null && val.compareTo(0L) > 0;
    }

    public static boolean validString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean validDate(Date value) {
        return value != null;
    }

    public static boolean validFile(MultipartFile file) {
        return file != null && file.getSize() > 0;
    }

    @SuppressWarnings("rawtypes")
    public static boolean validCollection(Collection col) {
        return col != null && !col.isEmpty();
    }

    public static boolean isValidNumberString(String numString) {
        if (!validString(numString)) {
            return false;
        }
        try {
            Double.valueOf(numString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean isValidEmailFormat(String email) {
        if (!validString(email)) {
            return false;
        }
        return Pattern.compile(
                        "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(email).matches();
    }


    public static String generateOtp() {
        String numbers = "0123456789";
        Random rndm_method = new Random();
        StringBuffer otp = new StringBuffer();
        for (int i = 0; i < CommonConstants.OTP_LENGTH; i++) {
            otp.append(numbers.charAt(rndm_method.nextInt(numbers.length())));
        }
        return otp.toString();
    }

    public static LangCode getLangCodeFromLocale(Locale locale) {
        if (locale == null || !validString(locale.toString())) {
            return LangCode.EN;
        }
        return LangCode.get(locale.toString());
    }

    public static String formatPrice(Integer price) {
        if (!validNumber(price)) {
            return "";
        }
        return String.format("%,d", price) + " " + CommonConstants.CURRENCY_CODE;
    }

    public static String formatPriceWithoutCurrency(Integer price) {
        if (!validNumber(price)) {
            return "";
        }
        return String.format("%,d", price);
    }

    public static String formatPriceWithoutCurrencyAndCheckInvalid(Integer price) {
        return String.format("%,d", price);
    }

    public static boolean isSubscriptionExpired(String subscriptionEndTime, String format) {
        if (!CommonUtil.validString(subscriptionEndTime)) {
            return true;
        }
        if (!CommonUtil.validString(format)) {
            format = CommonConstants.STD_DATE_TIME_FORMAT;
        }
        Date endTime = CommonUtil.stringToDate(format, subscriptionEndTime);
        if (endTime == null) {
            return true;
        }
        return endTime.before(new Date());
    }

    public static boolean validInteger(Integer val) {
        return val != null && val.compareTo(0) > 0;
    }

    public static boolean isValidNonNegativeInteger(Integer val) {
        return val != null && val.compareTo(0) >= 0;
    }

    @SuppressWarnings("rawtypes")
    public static boolean validList(List value) {
        return value != null && !value.isEmpty();
    }

    public static String dateStringToDbDate(String dateString) {
        String dbDate[] = dateString.split("/");
        // change year-month-day
        String databaseDate = dbDate[2] + "-" + dbDate[1] + "-" + dbDate[0];
        return databaseDate;
    }

    public static boolean validBigDecimal(BigDecimal val) {
        return val != null && val.setScale(0, RoundingMode.HALF_UP).compareTo(BigDecimal.ZERO) > 0;
    }

    public static String formatNumber(BigDecimal val) {
        if (!validBigDecimal(val)) {
            return "0";
        }
        return new DecimalFormat("#,##0").format(formatCurrencyScale(val));
    }

    public static BigDecimal formatCurrencyScale(BigDecimal amount) {
        if (!validBigDecimal(amount)) {
            return BigDecimal.ZERO;
        }
        return amount.setScale(0, RoundingMode.HALF_UP);
    }

    public static String generateCustomerLoginId() {
        String chars = generateRandomChars(3);
        String number = generateRandomNumber(3, 4);
        return chars + number;
    }

    private static String generateRandomChars(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        return sb.toString();
    }

    private static String generateRandomNumber(int minLength, int maxLength) {
        Random random = new Random();
        int length = minLength + random.nextInt(maxLength - minLength + 1);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateRandomString(int length) {

        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int API_KEY_LENGTH = 40;
        Random RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
