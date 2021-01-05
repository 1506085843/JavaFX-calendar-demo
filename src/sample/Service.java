package sample;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Service {


    public static String calculationDate(String y, String m) {
        char[] yearChar = y.toCharArray();
        char[] monthChar = m.toCharArray();

        if(null==y||y.length()==0||null==m||m.length()==0){
            return "年份或月份不能输入为空。";
        }


        for (int i = 0; i < yearChar.length; i++) {
            boolean isOrNo = Character.isDigit(yearChar[i]);
            if (yearChar[0] == '0' || !isOrNo) {
                return "年份输入错误，请输入正确的年份。";
            }
        }

        for (int i = 0; i < monthChar.length; i++) {
            boolean isOrNo = Character.isDigit(monthChar[i]);
            if (yearChar[0] == '0' || !isOrNo) {
                return "月份输入错误，请输入正确的月份。";
            }
        }

        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);

        if (year < 1900||(year==1900&&month==1)) {
            return "年份需要大于等于1900。当年份是1900时，月份需要大于1。";
        }

        if (month > 12) {
            return "月份输入错误，请输入正确的月份。";
        }

        LocalDate endDate = LocalDate.of(year, month, 1);//设置输入的日期
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        long sumDay = startDate.until(endDate, ChronoUnit.DAYS);//总相差的天数:3657
        /*以上代码计算1900年1月1号到输入的年月的总天数，如输入2018和8，则计算1900.1.1-2018.7.31的天数*/

        long xingQi = (sumDay + 1) % 7; //xingQi用来计算输入的月份1号星期几
        long everydayXingQi = sumDay + 1;
        int monthDay = endDate.lengthOfMonth();//用来接收输入的月份有几天

        String result = "日\t一\t二\t三\t四\t五\t六\n";
        for (int i = 0; i < xingQi; i++) {    //输出每月1号前的空格
            result += "\t";
        }
        for (int i = 1; i <= monthDay; i++) {  //输出每个月的天数和控制换行
            if (everydayXingQi % 7 == 6) {
                result += i + "\n";
            } else {
                result += i + "\t";
            }
            everydayXingQi++;
        }
        return result;
    }

}
