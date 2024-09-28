import java.io.*;
import java.net.*;
import java.util.*;
public class RestClient 
{
  public static void main(String []args)
  {
    try
    {
	URL url = new URL("http://localhost:8080/demo/m1");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	if(conn.getResponseCode()!=200)
	{
		throw new RuntimeException("Failed:statusCode "+conn.getResponseCode());
	}
	BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String response=br.readLine();
	while(response!=null)
	{
		System.out.println(response);
		response=br.readLine();
	}
	System.out.println("Status code:"+conn.getResponseCode());
	conn.disconnect();
     }
     catch(Exception ex)
     {
	 System.out.println(ex);
     }
  }
}
