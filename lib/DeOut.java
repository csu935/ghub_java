package lib;

public class DeOut {
	
	public static void show(Object o){
		//System.out.println(o.getClass());
		System.out.println((String)o.toString());
	}
	public static void dispSList(String[] a){
		if(a.length==1){
			DeOut.show("{"+a[0]+"}");
			return;
		}
		
		String out = "";
		String comma = ",";
		for(int i=0;i<a.length;i++){
			if(i==a.length-1) out += a[i]+"}";
			else if(i==0) out += "{" + a[i]+comma;
			else out += a[i]+comma;
		}
		DeOut.show(out);
	}
	public static void dispNList(int[] a){
		if(a.length==1){
			DeOut.show("{"+a[0]+"}");
			return;
		}
		String out = "";
		String comma = ",";
		for(int i=0;i<a.length;i++){
			if(i==a.length-1) out += a[i]+"}";
			else if(i==0) out += "{" + a[i]+comma;
			else out += a[i]+comma;
		}
		DeOut.show(out);
	}
	public static void disp(Object o){
		DeOut.show(o);
	}

}
