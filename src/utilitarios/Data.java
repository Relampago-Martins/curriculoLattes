package utilitarios;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;

public class Data implements Serializable{

	private int dia, mes, ano;
	
	public Data(int dia, int mes, int ano) {
		boolean diaCheck, mesCheck, anoCheck;
		diaCheck = this.setDia(dia);
		mesCheck = this.setMes(mes);
		anoCheck = this.setAno(ano);
		
		if (!(diaCheck && mesCheck && anoCheck)) {
			throw new IllegalArgumentException("Data informada é invalida");
		}
	}

	/**
	 * Constructor para formato pt-BR de data
	 * @param data String no formato dd/mm/aaaa
	 */
	public Data(String data){
		this();
		String[] datas = data.trim().split("/");
		this.setDia(Integer.parseInt(datas[0]));
		this.setMes(Integer.parseInt(datas[1]));
		this.setAno(Integer.parseInt(datas[2]));

	}
	
	public Data() {
		TimeZone zone = TimeZone.getTimeZone("GMT-03:00");
		Locale locale = Locale.forLanguageTag("pt-BR");
		Calendar calendario = Calendar.getInstance(zone, locale);
		
		this.dia = calendario.get(Calendar.DATE);
		this.mes = calendario.get(Calendar.MONTH) + 1;
		this.ano = calendario.get(Calendar.YEAR);
	}
	
	public String toString() {
		return this.getDataFormatada();
	}

	public String getDataFormatada() {
		return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
	}
	
	public boolean passarDia() {
		boolean setter = true;

		if (this.setDia(this.dia+1)) {
		}
		else if (this.setMes(this.mes+1)) {
			this.setDia(1);
		}
		else if (this.setAno(this.ano+1)) {
			this.setMes(1);
		}
		else setter = false;
		
		return setter;
	}
	public int getDiferencaEmAnos(Data dataParam) {
		Data dataMaior = this, dataMenor=dataParam;
		
		if(dataMaior.compareTo(dataMenor) < 0) {
			dataMaior = dataParam;
			dataMenor = this;
		}

		int idade = dataMaior.getAno() - dataMenor.getAno();
		int mesDiff = dataMaior.getMes() - dataMenor.getMes();
		int diaDiff = dataMaior.getDia() - dataMenor.getDia();

		if (mesDiff < 0) {
			idade--;
		}else if (mesDiff == 0 && diaDiff < 0) {
			idade--;
		}
		return idade;
	}

	public int compareTo(Data dataDois) {
		if (this.ano == dataDois.ano && this.mes == dataDois.mes && this.dia == dataDois.dia) {
			return 0;
		}else {
			if (this.ano > dataDois.ano
				|| this.ano == dataDois.ano && this.mes > dataDois.mes
				|| this.ano == dataDois.ano && this.mes == dataDois.mes && this.dia > dataDois.dia) {
				return 1;
			}
			return -1;
		}
	}
	
	public int getDia() {
		return dia;
	}
	private boolean setDia(int dia) {
		boolean setter = false;
		
		if (dia>=1 && dia<=31) {
			this.dia = dia;
			setter = true;
		}
		return setter;
	}

	public int getMes() {
		return mes;
	}
	private boolean setMes(int mes) {
		boolean setter = false;
		
		if (mes>=1 && mes<=12) {
			this.mes = mes;
			setter = true;
		}
		return setter;
	}

	public int getAno() {
		return ano;
	}
	private boolean setAno(int ano) {
		boolean setter = false;
		
		if (ano>=1) {
			this.ano = ano;
			setter = true;
		}
		return setter;
	}
	
}
