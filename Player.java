public class Player
{
String name;
int score;
int currentGuessedNumber;
public Player()
{
this.name="";
this.score=0;
}
public void setGuessedNumber(int currentGuessedNumber)
{
this.currentGuessedNumber=currentGuessedNumber;
}
public int getGuessedNumber()
{
return this.currentGuessedNumber;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setScore(int score)
{
this.score=score;
}
public int getScore()
{
return this.score;
}
}
