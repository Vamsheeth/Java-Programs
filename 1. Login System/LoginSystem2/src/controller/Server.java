package controller;

import model.Service;

import java.io.IOException;
import java.net.ServerSocket;

public class Server
{
	public static void main(String [] args)
	{
		try(ServerSocket serversocket = new ServerSocket(4040))
		{

			while(true)
			{
				Service service = new Service(serversocket.accept());
				service.start();
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("controller.Client Disconnected");
	}
}