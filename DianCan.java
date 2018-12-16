package cn.kgc.diancan;

import java.util.Scanner;

public class DianCan {

	public static void main(String[] args) {
		Scanner str=new Scanner(System.in);
		String[] names=new String[5];//订餐人姓名
		String[] address=new String[5];//订餐地址
		String[] menu=new String[5];//订餐信息
		int[] time=new int[5];//送餐时间
		double[] money=new double[5];//总金额
		boolean[] state=new boolean[5];// true 代表已完成， false代表已预订
		
		String[] dishname={"黄焖鸡饭","鱼香肉丝","宫保鸡丁"};//菜品名
		double[] price={12,14,16};//单价
		int[] praise=new int[3];//点赞
		
		do{
			System.out.println("****************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("****************************");
			System.out.print("请选择：");
			int num=str.nextInt();
			switch(num){
			case 1:
				System.out.println("**************我要订餐**************");
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						System.out.println("请输入姓名：");
						names[i]=str.next();
						System.out.println("序号\t菜名\t单价\t点赞");
						for(int j=0;j<dishname.length;j++){
							System.out.println((j+1)+"\t"+dishname[j]+"\t"+price[j]+"\t"+praise[j]+"赞");
						}
						System.out.println("请输入菜品：");
						int xzcp=str.nextInt();
						System.out.println("请输入需要的餐份数：");
						int deal=str.nextInt();
						menu[i]=dishname[xzcp-1]+" "+deal+"份";
						money[i]=price[xzcp-1]*deal;
						if(money[i]>=50){
							money[i]=price[xzcp-1]*deal;
						}else{
							money[i]=price[xzcp-1]*deal+6;
						}
						System.out.println("请输入送餐时间（送餐时间是10点至20点间整点送餐）:");
						
						time[i]=str.nextInt();
						while(time[i]!=0){
							if(time[i]>=10&&time[i]<=20){
								break;
							}else{
								System.out.println("请输入10点至20点间的时间");
								while(time[i]!=0){
									time[i]=str.nextInt();
									if(time[i]>=10&&time[i]<=20){
										break;
									}else{
										break;
									}
								}
								
							}
						}	
						System.out.print("请输入送餐地址：");
						address[i]=str.next();
						state[i]=false;
						break;
					}
				}	
				break;
			case 2:
				System.out.println("**************查看餐袋**************");
				System.out.println("订单餐号 订餐人 具体餐品信息 送餐时间 送餐地址\t总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String bo= state[i]==true? "已完成":"已预定";
						System.out.println((i+1)+"\t"+names[i]+"\t"+menu[i]+"\t"+time[i]+"\t"+address[i]+"\t"+money[i]+"\t"+bo);
					}
				}
				break;	
			case 3:
				System.out.println("**************签收订单**************");
				System.out.println("订单餐号 订餐人 具体餐品信息 送餐时间 送餐地址\t总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String bo= state[i]==true? "已完成":"已预定";
						System.out.println((i+1)+"\t"+names[i]+"\t"+menu[i]+"\t"+time[i]+"\t"+address[i]+"\t"+money[i]+"\t"+bo);
					}
				}
				System.out.println("请输入要签收的订单(请输入已有的订单)：");
				int id=str.nextInt();
				while(names[id-1]!=null){
					if(names[id-1]!=null){
						state[id-1]=true;
						break;
					}else{
						while(names[id-1]!=null){
							System.out.println("请正确输入要签收的订单：");
							id=str.nextInt();
							if(names[id-1]!=null){
								state[id-1]=true;
								break;
							}else{
								id=str.nextInt();
								continue;
							}
						}
					}
				}
				break;	
			case 4:
				System.out.println("**************删除订单**************");
				System.out.println("订单餐号 订餐人 具体餐品信息 送餐时间 送餐地址\t总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String bo= state[i]==true? "已完成":"已预定";
						System.out.println((i+1)+"\t"+names[i]+"\t"+menu[i]+"\t"+time[i]+"\t"+address[i]+"\t"+money[i]+"\t"+bo);
					}
				}
				System.out.println("请输入你要删除的订单：");
				id= str.nextInt();
				while(names[id-1]!=null){
					if(state[id-1]==true){
						names[id-1]=null;
						break;
					}else if(state[id-1]!=true){
						System.out.println("你的订单未完成，请签收后再删除！");
							break;
					}else{
						System.out.println("你输入的订单不存在：");
					break;
					}
				}
				break;	
			case 5:
				System.out.println("**************我要点赞**************");
				System.out.println("序号\t菜名\t单价\t点赞");
				for(int j=0;j<dishname.length;j++){
					System.out.println((j+1)+"\t"+dishname[j]+"\t"+price[j]+"\t"+praise[j]+"赞");
				}
				System.out.println("请输入你要点赞的菜品号：");
				id=str.nextInt();
				praise[id-1]++;
				break;	
			case 6:
				System.out.println("**************退出系统**************");
				System.out.println("欢迎下次光临！");
				System.exit(0); //退出虚拟机
				
			default:
				System.out.println("输入有误，请重新输入");
				break;
			}
		}while(true);
		

	}

}
