package com.androidboilerplate.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@link StringUtil} class is used to manage convenience methods for
 * {@link String} manipulation.
 */
@SuppressLint("DefaultLocale")
public class StringUtil {

    Context mContext;

    /**
     * Constructor.
     */
    private StringUtil() {
    }

    public StringUtil(Context context) {
        mContext = context;

    }

    /**
     * Return true if the string is null or empty (zero length); otherwise
     * false.
     *
     * @param string the string to test
     * @return true if the string is null or empty; otherwise false
     */
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * Return true if the string is null, empty, "null", or contains only
     * whitespace; otherwise false.
     *
     * @param string the string to test
     * @return true if the string is null, empty, or contains only whitespace;
     * otherwise false
     */
    public static boolean isBlank(String string) {
        return string == null || string.length() == 0
                || string.trim().length() == 0 || string.equals("null");
    }

    public static SpannableStringBuilder showSuperScript(String smallText, int start, int end) {
        SpannableStringBuilder mSSBuilder;
        SuperscriptSpan mSuperscriptSpan;
        mSuperscriptSpan = new SuperscriptSpan();
        mSSBuilder = new SpannableStringBuilder(smallText);
        mSSBuilder.setSpan(
                mSuperscriptSpan, // Span to add
                start, // Start of the span (inclusive)
                end, // End of the span (exclusive)
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // Do not extend the span when text add later
        );
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(.7f);

        // Apply the RelativeSizeSpan to display small text
        mSSBuilder.setSpan(
                relativeSizeSpan,
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        return mSSBuilder;

    }

    public static String formatDateUsingArgs(String inputDate, String inputFormat,String outputFormat) {
        String day = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(inputFormat, Locale.ENGLISH);
        try {
            Date date = dateFormat.parse(inputDate);
            DateFormat formatDate = new SimpleDateFormat(outputFormat);
            day = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
                }
        return day;
    }

    public static String formatDayWithDate(String date) {
        String day = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date inputDate = dateFormat.parse(date);
            DateFormat formatDate = new SimpleDateFormat("EEEE");
            day = formatDate.format(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
         }

        return day;
    }

    public static String formatMonthStringWithDate(String date) {
        String month = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date inputDate = dateFormat.parse(date);
            DateFormat formatDate = new SimpleDateFormat("MMM");
            month = formatDate.format(inputDate);

        } catch (ParseException e) {
            e.printStackTrace();
         }

        return month;
    }

    public static String formatMonthStringWithYear(String date) {
        String month = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date inputDate = dateFormat.parse(date);
            DateFormat formatDate = new SimpleDateFormat("MMM yyyy");
            month = formatDate.format(inputDate);

        } catch (ParseException e) {
            e.printStackTrace();
          }

