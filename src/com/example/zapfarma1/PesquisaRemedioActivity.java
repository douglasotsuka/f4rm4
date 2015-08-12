package com.example.zapfarma1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.util.Log;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PesquisaRemedioActivity extends MainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pesquisa_remedio);
		
		
		Button button = (Button) findViewById(R.id.button2);
		final EditText textRemedio = (EditText) findViewById(R.id.editText1);
		
		
		button.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				String busca;
				busca= textRemedio.getText().toString();
				
				try {
					BuscaRemedio(busca);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (java.sql.SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pesquisa_remedio, menu);
		return true;
	}
	
	public void BuscaRemedio (String busca) throws ClassNotFoundException, SQLException, java.sql.SQLException {
		 Statement st;
		 ResultSet rs;
		 List <Remedios> Resultado;
		 Connection conn = null;
		 String sql;
		 FabricaConexao Bd = new FabricaConexao();
		 final EditText textResultado = (EditText) findViewById(R.id.editText2);
		 
		 //Lista de objetos
		 Resultado = new ArrayList<Remedios>();
		 
		 conn=Bd.getConexato();
		 st=conn.createStatement();
		 sql="SELECT * FROM REMEDIOS WHERE NOME_REMEDIO \""+busca+"\"";
         rs=st.executeQuery(sql);
         Log.d("Douglas", rs.toString());
         textResultado.setText(rs.getString(1));
         
		 
		 
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
