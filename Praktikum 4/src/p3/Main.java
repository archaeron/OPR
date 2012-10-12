package p3;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends Applet implements ActionListener
{
	private Label vornameLabel = new Label("Vorname");
	private Label nachnameLabel = new Label("Nachname");
	private Label adresseLabel = new Label("Adresse");
	private TextField vornameInput = new TextField();
	private TextField nachnameInput = new TextField();
	private TextField adresseInput = new TextField();
	private Button left = new Button("<<<");
	private Button right = new Button(">>>");
	private Button enter = new Button("Eingabe");
	private ArrayList<Person> persons = new ArrayList<Person>();
	private int aktivePerson = 0;
	
	public void init()
	{
		setLayout(new GridLayout(5, 2));
		add(vornameLabel);
		add(vornameInput);
		add(nachnameLabel);
		add(nachnameInput);
		add(adresseLabel);
		add(adresseInput);
		add(left);
		add(right);
		add(enter);
		
		left.addActionListener(this);
		right.addActionListener(this);
		enter.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == enter)
		{
			Person p = new Person(vornameInput.getText(), nachnameInput.getText(), adresseInput.getText());
			System.out.println(p);
			persons.add(p);
			vornameInput.setText("");
			nachnameInput.setText("");
			adresseInput.setText("");
		}
		else if(source == left)
		{
			System.out.println("left");
			aktivePerson++;
			changePerson();
		}
		else if(source == right)
		{
			System.out.println("right");
			aktivePerson--;
			changePerson();
		}
	}
	
	private void changePerson()
	{
		if(aktivePerson > persons.size() - 1) aktivePerson = 0;
		if(aktivePerson < 0) aktivePerson = persons.size() - 1;
		Person p = persons.get(aktivePerson);
		vornameInput.setText(p.getVorname());
		nachnameInput.setText(p.getNachname());
		adresseInput.setText(p.getAdresse());
	}
	
}