        return month;
    }

    public static String formatDayStringWithDate(String inputDate) {

        String dayString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = dateFormat.parse(inputDate);
            DateFormat formatDate = new SimpleDateFormat("d");
            dayString = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return dayString;
    }

    public static String getDayOfMonthSuffix(String inputDate) {
        int n = Integer.parseInt(formatDate(inputDate));
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
    public static String formatDate(String inputDate) {

        String dayString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = dateFormat.parse(inputDate);
            DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
            dayString = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return dayString;
    }
    public static String formatDateStringWithDate(String inputDate) {

        String dayString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        try {
            Date date = dateFormat.parse(inputDate);
            DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
            dayString = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return dayString;
    }

    public static String formatDateStringChangeFormat(String inputDate) {

        String dayString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {

            Date date = dateFormat.parse(inputDate);
            DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
            dayString = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return dayString;
    }

    public static String formatRecentPaymentDateStringWithDate(String inputDate) {
        String dayString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {

            Date date = dateFormat.parse(inputDate);
            DateFormat formatDate = new SimpleDateFormat("MMM dd, yyyy");
            dayString = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayString;
    }

    public static String formatinterestratetodisplay(float rate) {
        DecimalFormat threeZeroes = new DecimalFormat("#0.000");
        String result = threeZeroes.format(rate);
        return result;
    }

    // Use this method to format the amount which is to be displayed through out the application
    public static String formatAmountToDisplay(double amount) {
        if(amount == 0.0) return "";
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        String currencyFormatted = decimalFormat.format(amount);
        return currencyFormatted;
    }

    public static String formatAmountToDisplayWithAnyAmount(double amount) {
        if(amount == 0.0) return "0.00";
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        String currencyFormatted = decimalFormat.format(amount);
        return currencyFormatted;
    }

    public static String formatAmountToDisplayWithoutComma(double amount) {
        if(amount == 0.0) return "";
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String currencyFormatted = decimalFormat.format(amount);
        return currencyFormatted;
    }
    // Use this method to format the amount which is to be displayed through out the application
    public static String formatAmountToDisplayWithDollar(double amount) {
        if(amount == 0.0) return "";
        DecimalFormat decimalFormat = new DecimalFormat("$#,###.00");
        String currencyFormatted = decimalFormat.format(amount);
        return currencyFormatted;
    }

    public static String formatZIPToDisplay(int zip) {
        String formattedZip = String.format("%05d", zip);
        return formattedZip;
    }

    public static String getAccountNumberForDisplay(String accNumber) {
        return accNumber.substring(accNumber.length() - 4, accNumber.length());
    }

    public static boolean getAccountNumberCompare(String string1, String string2) {
        if (string1.equals(string2)) {
            return true;
        }
        return false;
    }

    public static String formatEasternTimeZone() {

        String dayString = "";

        String strTimeZone = "EST";
        try {
            TimeZone timeZone = TimeZone.getTimeZone(strTimeZone);
            long utc = System.currentTimeMillis();
            Date date = new Date(utc);
            DateFormat format = new SimpleDateFormat("EEE, MMM d, yyyy");
            format.setTimeZone(timeZone);
            dayString = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayString;
    }

    public static String getCurrentDate(String dateFormat) {

        String dayString = "";

        String strTimeZone = "EST";
        try {
            TimeZone timeZone = TimeZone.getTimeZone(strTimeZone);
            long utc = System.currentTimeMillis();
            Date date = new Date(utc);
            DateFormat format = new SimpleDateFormat(dateFormat);
            format.setTimeZone(timeZone);
            dayString = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayString;
    }

    public static String formatEasternTimeZoneMMMddyyyy() {

        String dayString = "";

        String strTimeZone = "EST";
        try {
            TimeZone timeZone = TimeZone.getTimeZone(strTimeZone);
            long utc = System.currentTimeMillis();
            Date date = new Date(utc);
            DateFormat format = new SimpleDateFormat("MMM d, yyyy");

            format.setTimeZone(timeZone);
            dayString = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayString;
    }

    public static String formatEasternTimeZoneDay() {

        String dayString = "";

        String strTimeZone = "EST";
        try {
            TimeZone timeZone = TimeZone.getTimeZone(strTimeZone);
            long utc = System.currentTimeMillis();
            Date date = new Date(utc);
            DateFormat format = new SimpleDateFormat("EEEE");

            format.setTimeZone(timeZone);
            dayString = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayString;
    }

    public static String formatPaymentDateforBanner(String paymentDate) {
        String dayString = "";
        Date date = null;
        SimpleDateFormat actualDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = actualDateFormat.parse(paymentDate);
            DateFormat expectedDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            dayString = expectedDateFormat.format(date);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return dayString;
    }

    public static String getCurrentYear() {

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearInString = String.valueOf(year);

        return yearInString;
    }

    public static int formatDiffDaysFromCurrentDate(String paymentDueDate) {

        int dayCount = 0;
        Date givenDate = null;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat actualDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            givenDate = actualDateFormat.parse(paymentDueDate);
            Date currentDate = c.getTime();
            long diffDate = currentDate.getTime() - givenDate.getTime();
            dayCount = (int) ((float) diffDate / (24 * 60 * 60 * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayCount;
    }

    public static String addMonth(String paymentDueDate, int count) {
        String dayString = "";
        Date date = null;
        SimpleDateFormat actualDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = actualDateFormat.parse(paymentDueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, count); //minus number would decrement the days
        dayString = actualDateFormat.format(cal.getTime());
        return dayString;
    }
    //superscriptRatio=0.3  relativeSpanSize=0.7
    public static SpannableStringBuilder superScript(String str, String superscript,int startPos, int endPos,float superscriptRatio,float relativeSpanSize) {
        if(isNullOrEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        int i = str.indexOf(superscript)+superscript.length()-1;
        SpannableStringBuilder cs = new SpannableStringBuilder(str);
        cs.setSpan(new SuperscriptSpanAdjuster(superscriptRatio), i+startPos, i+startPos+endPos, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        cs.setSpan(new RelativeSizeSpan(relativeSpanSize), i+startPos,  i+startPos+endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return cs;
    }

    public static Boolean isNullOrEmpty(String strValue) {
        Boolean isTrue = false;
        if (strValue == null) {
            isTrue = true;
        } else {
            isTrue = strValue.isEmpty();
        }
        return isTrue;
    }

    public static Double removeNonNumericCharacters(String stringWithDollar) {
        Boolean isNULL = StringUtil.isNullOrEmpty(stringWithDollar);
        if(isNULL) return 0.0;
        return Double.parseDouble(stringWithDollar.replace("$", "").replace(",", ""));
    }

    public static String phoneNumber(String textWithPhonenumber){
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(textWithPhonenumber);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        return matcher.group(0);
    }

//    public String getStringfromObject(Object object) {
//        if (object == null) {
//            throw new IllegalArgumentException("object is null");
//        }
//        return GSON.toJson(object);
//    }
//
//    public  <T> T getObjectfromString(String value, Class<T> a) {
//        String gson = value;
//        if (gson == null) {
//            return null;
//        } else {
//            try {
//                return GSON.fromJson(gson, a);
//            } catch (Exception e) {
//                throw new IllegalArgumentException("Object storaged with key is instanceof other class");
//            }
//        }
//    }
}