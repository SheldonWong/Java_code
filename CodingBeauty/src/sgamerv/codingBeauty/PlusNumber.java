package sgamerv.codingBeauty;

public class PlusNumber {
String str_number ="913247456475";
int plus_num =4;
int str_size =str_number.length();
long sum[][][]=new long[200][200][100];

long toNum(int start,int end){
	String temp = str_number.substring(start,end+1);
	//System.out.println(temp);
	long num = Long.parseLong(temp);
	return num;
}
long calculate(){
	int i,j,k,p,count=0;
	long minSum =0;
	long res;
	for(i=0;i<str_size;i++){
		for(j=0;j<str_size;j++){
			if(i>j)continue;
			//System.out.println("start:"+i+","+"start:"+j);
			sum[i][j][0] = toNum(i,j);
		}
	}
	
	for(k=1;k<=plus_num;k++){
		for(i=0;i<str_size;i++){
			for(j=i+k;j<str_size;j++){
				for(p=i;p<j-k+1;p++){
					count++;
					res = sum[i][p][0]+sum[p+1][j][k-1];
					System.out.println("sum["+i+"]["+p+"][0]:"+sum[i][p][0]+"###sum["+(p+1)+"]["+j+"]["+(k-1)+"]:"+sum[p+1][j][k-1]+"="+res);
					if(p==i){
						//System.out.print("p:"+p+",sum["+i+"]"+"["+j+"]"+"["+k+"]:");
						minSum = res;
						//System.out.println(res);
					}else{
						if(res<minSum){
							//System.out.print("p:"+p+",sum["+i+"]"+"["+j+"]"+"["+k+"]:");
							minSum = res;
							//System.out.println(res);
						}
					}
				}
				sum[i][j][k]=minSum;
				if(i==0&&j==str_size-1&&k==plus_num){
					System.out.println("Success!!"+sum[i][j][k]+"count:"+count);
					return res=sum[0][str_size-1][plus_num];
				}
					
			}
		}
	}
	return res=sum[0][str_size-1][plus_num];
}

public static void main(String[] args){
	PlusNumber p = new PlusNumber();
	//String num ="123456";
	//System.out.println(num.length());
	//String sub = num.substring(1, 6);
	long out = p.calculate();
	System.out.println(out);
}
}
