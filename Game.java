import java.util.*;
import java.io.*;
import java.lang.*;
public class Game
{
private int[] scores;
private Player player1;
private Player player2;
private Player playerToGuess;
private Scanner g;
private RandomNumber randomNumber;
private int numberToGuess;
Game()
{
scores=new int[6];
this.scores[0]=20;
this.scores[1]=15;
this.scores[2]=11;
this.scores[3]=8;
this.scores[4]=6;
this.scores[5]=5;
this.randomNumber=new RandomNumber();
this.player1=new Player();
this.player2=new Player();
this.g=new Scanner(System.in);
this.playerInput();
this.startGame();
}
public void playerInput()
{
System.out.print("Hello Human! please enter your name : ");
this.player1.setName(this.g.next());
this.player2.setName("computer");
while(true)
{
if(this.player1.getName().length()<=1 || this.player1.getName().length() >8)
{
System.out.println("Re-enter your name(Between 1 to 8 characters)");
this.player1.setName(this.g.next());
continue;
}
break;
}
}
public void turnChances()
{
if(playerToGuess.getName().equals(player1.getName())) playerToGuess=player2;
else  playerToGuess=player1;
}
public int guessNumber(int l,int h)
{
return (l+h)/2;
//return randomNumber.getRandomNumber(l,h);
}

public void startGame()
{
int low,high;
low=1;
high=100;
int num;
int abandoningNumber;
int attemptCount=1;
int roundCount=4;
int s;
for(int i=1;i<=4;i++)
{
this.firstToGuess();
abandoningNumber=randomNumber.getRandomNumber(1,20);
numberToGuess=randomNumber.getRandomNumber(1,100);
System.out.println("----------Round : "+i+"----------\n");
System.out.println("Please ! Guess a number between 1 and 100(inclusive)");
low=1;
high=100;
attemptCount=1;
while(attemptCount<=6)
{
System.out.println(playerToGuess.getName()+" ! Guess the  number ");
if(playerToGuess.getName().equals("computer"))
{ 
if(randomNumber.getRandomNumber(1,20)==abandoningNumber)
{
System.out.println("Round abandoned by "+playerToGuess.getName());
break;
}
num=guessNumber(low,high);
playerToGuess.setGuessedNumber(num);
try
{
Thread.sleep(1000);
}catch(InterruptedException ie)
{
System.out.println("Game Interrupted");
}
System.out.println(num);
}
else 
{
try
{
num=g.nextInt();
if(num==999)
{
System.out.println("Round abandoned by "+playerToGuess.getName());
break;
}
}catch(Exception e)
{
System.out.println("WARNING ! Please Guess a valid number.");
g.nextLine();
continue;
}
if(num<1 || num>100)  continue;
if(num<low || num>high ){
System.out.println("WARNING ! Guess a valid number next time.");
playerToGuess.setGuessedNumber(num);
turnChances();
continue;
}
playerToGuess.setGuessedNumber(num);
}
if(num<numberToGuess)
{
System.out.println("SMALLER");
low=num+1;
}
else
{
if(num>numberToGuess)
{
System.out.println("HIGHER");
high=num-1;
}
else
{
if(attemptCount<=6) playerToGuess.setScore(playerToGuess.getScore()+scores[attemptCount-1]);
System.out.println("Correct Guess !"+playerToGuess.getName());
break;
}
}
this.turnChances(); 
attemptCount++;
System.out.print("\n");
if(attemptCount==7)
{
System.out.println("Correct Number:" +numberToGuess);
System.out.println("Scores will be given on the basis of proximity");
if(Math.abs(player1.getGuessedNumber()-numberToGuess)<10)
{
player1.setScore(player1.getScore()+(10-Math.abs(player1.getGuessedNumber()-numberToGuess)));
}
if(Math.abs(player2.getGuessedNumber()-numberToGuess)<10)
{
player2.setScore(player2.getScore()+(10-Math.abs(player2.getGuessedNumber()-numberToGuess)));
}
}
}
}
determineWinner();
}
public void determineWinner()
{
System.out.println("***************"+player1.getName()+" your total score is :"+player1.getScore()+"************************");
System.out.println("***************"+player2.getName()+" your total score is :"+player2.getScore()+"************************");
if(player1.getScore()>player2.getScore()) System.out.println("\nCongratulations ! "+player1.getName()+" you won.");
else
{ 
if(player2.getScore()>player1.getScore()) System.out.println("\nCongratulations ! "+player2.getName()+" you won.");
else System.out.println("\n Game resulted in Draw");
}
}
public void firstToGuess()
{
int ch;
ch=randomNumber.getRandomNumber(0,2);
if(ch==1) playerToGuess=this.player1;
else playerToGuess=this.player2;
}
public static void main(String gg[])
{
Game game=new Game();
}
}
