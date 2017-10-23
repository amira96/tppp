package Graphic;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Code.DifferentSizeException;
import Code.MinMax;
import Code.VectorHelper;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class MainWindowController implements Initializable{
	
	
	@FXML
	private AnchorPane Sort;
	@FXML
	private AnchorPane Sum;
	@FXML
	private AnchorPane Reverse;
	@FXML
	private AnchorPane Maxmin;
	@FXML
	private AnchorPane function;
	
	private ObservableList<AnchorPane> controls;
	
	
	@FXML
	private GridPane Tab1; 
	@FXML
	private GridPane Tab2; 
	@FXML
	private ImageView Add_Case1; 
	@FXML
	private ImageView Rem_Case1; 
	@FXML
	private ImageView Add_Case2; 
	@FXML
	private ImageView Rem_Case2; 
	private int taille1=0;
	private int taille2=0;
	
	@FXML
	private GridPane Res; 
	
	
	
	
	public void option_enter(MouseEvent enter)
	{
		Label src=((Label)((AnchorPane)enter.getSource()).getChildren().get(0));
		
		FadeTransition ft=new FadeTransition();
		ft.setNode(src);
		ft.setDuration(Duration.millis(500));
		ft.setToValue(1);
		ft.play();
	}
	public void option_exit(MouseEvent exit)
	{
		Label src=((Label)((AnchorPane)exit.getSource()).getChildren().get(0));
		
		FadeTransition ft=new FadeTransition();
		ft.setNode(src);
		ft.setDuration(Duration.millis(500));
		ft.setToValue(0);
		ft.play();
	}
	
	public void add_case1()
	{
		JFXTextField field=new JFXTextField();
		field.setPrefSize(80,60);
		field.setFont(Font.font("MV Boli", 28));
		field.getStyleClass().add("NUMFIELD");
		field.setAlignment(Pos.CENTER);


		Tab1.addColumn(taille1, field);
		taille1++;
	}
	public void rem_case1()
	{
		if (taille1!=0)
		{
			taille1--;
			Tab1.getChildren().remove(taille1);
		}
		
	}
	public void rem_case2()
	{
		if (taille2!=0)
		{
		taille2--;
		Tab2.getChildren().remove(taille2);
		}
		
	}
	
	public void add_case2()
	{
		JFXTextField field=new JFXTextField();
		field.setPrefSize(80,60);
		field.setFont(Font.font("MV Boli", 28));
		field.getStyleClass().add("NUMFIELD");
		field.setAlignment(Pos.CENTER);
		/*field.textProperty().addListener(new ChangeListener<String>() {
			  
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
		
				
				if (arg2.matches("\\d*")) {
					field.setText(arg1.replaceAll("[^\\d]", ""));
		        }
			}
		});*/
		Tab2.addColumn(taille2, field);
		taille2++;
	}
	
	
	
	VectorHelper vectorhelper=new VectorHelper();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		controls=FXCollections.observableArrayList();
		controls.addAll(Sort,Sum,Reverse,Maxmin,function);
		int i=0;
		for (i=0;i<controls.size();i++)
		{
			controls.get(i).setOnMouseEntered(enter->option_enter(enter));
			controls.get(i).setOnMouseExited(exit->option_exit(exit));
		}
		
		tab1_container.setTranslateY(50);
		mm_container.setTranslateY(-50);
		
		Add_Case1.setOnMouseEntered(enter->plus_entered(enter));
		Add_Case2.setOnMouseEntered(enter->plus_entered(enter));
		Rem_Case1.setOnMouseEntered(enter->delete_entered(enter));
		Rem_Case2.setOnMouseEntered(enter->delete_entered(enter));
		
		Add_Case1.setOnMouseExited(exit->plus_exited(exit));
		Add_Case2.setOnMouseExited(exit->plus_exited(exit));
		Rem_Case1.setOnMouseExited(exit->delete_exited(exit));
		Rem_Case2.setOnMouseExited(exit->delete_exited(exit));
		
		int k=0;
		while (k<5)
		{
			add_case1();
			add_case2();
			k++;
		}
	}
	
	public void plus_entered(MouseEvent e)
	{
		ImageView src=((ImageView)e.getSource());
		src.setImage(new Image(getClass().getResourceAsStream("/Graphic/source/ico/plus-black-symbol_hover.png")));
	}
	public void plus_exited(MouseEvent e)
	{
		
		ImageView src=((ImageView)e.getSource());
		src.setImage(new Image(getClass().getResourceAsStream("/Graphic/source/ico/plus-black-symbol.png")));
	}
	public void delete_entered(MouseEvent e)
	{
		ImageView src=((ImageView)e.getSource());
		src.setImage(new Image(getClass().getResourceAsStream("/Graphic/source/ico/backspace_hover.png")));
	}
	public void delete_exited(MouseEvent e)
	{
		ImageView src=((ImageView)e.getSource());
		src.setImage(new Image(getClass().getResourceAsStream("/Graphic/source/ico/backspace.png")));
	}
	
	
	
	
	@FXML
	private AnchorPane tab1_container;
	@FXML
	private AnchorPane tab2_container;
	@FXML
	private AnchorPane res_container;
	@FXML
	private AnchorPane mm_container;
	@FXML
	private AnchorPane sum_container;
	@FXML
	private Label err_msg;
	
	
	int[] Remplir_tab()
	{
		int vect[]=new int[taille1];
		int i=0;String m;
		for (i=0;i<taille1;i++)
		{
			m=((JFXTextField)Tab1.getChildren().get(i)).getText();
			if (m!="") vect[i]=Integer.parseInt(m);
			else vect[i]=0;
			
		}
		return vect;
	}
	
	public void Remplir_Res(int []vect)
	{
		int j=0;
		for (j=0;j<taille1;j++)
		{
			Label r=new Label();
			r.setFont(Font.font("Maiandra GD",30));
			r.setAlignment(Pos.CENTER);
			r.getStyleClass().add("RESLABEL");
			r.setText(""+vect[j]);
			
			
			r.setPrefSize(80, 65);
			Res.addColumn(j, r);
		}
	}
	
	
	public void Trier()
	{
		int  []vect=vectorhelper.Tri(Remplir_tab());
		Res.getChildren().clear();
		Remplir_Res(vect);
		
		hide_sum_container();
		res_container.setOpacity(0);
		res_container.setVisible(true);
		res_container.setTranslateY(-50);
		FadeTransition ft1=new FadeTransition();
		ft1.setToValue(1);
		ft1.setNode(res_container);
		ft1.setDuration(Duration.millis(500));
		ft1.play();
	
		
	}
	
	@FXML
	private JFXButton app_sum;
	
	public void show_sum_container()
	{
		hide_sum_container();
		TranslateTransition tt=new TranslateTransition();
		tt.setToY(0);
		tt.setNode(tab1_container);
		tt.setDuration(Duration.millis(800));
		
		TranslateTransition tt1=new TranslateTransition();
		tt1.setToY(0);
		tt1.setNode(res_container);
		tt1.setDuration(Duration.millis(800));
		FadeTransition ft1=new FadeTransition();
		ft1.setToValue(0);
		ft1.setNode(res_container);
		ft1.setDuration(Duration.millis(800));
		
		tab2_container.setOpacity(0);
		tab2_container.setVisible(true);
		tab2_container.toFront();
		FadeTransition ft2=new FadeTransition();
		ft2.setToValue(1);
		ft2.setNode(tab2_container);
		ft2.setDuration(Duration.millis(800));
		
		
		
		ParallelTransition pt=new ParallelTransition(tt,tt1,ft1,ft2);
		pt.setOnFinished(finish->{
			sum_container.setOpacity(0);
			sum_container.setVisible(true);
			sum_container.toFront();
			FadeTransition ft3=new FadeTransition();
			ft3.setToValue(1);
			ft3.setNode(sum_container);
			ft3.setDuration(Duration.millis(700));
			ft3.play();
			
		});
		
		pt.play();
	}
	
	public void hide_sum_container()
	{
		err_msg.setVisible(false);
		FadeTransition ft3=new FadeTransition();
		ft3.setToValue(0);
		ft3.setNode(sum_container);
		ft3.setDuration(Duration.millis(700));

	
		TranslateTransition tt=new TranslateTransition();
		tt.setToY(50);
		tt.setNode(tab1_container);
		tt.setDuration(Duration.millis(800));
		
		FadeTransition ft2=new FadeTransition();
		ft2.setToValue(0);
		ft2.setNode(tab2_container);
		ft2.setDuration(Duration.millis(500));
		
		TranslateTransition tt1=new TranslateTransition();
		tt1.setToY(-50);
		tt1.setNode(res_container);
		tt1.setDuration(Duration.millis(800));
		res_container.toFront();
		tab1_container.toFront();
		
		FadeTransition ft4=new FadeTransition();
		ft4.setToValue(0);
		ft4.setNode(mm_container);
		ft4.setDuration(Duration.millis(500));
		
		ParallelTransition pt=new ParallelTransition(ft3,tt1,tt,ft2,ft4);
		pt.play();
		
		
		
	}
	public void Sommer()
	{
		int  []vect1=Remplir_tab();
		int vect2[]=new int[taille2];
		int i=0;String m;
		for (i=0;i<taille2;i++)
		{
			m=((JFXTextField)Tab2.getChildren().get(i)).getText();
			if (m!="") vect2[i]=Integer.parseInt(m);
			else vect2[i]=0;
			
			System.out.println(vect2[i]);
		}
		
		int[] vect;
		try {
			vect = vectorhelper.somme(vect1, vect2);
			Res.getChildren().clear();
			Remplir_Res(vect);
			FadeTransition ft3=new FadeTransition();
			ft3.setToValue(0);
			ft3.setNode(sum_container);
			ft3.setDuration(Duration.millis(500));
			ft3.setOnFinished(finsih->{
				res_container.toFront();
				res_container.setVisible(true);
				res_container.setOpacity(0);
				FadeTransition ft2=new FadeTransition();
				ft2.setToValue(1);
				ft2.setNode(res_container);
				ft2.setDuration(Duration.millis(500));
				ft2.play();
			});
			ft3.play();
		} catch (DifferentSizeException e) {
			// TODO Auto-generated catch block
			err_msg.setVisible(true);
			e.printStackTrace();
		}
		
	}
	
	public void Inverser()
	{
		int  []vect=vectorhelper.Inverser(Remplir_tab());
		Res.getChildren().clear();
		Remplir_Res(vect);
		
		hide_sum_container();
		res_container.setOpacity(0);
		res_container.setVisible(true);
		res_container.setTranslateY(-50);
		FadeTransition ft1=new FadeTransition();
		ft1.setToValue(1);
		ft1.setNode(res_container);
		ft1.setDuration(Duration.millis(500));
		ft1.play();
	}
	
	@FXML
	private Label min;
	@FXML
	private Label max;
	
	
	public void show_mm_cont()
	{
		mm_container.setOpacity(0);
		mm_container.setVisible(true);
		FadeTransition ft1=new FadeTransition();
		ft1.setToValue(0);
		ft1.setNode(res_container);
		ft1.setDuration(Duration.millis(500));
		ft1.setOnFinished(finish->{
			FadeTransition ft2=new FadeTransition();
			ft2.setToValue(1);
			ft2.setNode(mm_container);
			ft2.setDuration(Duration.millis(500));
			ft2.play();
		});
		ft1.play();
	}
	
	
	
	public void Maxmin()
	{
		MinMax mm=vectorhelper.minEtMax(Remplir_tab());
		min.setText(""+mm.getMin());
		max.setText(""+mm.getMax());
		hide_sum_container();
		show_mm_cont();
	}
	
	
	public void Fonction()
	{
		int  []vect=vectorhelper.Fonction(Remplir_tab());
		Res.getChildren().clear();
		Remplir_Res(vect);
		
		hide_sum_container();
		res_container.setOpacity(0);
		res_container.setVisible(true);
		res_container.setTranslateY(-50);
		FadeTransition ft1=new FadeTransition();
		ft1.setToValue(1);
		ft1.setNode(res_container);
		ft1.setDuration(Duration.millis(500));
		ft1.play();
	}
	
	

}
