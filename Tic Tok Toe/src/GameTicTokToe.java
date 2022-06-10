import java.util.Scanner;

public class GameTicTokToe {

	public static void display(char a[][]){
		for(int i=0;i<3;i++){
			System.out.println("-------------");
			for(int j=0;j<3;j++){
				if(j==0)
					System.out.print("| ");

				System.out.print(a[i][j]+" | ");
			}
			System.out.println();
			if(i==2){
				System.out.println("-------------");
			}
		}
	}

	public static boolean add(char s,char[][] a,char ip){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(a[i][j]==s){
					a[i][j]=ip;
					return true;
				}
		return false;
	}
	
	public static boolean check(char a[][]){
		char k='1';
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				if(a[i][j]==k++)
					return true;
			}
		return false;
	}
	
	public static String winner(char[][] a){
		if((a[0][0]==a[0][1] && a[0][1]==a[0][2])||(a[0][0]==a[1][0] && a[1][0]==a[2][0])||(a[0][0]==a[1][1] && a[1][1]==a[2][2]))
			if(a[0][0]=='X')
				return "Player1 Won.";
			else
				return "Player2 Won.";
		
		if((a[2][0]==a[2][1] && a[2][1]==a[2][2])||(a[0][2]==a[1][2] && a[1][2]==a[2][2])||(a[0][2]==a[1][1] && a[1][1]==a[2][0]))
			if(a[0][2]=='X')
				return "Player1 Won.";
			else
				return "Player2 Won.";
		
		if((a[0][1]==a[1][1]&&a[1][1]==a[2][1])||(a[1][0]==a[1][1]&&a[1][1]==a[1][2]))
				if(a[0][1]=='X')
					return "Player1 Won.";
				else
					return "Player2 Won.";
		return "No";
		
	}
	
	public static void main(String[] args){
		char[][] a=new char[3][3];
		Scanner ip=new Scanner(System.in);
		char k='1';
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				a[i][j]=k++;
		
		System.out.println("Welcome to GameTicTokToe...");

		display(a);
		boolean flag=true,p1=true,p2=true;
		while(flag){
			if(p1==true){
				System.out.println("Player1 : ");
				char s=ip.next().charAt(0);
				boolean result=add(s,a,'X');
				if(result==true){
					p1=false;
					p2=true;
					
				}
				else
				{
					p1=true;
					p2=false;
					System.out.println("Choose valid space");
				}
				display(a);
				
					
				if(winner(a)!="No")	{
					System.out.println("-------Congratulations "+winner(a)+"------");
					
					break;
				}
				if(check(a)==false){
					System.out.println("-------Congratulations Player 2 Won------");
					break;
				}
			}
			if(p2==true){
				System.out.println("Player2 : ");
				char s=ip.next().charAt(0);
				boolean result=add(s,a,'0');
				if(result==true){
					p2=false;
					p1=true;
					
				}
				else
				{
					p1=true;
					p2=false;
					System.out.println("Choose valid space");
				}
				display(a);
				if(winner(a)!="No")	{
					System.out.println("-------Congratulations "+winner(a)+"------");
					
					break;
				}
			}
			flag=check(a);
			
			
		}

	}
}
