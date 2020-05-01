class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        //1/1/1971 is a Friday
        int days = 0;
        int startYear = 1971;
        int startMonth = 1;
        while(startYear<year){
            if(isLeapYear(startYear))
                days+=366;
            else
                days+=365;
            startYear++;
        }
        while(startMonth<month){
            if(startMonth==2 && isLeapYear(year))
                days+=29;
            if(startMonth==2 && !isLeapYear(year))
                days+=28;
            if(startMonth == 1 || startMonth==3 || startMonth==5 || startMonth==7 || startMonth==8 || startMonth==10 || startMonth==12)
                days+=31;
            if(startMonth==4 || startMonth==6 || startMonth==9 || startMonth==11)
                days+=30;
            startMonth++;
        }
        days+= day;
        String ans="";
        switch(days%7){
            case 1: ans = "Friday";
                    break;
            case 2: ans = "Saturday";
                    break;
            case 3: ans = "Sunday";
                    break;
            case 4: ans = "Monday";
                    break;
            case 5: ans = "Tuesday";
                    break;
            case 6: ans = "Wednesday";
                    break;
            case 0: ans = "Thursday";
                    break;
                
        }
        return ans;
        
    }
    private static boolean isLeapYear(int year){
        if(year%4==0 && year%100!=0 || year%400==0)
            return true;
        else 
            return false;
    }
}
