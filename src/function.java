import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class function {
	public void GiuXe() {
		try {
			FileReader f1= new FileReader("input1.txt");
			BufferedReader r1= new BufferedReader(f1);
			FileReader f2= new FileReader("input2.txt");
			BufferedReader r2= new BufferedReader(f2);
			FileWriter f3= new FileWriter("output.txt");
			PrintWriter o= new PrintWriter(f3);
			SimpleDateFormat f= new SimpleDateFormat("HH:mm dd/MM/yyyy");
			
			while(true) {
				String st1=r1.readLine();
				if(st1==""||st1==null) break;
				String[] ds1=st1.split("[;]");
				String st2=r2.readLine();
				if(st2==""||st2==null) break;
				String[] ds2=st2.split("[;]");
				Date d1=f.parse(ds1[3]);
				Date d2=f.parse(ds2[3]);
				long dif= d2.getTime()-d1.getTime();
				double bike = dif/86400000.0;
				if (ds1[0].equals("4")) {
					long car = (long) (Math.ceil(dif/1800000.0))*2500;
					String tien= Long.toString(car);
					if(!ds2[4].equalsIgnoreCase("Binh thuong")||!ds2[4].equalsIgnoreCase("Not Nvailable"))
						o.println(ds1[0]+";"+ds1[1]+";"+ds1[2]+";"+ds1[3]+";"+ds2[3]+";"+tien);
					else o.println(ds1[0]+";"+ds1[1]+";"+ds1[2]+";"+ds1[3]+";"+ds2[3]+";"+tien);
				}
				else if (ds1[0].equals("2")) {
					long motor = (long) (Math.ceil(bike))*3000;
					String tien = Long.toString(motor);
					o.println(ds1[0]+";"+ds1[1]+";"+ds1[2]+";"+ds1[3]+";"+ds2[3]+";"+tien);
				}
				else {
					long dap = (long) (Math.ceil(bike))*1000;
					String tien = Long.toString(dap);
					o.println(ds1[0]+";"+ds1[1]+";"+ds1[2]+";"+ds1[3]+";"+ds2[3]+";"+tien);
				}
			}
			r1.close();
			r2.close();
			o.close();
		}catch(Exception tt) {
			System.out.println("Loi:"+ tt.getMessage());
		}
	}
}
