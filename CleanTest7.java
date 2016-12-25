
/**
 * 		题目练习
 * 
 * 
 * 
 * *
 */

import java.util.Scanner;

public class CleanTest7 {

	public static void main(String[] args) 
	{

        /**
         *
         *    输入一个任意整数 计算它各个位上数字的和
         *
         *
         */

//		Class1.test();

		
		/**
		 * 
		 *    输入一个任意整数 计算它各个位上数字的和
		 * 
		 *
		 */
//		Class2.test();
		
		
		/**
		 * 
		 * 		费波那契数列  0 1 1 2 3 5 8
		 * *
		 */

//		Class3.test();
		
		
		/**
		 * 
		 * 			数组扩容后修改 输出
		 * *
		 */

//		Class4.test();
		
		
		/***
		 * 			八皇后 8*8 棋盘放8个皇后  横竖斜都不能同时有两个
		 * 
		 * 
		 */
		 Test5.test();
		
	}
	
	
	/**
	 * 
	 *    输入一个任意整数 计算它各个位上数字的和
	 * 
	 *
	 */
	static class Class1
	{
		public static void test()
		{
			while (true)
			{

				System.out.println("请输入任意一个整数：");
				Scanner s = new Scanner(System.in);
				
				int a = 0 ;
				
				Exception exception = null ;
				
				try {
					
					a = s.nextInt();

				} catch (Exception e) {
					
					System.out.println("－－－－－－－－");

					exception = e ;
					
					break ;
				}finally
				{
					if( null != exception)
					{
						s.close();
					}
				}
				
				
				
				if(a<0)
				{
					a *=-1 ;
				}
				
				System.out.println("此整数各个位上的和为："+sumTemp(a));
			}
		}
		
		public static int sumTemp (int a)
		{
			if(a<10)
			{
				return a ;
			}else 
			{
				
				return a%10 + sumTemp(a/10);
			}
			
		}
	}
	
	
	/**
	 * 
	 * 		计算圆周率
	 * *
	 */
	
	static class Class2
	{
		public static void test()
		{
			System.out.println("－－－－－－－－");

			int i = 1 ;
			double sum = 4.0/1 ;
			while(true)
			{
				
				sum += 4.0D/(1+2*i)* (i%2 == 0 ? 1 : -1);
				if(sum > 3.1415926 && sum < 3.1415927)
				{
					break ;
				}
//				System.out.println(sum + "\t"+i);

				i++ ;
			}
			

			System.out.println("圆周率值："+sum + "\t"+"运算次数："+i);
			
			System.out.println("－－－－－－－－");

		}
		
		
	}

	/**
	 * 
	 * 		费波那契数列
	 * *
	 */
	static class Class3
	{
		public static void test ()
		{
			System.out.println("－－－－－－－－");
			while (true)
			{

				System.out.println("请输入任意一个整数：");
				Scanner s = new Scanner(System.in);

				int a = 0 ;
				
				Exception exception = null ;
				
				try {
					
					a = s.nextInt();

				} catch (Exception e) {
					System.out.println("－－－－－－－－");
					
					exception = e ;
					
					break ;
				}finally
				{
					if( null != exception )
					{
						s.close();
					}
				}
								
				System.out.println("此整数各个位上的和为："+sum(a));
			}
			
		}
		
		public static int sum(int n)
		{
			if(1 == n)
			{
				return 0 ;
			}else if(2 == n)
			{
				return 1 ;
			}else
			{
				return sum(n-1)+sum(n-2);
			}
		}
	}
	
	
	/**
	 * 
	 * 			数组扩容后修改 输出
	 * *
	 */
	static class Class4
	{
		public static void test()
		{
			int [] a = {1,2,3,4,5};
			
			expend(a);
			
			changeArray(a);
			
			printArray(a);
		}
		
		static void expend(int[]a)
		{
			int [] b = new int[a.length*2];
			System.arraycopy(a, 0, b, 0	, a.length);
			a = b;
		}
		
		static void changeArray(int []a)
		{
			a[0] = 10 ;
		}
		
		static void printArray(int []a)
		{
			for(int i = 0 ; i < a.length ; i++)
			{
				System.out.print(a[i]+"\t"+i+"\t");
				System.out.println();

			}
		}
		
	}
	
	
	/***
	 * 			八皇后 8*8 棋盘放8个皇后  横竖斜都不能同时有两个
	 * 
	 * 			一个8个元素的数组存放每行的位置信息  然后排除冲突的
	 */

	 static class Test5
	{
		 private static int runCount = 0 ;
		static void test()
		{
			int maxCount = 8 ;
			int [] a = new int[maxCount];
			
			function(0, maxCount, a);
			
		}
		
		/***
		 * 
		 * @param i  表示第几行
		 * @param max 表示最大行
		 * @param a  表示存储的位置信息  8个元素 8行  下标是行  元素是列
		 */
		static void function(int i, int max ,int[]a)
		{
			for(int j = 0 ; j < max; j++)
			{
				a[i] = j ;
				
				if( 0 == i)
				{
					function(i+1, max, a);
				}else
				{
					if(!meet(a,i+1))
					{

						continue ;
					}
					

					if(i == max-1)
					{
						//输出
						print(a);
					}else
					{

						function(i+1,max,a);
						
					}
					
				}
				

			}
		}
		
		/***
		 * 	判断数据内最后一行的位置信息是否符合条件 （每添加一个就判断一次 所以每次只判断最后一个）
		 *  返回值表示是否符合
		 *
		 * @param a   
		 * @return
		 */
		static boolean meet(int []a,int valid)
		{			
			for (int i = 0; i < valid-1; i++)
			{
				if(!meetTwoData(valid-1, a[valid-1], i, a[i]))
				{
					return false ;
				}
			}
			
			return true ;
		}
		
		/***
		 * 
		 * @param i  第一个位置的行
		 * @param j  第一个位置的列
		 * @param a  第二个位置的行
		 * @param b  第二个位置的列
		 * @return  冲突返回false 
		 */
		static boolean meetTwoData(int i,int j ,int a , int b)
		{
			if(i == a || j == b || Math.abs(i - a) == Math.abs(j - b))
			{
				return false ;
				
			}
			
			return true ;
		}
		
		
		/***
		 * 	 输出
		 */
		
		static void print(int []a)
		{
			for(int i = 0 ; i < a.length ; i++)
			{
				System.out.print(a[i]+"\t");
			}
			
			System.out.println("============"+ ++runCount);

			
		}
		
		
	}

}





