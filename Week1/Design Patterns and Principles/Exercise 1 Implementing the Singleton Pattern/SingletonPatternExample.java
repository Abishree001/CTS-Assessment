public class SingletonPatternExample{
    public static void main(String [] args){
        Logger logger1=Logger.getInstance();
        logger1.log("First log message");
        
        Logger logger2=Logger.getInstance();
        logger2.log("Second log message");

        if(logger1 == logger2){
            System.out.println("Logger is singleton.Both instance are same");
        }
        else{
            System.out.println("Logger is not singleton.Both instance are not same");
        }

    }

}