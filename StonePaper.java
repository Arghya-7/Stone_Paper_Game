import java.util.*;
class Human
{
	static int produceChance()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 0 for stone:");
		System.out.println("Enter 1 for paper");
		System.out.println("Enter 2 for Scissor");
		System.out.println("Enter the choice:");
		int choice=sc.nextInt();
		return choice;
	}
}
class Computer
{
	static int produceChance()
	{
		Random r=new Random();
		int choice=r.nextInt(3);
		return choice;
	}
}
public class StonePaper {
	static void checkComputerMove(int n)
	{
		if(n==0)
		{
			System.out.println("Computer's move:Stone");
		}
		else if(n==1)
		{
			System.out.println("Computer's move:Paper");			
		}
		else
		{
			System.out.println("Computer's move:Scissor");
		}
	}
	static int checkGame(int a,int b)
	{
		if(a==b)
		{
			return 0;
		}
		else if(a==0 && b==1||a==1 && b==2||a==2 && b==0)
		{
			return -1;
		}
		return 1;
	}
	static int score;
	static int playerScore=0;
	static int compScore=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of round you want to play:");
		StonePaper.score=sc.nextInt();
		while(true)
		{
			int playerChoice=Human.produceChance();
			int computerChoice=Computer.produceChance();
			int result=StonePaper.checkGame(playerChoice, computerChoice);
			if(result==0)
			{
				System.out.println("It is drawn");
			}
			else if(result==-1)
			{
				System.out.println("You Loose in this turn");
				StonePaper.checkComputerMove(computerChoice);
				StonePaper.compScore=StonePaper.compScore+1;
				System.out.println("******Scorecard******");
				System.out.println("Your Score:"+StonePaper.playerScore+"  "+"Computer score:"+StonePaper.compScore);
			}
			else
			{
				System.out.println("You win in this turn");
				StonePaper.checkComputerMove(computerChoice);
				StonePaper.playerScore=StonePaper.playerScore+1;
				System.out.println("******Scorecard******");
				System.out.println("Your Score:"+StonePaper.playerScore+"  "+"Computer score:"+StonePaper.compScore);
			}
			if(StonePaper.compScore==StonePaper.score)
			{
				System.out.println("******Final Result******");
				System.out.println("Oops!You loose");
				System.out.println("Batter Luck next time");
				break;
			}
			else if(StonePaper.playerScore==StonePaper.score)
			{
				System.out.println("******Final Result******");
				System.out.println("Hurrah!You have won");
				break;
			}
			
		}
	}

}
