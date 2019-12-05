package Testproject;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class randomizer extends Base {

    public String random()

    {
        //today date td[class*='today']


        Random rand=new Random();
        int s=rand.nextInt(31);
       s += 1;

        String day=Integer.toString(s);

return day;

    }
public String randomday2()
{
    String day= new randomizer().random();
    Integer s=Integer.valueOf(day);
    int randomNum = ThreadLocalRandom.current().nextInt(s, 32);
    String day2=Integer.toString(randomNum);
    return day2;
}



    }











