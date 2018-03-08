package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
	public String loginAuth(String requestString)
	{
		try(Socket socket = new Socket("localhost",4040))
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

			String responseString;

			while (true)
			{
				out.println(requestString);

				if(requestString!=null || !requestString.equals(""))
				{
					responseString = in.readLine();
					return responseString;
				}
			}
		}
		catch(Exception e)
		{
			return "ERROR";
		}
	}
}