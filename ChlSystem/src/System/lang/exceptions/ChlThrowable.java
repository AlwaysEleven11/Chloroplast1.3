package System.lang.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ChlThrowable {
   private final String DetailMessages;
   private final List<String> STACK_TRACE;

   public ChlThrowable(String detailMessages){
      DetailMessages = detailMessages;
      STACK_TRACE = new ArrayList<>();
   }

   public void pushInStackTrace(String newElement) {
      STACK_TRACE.add(newElement);
   }

   public void collectProblem() {
      Throwable cause = new Throwable().fillInStackTrace();
      StackTraceElement[] elements = cause.getStackTrace();
      for (StackTraceElement element : elements) {
         String className = element.getClassName();
         if (!className.equals(this.getClass().getName())) {
            STACK_TRACE.add(className);
         }
      }
   }

   public void printException() {
      System.err.println("The fatal problem occurred in thread '" + Thread.currentThread().getName() + "' " + getClass().getName() + ": " + DetailMessages);
      if (!STACK_TRACE.isEmpty()) {
         for (String s : STACK_TRACE) {
            System.err.println("at " + s);
         }
      } else {
         System.err.println("The reason is empty(0x000000UN).\nPlease refer to the issue separately or contact the developer of the program for assistance.");
      }
   }

   /** Caption for labeling causative exception stack traces */
   private static final String CAUSE_CAPTION = "Caused by: ";

   /** Caption for labeling suppressed exception stack traces */
   private static final String SUPPRESSED_CAPTION = "Suppressed: ";
}