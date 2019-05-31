package SubClasses;

import java.util.Calendar;

public class HoraDoSistema
{
    private int horas;
    private int minutos;
    private int segundos;
    Calendar data;

    public HoraDoSistema()
    {
        data = Calendar.getInstance();
    }

    public int getHoras()
    {
        horas = data.get(Calendar.HOUR_OF_DAY);

        return horas;
    }

    public int getMinutos()
    {
        minutos = data.get(Calendar.MINUTE);

        return minutos;
    }

    public int getSegundos()
    {
        segundos = data.get(Calendar.SECOND);
        return segundos;
    }
}
