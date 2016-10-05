
package Modelo;


public class DesHabilitarR 
{
    private String idStatusRecurso;
    private String DescStatusRecurso;
    private String FechaInicio;
    private String FechaFin;
    private String Observacion;
    private String CodTRecurso;
    
      public DesHabilitarR() 
      {
        idStatusRecurso = "";
        DescStatusRecurso = "";
        FechaInicio = "";
        FechaFin = "";
        Observacion = "";
        CodTRecurso = "";
    }

    public DesHabilitarR(String idStatusRecurso, String DescStatusRecurso, String FechaInicio, String FechaFin, String Observacion, String CodTRecurso) {
        this.idStatusRecurso = idStatusRecurso;
        this.DescStatusRecurso = DescStatusRecurso;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Observacion = Observacion;
        this.CodTRecurso = CodTRecurso;
    }

    public String getIdStatusRecurso() 
    {
        return idStatusRecurso;
    }

    public void setIdStatusRecurso(String idStatusRecurso)
    {
        this.idStatusRecurso = idStatusRecurso;
    }

    public String getDescStatusRecurso() {
        return DescStatusRecurso;
    }

    public void setDescStatusRecurso(String DescStatusRecurso) 
    {
        this.DescStatusRecurso = DescStatusRecurso;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) 
    {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() 
    {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) 
    {
        this.FechaFin = FechaFin;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) 
    {
        this.Observacion = Observacion;
    }

    public String getCodTRecurso()
    {
        return CodTRecurso;
    }

    public void setCodTRecurso(String CodTRecurso) 
    {
        this.CodTRecurso = CodTRecurso;
    }
    
}
