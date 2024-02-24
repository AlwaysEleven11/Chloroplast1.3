package com.hstech.verification;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class verification {
     public static void VerIfi(){
         String givenTimestamp = "2023-10-19"; // 给定的时间戳，格式为"yyyy-MM-dd"

         // 获取当前日期
         LocalDate currentDate = LocalDate.now();

         // 将给定时间戳转换为LocalDate对象
         LocalDate givenDate = LocalDate.parse(givenTimestamp, DateTimeFormatter.ISO_DATE);

         if (currentDate.equals(givenDate)) {
             System.out.println("时间戳校验通过");
         } else {
             System.out.println("时间戳校验失败");
         }
     }
}
