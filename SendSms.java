import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;

public class SendSms {
	
	public static void sendSms(String message,String number)
	{
//		System.out.println(message);
//		System.out.println(number);
		try
		{
		
			String apiKey="UgkqhVvDXeriNJaHO96LWoxn43P7GsKIdTS1Q0cEu2wYRybmfp0BqoDH4CwGuXmyKz8jItZiEdfR1Uxh";
			String sendId="FSTSMS";
		//important step...

		message=URLEncoder.encode(message, "UTF-8");
		String language="english";
		
		String route="p";
		
		
		String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		
		//sending get request using java..
		
		URL url=new URL(myUrl);
		
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		//System.out.println("Wait.............."+myUrl);
		
		int code=con.getResponseCode();
			//	System.out.println("Wait.1.............");

		System.out.println("Response code : "+code);
		
		StringBuffer response=new StringBuffer();
			//	System.out.println("Wait........2......");

		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			//	System.out.println("Wait.........3.....");

		while(true)
		{
			String line=br.readLine();
			if(line==null)
			{
				break;
			}
			response.append(line);
		}
		
		System.out.println(response);
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
public static void main(String[] args)
 {
		int otp=(int)(Math.random()*1000000);
				SendSms.sendSms("Dear Sandeep,Please clear your dues.Last Date 12-12-2020.Dues-12.000/-. If paid please ignore it.IAIT VNS"+otp, "9026569055");
			//	8329417970
			//}
		
		
	}
}
