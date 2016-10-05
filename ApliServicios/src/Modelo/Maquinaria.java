
package Modelo;


public class Maquinaria
{

   private String Placa;
   private String Modelo;
   private String Marca;
   private String PesoMax;
   private String CodTRecurso;

    public Maquinaria(String Placa, String Modelo, String Marca, String PesoMax, String CodTRecurso) {
        this.Placa = Placa;
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.PesoMax = PesoMax;
        this.CodTRecurso = CodTRecurso;
    }
   
       public Maquinaria() {
        this.Placa = "";
        this.Modelo = "";
        this.Marca = "";
        this.PesoMax = "";
        this.CodTRecurso ="" ;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getPesoMax() {
        return PesoMax;
    }

    public void setPesoMax(String PesoMax) {
        this.PesoMax = PesoMax;
    }

    public String getCodTRecurso() {
        return CodTRecurso;
    }

    public void setCodTRecurso(String CodTRecurso) {
        this.CodTRecurso = CodTRecurso;
    }
      
       
}