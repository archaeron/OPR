package p3;

public class Person
{
	private String nachname;
	private String vorname;
	private String adresse;
	
	public Person(String nachname, String vorname, String adresse)
	{
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		this.adresse = adresse;
	}
	
	public String toString()
	{
		return vorname + " " + nachname + " : " + adresse;
	}

	public String getNachname()
	{
		return nachname;
	}

	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}

	public String getVorname()
	{
		return vorname;
	}

	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
}
