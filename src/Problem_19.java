/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)? 171
 */
import java.time.*;

import static java.time.DayOfWeek.SUNDAY;

public class Problem_19 {
    public static void main(String[] args) {

        String date = "";
        int countSum = 0;

        for (int i = 1901; i < 2001; i++){
            for (int j = 1; j <= 12; j++){
                date = String.valueOf(i);
                if (j < 10){
                    date = date + "-0" + j + "-01";
                }
                else {
                    date = date + "-" + j + "-01";
                }
                if (LocalDate.parse(date).getDayOfWeek() == SUNDAY){
                    countSum++;
                }
            }
        }
        System.out.println("Number of Sundays = " + countSum);
        System.out.println("Day of Week = " + isDayOfWeek(1901,9,1));
    }

    public static int isDayOfWeek(int y, int m, int d){
        if (m < 3){
            m += 12;
            y--;
        }
        return (int)(d + ((m+1) *2.6) + y + (y/4) + 6*(y/100) + (y/400) + 6) % 7;
    }
}
