import java.util.Random;
public class RandomNumber
{
public int getRandomNumber(int low,int high)
{
Random r=new Random();
return r.nextInt(high-low)+low+1;
}
}
