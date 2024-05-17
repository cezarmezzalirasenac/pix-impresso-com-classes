package classes;

public class CaixaEletronico {
  private int idCaixaEletronico;
  private String localizacao;
  private double saldo;

  public CaixaEletronico(int idCaixaEletronico, String localizacao, double saldo) {
    this.idCaixaEletronico = idCaixaEletronico;
    this.localizacao = localizacao;
    this.saldo = saldo;
  }

  public int getIdCaixaEletronico() {
    return idCaixaEletronico;
  }

  public void setIdCaixaEletronico(int idCaixaEletronico) {
    this.idCaixaEletronico = idCaixaEletronico;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

}
