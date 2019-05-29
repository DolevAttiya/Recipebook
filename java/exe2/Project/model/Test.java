package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0;i<4;i++)
			{
			for(int j=0;j<4;j++)
			{ 
				i=0; j=1;
				if(j!=0)
					 if(i!=3)
						 if(i==0) {i=j;}
						 else if (i!=j)
							 i=3;
				System.out.printf("father:%d,son: %d\n",i,j);
			}
			}
	}

}
