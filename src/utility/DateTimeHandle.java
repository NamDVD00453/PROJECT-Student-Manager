package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DateTimeHandle {

    // validate xem ngày truyền vào có sớm hơn ngày hiện tại không, nếu ok thì trả về true
    public static boolean isValidDate(long date) {
        boolean isValid = false;

        if (date != 0) {
            if (date < System.currentTimeMillis()) isValid = true;
        }
        return isValid;
    }


    // so sánh ngày from và ngày to dạng long, nếu 1 trong 2 = 0 thì true, nếu cả 2 != 0, thì so sánh, from < to thì trả về true
    public static boolean isCompareDate(long from, long to) {
        boolean isCompare = false;

        if ((from != 0 && to != 0) && isValidDate(from)) {
            if (from < to) isCompare = true;
        }
        return isCompare;
    }

    // parse LocalDate to milliseconds, return 0 if localDate == null
    public static long parseLocalDateToMilliSeconds(LocalDate localDate) {
        // millisecond time
        long mst = 0;

        if (localDate != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(0);
            calendar.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
            mst = calendar.getTimeInMillis();
        }
        return mst;
    }

    public static long parseStringDateToMilliSeconds(String dateString) {
        long mst = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(dateString));
            mst = cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mst;
    }

    public static long parseReportDate(String dateString) {
        long mst = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(dateString));
            mst = cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mst;
    }

    public static String parseMilliSecondsDateToString(long milliSeconds) {
        StringBuilder dateString = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        dateString.append(calendar.get(Calendar.DAY_OF_MONTH))
                    .append("-")
                    .append(calendar.get(Calendar.MONTH) + 1)
                    .append("-")
                    .append(calendar.get(Calendar.YEAR))
                .append(" ")
                .append(calendar.get(Calendar.HOUR))
                .append(":")
                .append(calendar.get(Calendar.MINUTE))
        ;
        return dateString.toString();
    }
}
