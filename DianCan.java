package cn.kgc.diancan;

import java.util.Scanner;

public class DianCan {

	public static void main(String[] args) {
		Scanner str=new Scanner(System.in);
		String[] names=new String[5];//����������
		String[] address=new String[5];//���͵�ַ
		String[] menu=new String[5];//������Ϣ
		int[] time=new int[5];//�Ͳ�ʱ��
		double[] money=new double[5];//�ܽ��
		boolean[] state=new boolean[5];// true ��������ɣ� false������Ԥ��
		
		String[] dishname={"���˼���","������˿","��������"};//��Ʒ��
		double[] price={12,14,16};//����
		int[] praise=new int[3];//����
		
		do{
			System.out.println("****************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("****************************");
			System.out.print("��ѡ��");
			int num=str.nextInt();
			switch(num){
			case 1:
				System.out.println("**************��Ҫ����**************");
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						System.out.println("������������");
						names[i]=str.next();
						System.out.println("���\t����\t����\t����");
						for(int j=0;j<dishname.length;j++){
							System.out.println((j+1)+"\t"+dishname[j]+"\t"+price[j]+"\t"+praise[j]+"��");
						}
						System.out.println("�������Ʒ��");
						int xzcp=str.nextInt();
						System.out.println("��������Ҫ�Ĳͷ�����");
						int deal=str.nextInt();
						menu[i]=dishname[xzcp-1]+" "+deal+"��";
						money[i]=price[xzcp-1]*deal;
						if(money[i]>=50){
							money[i]=price[xzcp-1]*deal;
						}else{
							money[i]=price[xzcp-1]*deal+6;
						}
						System.out.println("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ�:");
						
						time[i]=str.nextInt();
						while(time[i]!=0){
							if(time[i]>=10&&time[i]<=20){
								break;
							}else{
								System.out.println("������10����20����ʱ��");
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
						System.out.print("�������Ͳ͵�ַ��");
						address[i]=str.next();
						state[i]=false;
						break;
					}
				}	
				break;
			case 2:
				System.out.println("**************�鿴�ʹ�**************");
				System.out.println("�����ͺ� ������ �����Ʒ��Ϣ �Ͳ�ʱ�� �Ͳ͵�ַ\t�ܽ��\t����״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String bo= state[i]==true? "�����":"��Ԥ��";
						System.out.println((i+1)+"\t"+names[i]+"\t"+menu[i]+"\t"+time[i]+"\t"+address[i]+"\t"+money[i]+"\t"+bo);
					}
				}
				break;	
			case 3:
				System.out.println("**************ǩ�ն���**************");
				System.out.println("�����ͺ� ������ �����Ʒ��Ϣ �Ͳ�ʱ�� �Ͳ͵�ַ\t�ܽ��\t����״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String bo= state[i]==true? "�����":"��Ԥ��";
						System.out.println((i+1)+"\t"+names[i]+"\t"+menu[i]+"\t"+time[i]+"\t"+address[i]+"\t"+money[i]+"\t"+bo);
					}
				}
				System.out.println("������Ҫǩ�յĶ���(���������еĶ���)��");
				int id=str.nextInt();
				while(names[id-1]!=null){
					if(names[id-1]!=null){
						state[id-1]=true;
						break;
					}else{
						while(names[id-1]!=null){
							System.out.println("����ȷ����Ҫǩ�յĶ�����");
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
				System.out.println("**************ɾ������**************");
				System.out.println("�����ͺ� ������ �����Ʒ��Ϣ �Ͳ�ʱ�� �Ͳ͵�ַ\t�ܽ��\t����״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String bo= state[i]==true? "�����":"��Ԥ��";
						System.out.println((i+1)+"\t"+names[i]+"\t"+menu[i]+"\t"+time[i]+"\t"+address[i]+"\t"+money[i]+"\t"+bo);
					}
				}
				System.out.println("��������Ҫɾ���Ķ�����");
				id= str.nextInt();
				while(names[id-1]!=null){
					if(state[id-1]==true){
						names[id-1]=null;
						break;
					}else if(state[id-1]!=true){
						System.out.println("��Ķ���δ��ɣ���ǩ�պ���ɾ����");
							break;
					}else{
						System.out.println("������Ķ��������ڣ�");
					break;
					}
				}
				break;	
			case 5:
				System.out.println("**************��Ҫ����**************");
				System.out.println("���\t����\t����\t����");
				for(int j=0;j<dishname.length;j++){
					System.out.println((j+1)+"\t"+dishname[j]+"\t"+price[j]+"\t"+praise[j]+"��");
				}
				System.out.println("��������Ҫ���޵Ĳ�Ʒ�ţ�");
				id=str.nextInt();
				praise[id-1]++;
				break;	
			case 6:
				System.out.println("**************�˳�ϵͳ**************");
				System.out.println("��ӭ�´ι��٣�");
				System.exit(0); //�˳������
				
			default:
				System.out.println("������������������");
				break;
			}
		}while(true);
		

	}

}
