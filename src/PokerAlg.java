public class PokerAlg {
	public CardInfo Hold_Card[]=new CardInfo [2];
	public CardInfo Best_Five_Card[]=new CardInfo [5];
	public CardInfo temp[]=new CardInfo [7];
	
	PokerAlg()
	{
		for(int i=0;i<7;i++)
		{
			this.temp[i]=new CardInfo ();
		}
		for(int i=0;i<5;i++)
		{
			this.Best_Five_Card[i]=new CardInfo ();
		}
		for(int i=0;i<2;i++)
		{
			this.Hold_Card[i]=new CardInfo ();
		}
	}

	void displayCard(CardInfo T[],int n)
	{
		for(int i=0;i<n;i++)
		{
			if(T[i].color==0)
			{
				if(T[i].point==1)
				System.out.println("红桃"+" "+"A"+" ");
				else if(T[i].point==11)
				System.out.println("红桃"+" "+"J"+" ");
				else if(T[i].point==12)
				System.out.println("红桃"+" "+"Q"+" ");
				else if(T[i].point==12)
				System.out.println("红桃"+" "+"K"+" ");
				else
				System.out.println("红桃"+" "+T[i].point+" ");
			}
			if(T[i].color==1)
			{
				if(T[i].point==1)
				System.out.println("方片"+" "+"A"+" ");
				else if(T[i].point==11)
				System.out.println("方片"+" "+"J"+" ");
				else if(T[i].point==12)
				System.out.println("方片"+" "+"Q"+" ");
				else if(T[i].point==12)
				System.out.println("方片"+" "+"K"+" ");
				else
				System.out.println("方片"+" "+T[i].point+" ");
			}
			if(T[i].color==2)
			{
				if(T[i].point==1)
				System.out.println("黑桃"+" "+"A"+" ");
				else if(T[i].point==11)
				System.out.println("黑桃"+" "+"J"+" ");
				else if(T[i].point==12)
				System.out.println("黑桃"+" "+"Q"+" ");
				else if(T[i].point==12)
				System.out.println("黑桃"+" "+"K"+" ");
				else
				System.out.println("黑桃"+" "+T[i].point+" ");
			}
			if(T[i].color==3)
			{
				if(T[i].point==1)
				System.out.println("梅花"+" "+"A"+" ");
				else if(T[i].point==11)
				System.out.println("梅花"+" "+"J"+" ");
				else if(T[i].point==12)
				System.out.println("梅花"+" "+"Q"+" ");
				else if(T[i].point==12)
				System.out.println("梅花"+" "+"K"+" ");
				else
				System.out.println("梅花"+" "+T[i].point+" ");
			}
		}
	}
	void sort(CardInfo Five_Card[])
	{
	    CardInfo temp=new CardInfo();
	    for(int i=0;i<5;i++)
	    {
	        for(int j=0;j<4-i;j++)
	        {
	            if(Five_Card[j].point>Five_Card[j+1].point)
	            {
	                temp.color=Five_Card[j].color;
	                Five_Card[j].color=Five_Card[j+1].color;
	                Five_Card[j+1].color=temp.color;
	                temp.point=Five_Card[j].point;
	                Five_Card[j].point=Five_Card[j+1].point;
	                Five_Card[j+1].point=temp.point;
	            }
	        }
	    }
	}
	
	public int judge(CardInfo Five_Card[])//同花顺 4条 葫芦 同花 顺子 3 2 1 高牌
	{
	    int howbig=0;
	    //int flag=0;
	    sort(Five_Card);//排序

	    if((Five_Card[0].color==Five_Card[1].color&&Five_Card[1].color==Five_Card[2].color&&Five_Card[2].color==Five_Card[3].color&&Five_Card[3].color==Five_Card[4].color)&&((Five_Card[0].point+1==Five_Card[1].point&&Five_Card[1].point+1==Five_Card[2].point&&Five_Card[2].point+1==Five_Card[3].point&&Five_Card[3].point+1==Five_Card[4].point) ||
	                                                                                                                                                                  (Five_Card[0].point==1&&Five_Card[1].point==10&&Five_Card[2].point==11&&Five_Card[3].point==12&&Five_Card[4].point==13)))//同花顺
	        howbig=9;//同花顺
	    else if((Five_Card[0].point==Five_Card[1].point&&Five_Card[1].point==Five_Card[2].point&&Five_Card[2].point==Five_Card[3].point)||(Five_Card[4].point==Five_Card[1].point&&Five_Card[1].point==Five_Card[2].point&&Five_Card[2].point==Five_Card[3].point))//四条
	        howbig=8;//四条
	    else if((Five_Card[0].point==Five_Card[1].point&&Five_Card[1].point==Five_Card[2].point&&Five_Card[4].point==Five_Card[3].point)||(Five_Card[2].point==Five_Card[3].point&&Five_Card[3].point==Five_Card[4].point&&Five_Card[0].point==Five_Card[1].point))
	        howbig=7;//葫芦
	    else if((Five_Card[0].color==Five_Card[1].color&&Five_Card[1].color==Five_Card[2].color&&Five_Card[2].color==Five_Card[3].color&&Five_Card[3].color==Five_Card[4].color)&&(Five_Card[0].point+1!=Five_Card[1].point||Five_Card[1].point+1!=Five_Card[2].point||Five_Card[2].point+1!=Five_Card[3].point||Five_Card[3].point+1==Five_Card[4].point))//同花顺
	        howbig=6;//考虑同花的时候不必考虑是顺子，考虑顺子的时候不必考虑是同花
	    else if((Five_Card[0].point+1==Five_Card[1].point&&Five_Card[1].point+1==Five_Card[2].point&&Five_Card[2].point+1==Five_Card[3].point&&Five_Card[3].point+1==Five_Card[4].point) ||(Five_Card[0].point==1&&Five_Card[1].point==10&&Five_Card[2].point==11&&Five_Card[3].point==12&&Five_Card[4].point==13))
	        howbig=5;//顺子
	    else if((Five_Card[0].point==Five_Card[1].point&&Five_Card[1].point==Five_Card[2].point)||(Five_Card[2].point==Five_Card[3].point&&Five_Card[1].point==Five_Card[2].point)||(Five_Card[2].point==Five_Card[3].point&&Five_Card[3].point==Five_Card[4].point))
	        howbig=4;//三条
	    else if((Five_Card[0].point==Five_Card[1].point&&Five_Card[3].point==Five_Card[4].point)||(Five_Card[0].point==Five_Card[1].point&&Five_Card[2].point==Five_Card[3].point)||(Five_Card[1].point==Five_Card[2].point&&Five_Card[3].point==Five_Card[4].point))
	        howbig=3;//两对
	    else if((Five_Card[0].point==Five_Card[1].point)||(Five_Card[2].point==Five_Card[1].point)||(Five_Card[2].point==Five_Card[3].point)||(Five_Card[3].point==Five_Card[4].point))
	        howbig=2;
	    else//高牌
	        howbig=1;
	    return howbig;
	}
	
	public CardInfo[] judgebest(CardInfo [] allcard,CardInfo [] bestcard)
	{
	    CardInfo temp[]=new CardInfo [5];
	    for(int i=0;i<5;i++)
	    {
	    	temp[i]=new CardInfo();
	    }
	    int a[]=new int[21];

//	    allcard[0].point=0;//测试用的
//	    allcard[0].color=1;
//	    allcard[1].point=12;
//	    allcard[1].color=1;
//	    allcard[2].point=7;
//	    allcard[2].color=1;
//	    allcard[3].point=2;
//	    allcard[3].color=3;
//	    allcard[4].point=9;
//	    allcard[4].color=1;
//	    allcard[5].point=11;
//	    allcard[5].color=1;
//	    allcard[6].point=10;
//	    allcard[6].color=1;
//	    cout<<"allcard:::::   ";
//	    for(int i=0;i<7;i++)
//	    showCardName(allcard[i]);
//	    cout<<endl;
	    allcard[0].color=1;
	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[2].color;
	    temp[2].point=allcard[2].point;
	    temp[3].color=allcard[3].color;
	    temp[3].point=allcard[3].point;
	    temp[4].color=allcard[4].color;
	    temp[4].point=allcard[4].point;
	    a[0]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[2].color;
	    temp[2].point=allcard[2].point;
	    temp[3].color=allcard[3].color;
	    temp[3].point=allcard[3].point;
	    temp[4].color=allcard[5].color;
	    temp[4].point=allcard[5].point;
	    a[1]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[2].color;
	    temp[2].point=allcard[2].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[5].color;
	    temp[4].point=allcard[5].point;
	    a[2]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[5].color;
	    temp[4].point=allcard[5].point;
	    a[3]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[5].color;
	    temp[4].point=allcard[5].point;
	    a[4]=judge(temp);

	    temp[0].color=allcard[1].color;
	    temp[0].point=allcard[1].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[5].color;
	    temp[4].point=allcard[5].point;
	    a[5]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[2].color;
	    temp[2].point=allcard[2].point;
	    temp[3].color=allcard[3].color;
	    temp[3].point=allcard[3].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[6]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[2].color;
	    temp[2].point=allcard[2].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[7]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[8]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[9]=judge(temp);

	    temp[0].color=allcard[1].color;
	    temp[0].point=allcard[1].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[4].color;
	    temp[3].point=allcard[4].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[10]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[2].color;
	    temp[2].point=allcard[2].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[11]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[12]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[13]=judge(temp);

	    temp[0].color=allcard[1].color;
	    temp[0].point=allcard[1].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[3].color;
	    temp[2].point=allcard[3].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[14]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[1].color;
	    temp[1].point=allcard[1].point;
	    temp[2].color=allcard[4].color;
	    temp[2].point=allcard[4].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[15]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[4].color;
	    temp[2].point=allcard[4].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[16]=judge(temp);

	    temp[0].color=allcard[1].color;
	    temp[0].point=allcard[1].point;
	    temp[1].color=allcard[2].color;
	    temp[1].point=allcard[2].point;
	    temp[2].color=allcard[4].color;
	    temp[2].point=allcard[4].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[17]=judge(temp);

	    temp[0].color=allcard[0].color;
	    temp[0].point=allcard[0].point;
	    temp[1].color=allcard[3].color;
	    temp[1].point=allcard[3].point;
	    temp[2].color=allcard[4].color;
	    temp[2].point=allcard[4].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[18]=judge(temp);

	    temp[0].color=allcard[1].color;
	    temp[0].point=allcard[1].point;
	    temp[1].color=allcard[3].color;
	    temp[1].point=allcard[3].point;
	    temp[2].color=allcard[4].color;
	    temp[2].point=allcard[4].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[19]=judge(temp);

	    temp[0].color=allcard[2].color;
	    temp[0].point=allcard[2].point;
	    temp[1].color=allcard[3].color;
	    temp[1].point=allcard[3].point;
	    temp[2].color=allcard[4].color;
	    temp[2].point=allcard[4].point;
	    temp[3].color=allcard[5].color;
	    temp[3].point=allcard[5].point;
	    temp[4].color=allcard[6].color;
	    temp[4].point=allcard[6].point;
	    a[20]=judge(temp);

	    int m=a[0];

	    for(int i=0;i<20;i++)
	    {
	        if(a[i+1]>a[m])
	            m=i+1;
	    }

//	    for(int i=0;i<21;i++)//for test
//	        cout<<a[i]<<" ";
//	    cout<<endl;
//	    cout<<a[m]<<endl;
	    CardInfo temp1=new CardInfo(-1,-1,-1);//将allcard的七张牌大小排序

	    for(int i=0;i<7;i++)
	    {
	        for(int j=0;j<6-i;j++)
	        {
	            if((allcard[j+1].point!=0&&(allcard[j].point>allcard[j+1].point))||(allcard[j].point==0&&allcard[j+1].point!=0))
	            {
	                temp1.color=allcard[j].color;
	                allcard[j].color=allcard[j+1].color;
	                allcard[j+1].color=temp1.color;
	                temp1.point=allcard[j].point;
	                allcard[j].point=allcard[j+1].point;
	                allcard[j+1].point=temp1.point;
	            }
	        }
	    }
//	    cout<<"allcard: ";
//	    for(int i=0;i<7;i++)
//	    showCardName(allcard[i]);
//	    cout<<endl<<endl;

	    if(a[m]==1)
	    {
	        for(int i=0;i<5;i++)
	        {
	            bestcard[i].point=allcard[i+2].point;
	            bestcard[i].color=allcard[i+2].color;
	        }
	        for(int i=0;i<5;i++)

	        System.out.println(" HIGH_CARD\n");
	    }
	    if(a[m]==2)
	    {

	        for(int i=0;i<6;i++)
	        {
	            if(allcard[i].point==allcard[i+1].point)
	            {
	            allcard[i].flag=1;
	            allcard[i+1].flag=1;
	            bestcard[0].point=allcard[i].point;
	            bestcard[0].color=allcard[i].color;
	            bestcard[1].point=allcard[i+1].point;
	            bestcard[1].color=allcard[i+1].color;
	            }
	        }
	        int j=0;
	        for(int i=6;i>0;i--)
	        {
	            if(allcard[i].flag!=1&&j<3)
	            {
	                bestcard[j+2].point=allcard[i].point;
	                bestcard[j+2].color=allcard[i].color;
	                j++;
	            }
	        }
	        System.out.println(" ONE_PAIR\n");
	    }
	    if(a[m]==3)//两对
	    {
	        for(int i=6,j=0,k=0;i>0&&j<2;i--)
	        {
	            if(allcard[i].point==allcard[i-1].point)
	            {
	                bestcard[k].point=allcard[i].point;
	                bestcard[k].color=allcard[i].color;
	                bestcard[k+1].point=allcard[i-1].point;
	                bestcard[k+1].color=allcard[i-1].color;
	                allcard[i].flag=1;
	                allcard[i-1].flag=1;
	                k+=2;
	                j++;
	            }
	        }

	        for(int i=6,j=0;i>0;i--)
	        {
	            if(allcard[i].flag!=1&&j<1)
	            {
	                bestcard[j+4].point=allcard[i].point;
	                bestcard[j+4].color=allcard[i].color;
//	                showCardName(bestcard[j+4]);
	                j++;
	            }
	        }
	        System.out.println(" TOW_PAIR\n");
	    }
	    if(a[m]==4)//三条
	    {
	        for(int i=6,j=0;i>1;i--)
	        {
	            if(allcard[i].point==allcard[i-1].point&&allcard[i-1].point==allcard[i-2].point)
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                bestcard[j+1].point=allcard[i-1].point;
	                bestcard[j+1].color=allcard[i-1].color;
	                bestcard[j+2].point=allcard[i-2].point;
	                bestcard[j+2].color=allcard[i-2].color;
	                allcard[i].flag=1;
	                allcard[i-1].flag=1;
	                allcard[i-2].flag=1;
	                break;
	            }
	        }
	        for(int i=6,j=0;i>0&&j<2;i--)
	        {
	            if(allcard[i].flag!=1)
	            {
	                bestcard[j+3].point=allcard[i].point;
	                bestcard[j+3].color=allcard[i].color;
	                j++;
	            }
	        }
	        System.out.println(" THREE_OF_A_KIND\n");
	    }
	    if(a[m]==5)
	    {
	        for(int i=6,j=0;i>3;i--)
	        {
	            if((allcard[i].point==0&&allcard[i-1].point==12&&allcard[i-2].point==11&&allcard[i-3].point==10&&allcard[i-4].point==9)||((allcard[i].point==allcard[i-1].point+1)&&(allcard[i-1].point==allcard[i-2].point+1)&&(allcard[i-2].point==allcard[i-3].point+1)&&(allcard[i-3].point==allcard[i-4].point+1)))
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                bestcard[j+1].point=allcard[i-1].point;
	                bestcard[j+1].color=allcard[i-1].color;
	                bestcard[j+2].point=allcard[i-2].point;
	                bestcard[j+2].color=allcard[i-2].color;
	                bestcard[j+3].point=allcard[i-3].point;
	                bestcard[j+3].color=allcard[i-3].color;
	                bestcard[j+4].point=allcard[i-4].point;
	                bestcard[j+4].color=allcard[i-4].color;
	                break;
	            }
	        }
	        System.out.println(" STRAIGHT\n");
	    }
	    if(a[m]==6)//同花
	    {
	        int c[]=new int []{0,0,0,0};
	        for(int i=0;i<7;i++)
	        {
	            if(allcard[i].color==0)
	            c[0]++;
	            if(allcard[i].color==1)
	            c[1]++;
	            if(allcard[i].color==2)
	            c[2]++;
	            if(allcard[i].color==3)
	            c[3]++;
	        }
	        int temp2=0;
	        for(temp2=0;temp2<4;temp2++)
	        {
	            if(c[temp2]>=5)
	            break;
	        }
	        for(int i=6,j=0;i>=0&&j<5;i--)
	        {
	            if(allcard[i].color==temp2)
	            {
	                bestcard[j].color=allcard[i].color;
	                bestcard[j].point=allcard[i].point;
	                j++;
	            }
	        }

	        System.out.println(" FLUSH\n");
	    }
	    if(a[m]==7)//葫芦
	    {
	        for(int i=6,j=0;i>1;i--)
	        {
	            if(allcard[i].point==allcard[i-1].point&&allcard[i-1].point==allcard[i-2].point)
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                bestcard[j+1].point=allcard[i-1].point;
	                bestcard[j+1].color=allcard[i-1].color;
	                bestcard[j+2].point=allcard[i-2].point;
	                bestcard[j+2].color=allcard[i-2].color;
	                allcard[i].flag=1;
	                allcard[i-1].flag=1;
	                allcard[i-2].flag=1;
	                break;
	            }
	        }
	        for(int i=6,j=3;i>0;i--)
	        {
	            if(allcard[i].flag!=1&&(allcard[i-1].flag!=1)&&(allcard[i].point==allcard[i-1].point))
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                bestcard[j+1].point=allcard[i-1].point;
	                bestcard[j+1].color=allcard[i-1].color;
	                break;
	            }
	        }
	        System.out.println(" FULL_HOUSE\n");
	    }
	    if(a[m]==8)//四条
	    {
	        for(int i=6,j=0;i>2;i--)
	        {
	            if(allcard[i].point==allcard[i-1].point&&(allcard[i-1].point==allcard[i-2].point)&&(allcard[i-2].point==allcard[i-3].point))
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                bestcard[j+1].point=allcard[i-1].point;
	                bestcard[j+1].color=allcard[i-1].color;
	                bestcard[j+2].point=allcard[i-2].point;
	                bestcard[j+2].color=allcard[i-2].color;
	                bestcard[j+3].point=allcard[i-3].point;
	                bestcard[j+3].color=allcard[i-3].color;
	                allcard[i].flag=1;
	                allcard[i-1].flag=1;
	                allcard[i-2].flag=1;
	                allcard[i-3].flag=1;
	                break;
	            }
	        }
	        for(int i=6,j=4;i>=0;i--)
	        {
	            if(allcard[i].flag!=1)
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                break;
	            }
	        }
	        System.out.println(" FOUR_OF_A_KIND\n");
	    }
	    if(a[m]==9)
	    {
	        for(int i=6,j=0;i>3;i--)
	        {
	            if(((allcard[i].point==0&&allcard[i-1].point==12&&allcard[i-2].point==11&&allcard[i-3].point==10&&allcard[i-4].point==9)||((allcard[i].point==allcard[i-1].point+1)&&(allcard[i-1].point==allcard[i-2].point+1)&&(allcard[i-2].point==allcard[i-3].point+1)&&(allcard[i-3].point==allcard[i-4].point+1)))
	               &&(allcard[i].color==allcard[i-1].color)&&(allcard[i-1].color==allcard[i-2].color)&&(allcard[i-3].color==allcard[i-4].color))
	            {
	                bestcard[j].point=allcard[i].point;
	                bestcard[j].color=allcard[i].color;
	                bestcard[j+1].point=allcard[i-1].point;
	                bestcard[j+1].color=allcard[i-1].color;
	                bestcard[j+2].point=allcard[i-2].point;
	                bestcard[j+2].color=allcard[i-2].color;
	                bestcard[j+3].point=allcard[i-3].point;
	                bestcard[j+3].color=allcard[i-3].color;
	                bestcard[j+4].point=allcard[i-4].point;
	                bestcard[j+4].color=allcard[i-4].color;
	                break;
	            }
	        }
	        System.out.println(" STRAIGHT_FLUSH\n");
	    }
	    return bestcard;
	}


	public static void main(String args[]){
		PokerAlg p=new PokerAlg();

		p.temp[0].color=1;
		p.temp[0].point=1;
		p.temp[1].color=0;
		p.temp[1].point=3;
		p.temp[2].color=0;
		p.temp[2].point=5;
		p.temp[3].color=0;
		p.temp[3].point=7;
		p.temp[4].color=0;
		p.temp[4].point=9;
		p.temp[5].color=0;
		p.temp[5].point=11;
		p.temp[6].color=0;
		p.temp[6].point=12;

		p.displayCard(p.temp, 7);
		p.Best_Five_Card=p.judgebest(p.temp, p.Best_Five_Card);
		p.displayCard(p.Best_Five_Card,5);

		
//		p.diplayCard(p.temp, 7);
		
		
}
	
}


