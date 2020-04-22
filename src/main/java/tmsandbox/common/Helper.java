package tmsandbox.common;

public class Helper {

    public static void sleepInMillis(long millis){
        try{
            Thread.sleep(millis);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
