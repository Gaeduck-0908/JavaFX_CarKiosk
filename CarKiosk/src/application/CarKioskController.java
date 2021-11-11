package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CarKioskController implements Initializable 
{
	@FXML Button btnSpark,btnMorning;
	@FXML Button btn1Order,btn1Cancel;
	@FXML TextArea txtOrder;
	@FXML Label lblamount;
	
	public int sum = 0;
	private String[] Car1 = {"Spark","Morning"};
	private int[] countm = new int [2];
	
	private amountmodel model = new amountmodel();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		for(int i = 0; i<2; i++)
		{
			countm[i] = 0;
		}
	}
	
	public void menuAppend()
	{
		txtOrder.setText("");
		for(int i = 0; i<2; i++)
		{
			if(countm[i] != 0)
			{
				txtOrder.appendText(Car1[i] + " " + countm[i] + "´ë"+"\n");
			}
		}
	}
	
	public void btnSparkAction(ActionEvent event)
	{
		countm[0]++;
		menuAppend();
	}
	
	public void btnMorningAction(ActionEvent event)
	{
		countm[1]++;
		menuAppend();
	}
	
	public void btn1OrderAction(ActionEvent event)
	{
		DecimalFormat df = new DecimalFormat("#,###");
		sum = model.asum(countm);
		lblamount.setText(df.format(sum));
	}
	
	public void btn1CancelAction(ActionEvent event)
	{
		for(int i = 0 ; i<2; i++)
		{
			countm[i] = 0;
		}
		txtOrder.setText("");
		lblamount.setText("");
	}
}