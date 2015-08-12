package com.example.zapfarma1;

import java.sql.Connection;
import java.sql.DriverManager;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;
public class FabricaConexao {
	private final String Endereco="jdbc:mysql://173.192.229.151:3306/orefugio_zapfarma";
	private final String User="orefugio";
	private final String Pass="site2012";
	Connection conn;  
	public class MyClass 
	{
	    Context c;
	    public MyClass(Context context)
	    {
	         c= context;
	     }
	}	 
	
	public Connection getConexato()  throws ClassNotFoundException, SQLException, java.sql.SQLException {  
	 
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = (Connection) DriverManager.getConnection(Endereco,User,Pass);  
		if (conn!=null) {
			Log.d("Douglas", "Conexão OK");
		}else {
			 //Toast.makeText(context.getApplicationContext(), "MySQL falha na conexão.", Toast.LENGTH_SHORT).show();
		}
			
			

		return conn;  
		
	}
	
	 public void desconectarMySQL(){
	        try {
	            conn.close();
	            Log.i("MYSQL","Desconectado.");
	        } catch (Exception erro) {
	            Log.e("MYSQL","Erro: "+erro);
	        }
	    }
}
