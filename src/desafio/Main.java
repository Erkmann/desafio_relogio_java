package desafio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    private int hora;
    private int minuto;


    public long retornaAnguloRelogio(GregorianCalendar horario){

        long angulo;

        this.hora = horario.get(Calendar.HOUR); //pega a hora
        this.minuto = horario.get(Calendar.MINUTE); //pega o minuto

        float dividido = (float) this.minuto / 5; //divide os minutos por 5 para saber em qual numero no relogio o minuto esta

        if ((float) this.hora != dividido){ //verifica se o numero da hora nao eh igual ao do minuto, pq se for sera 0 o angulo

            if(dividido > (float) this.hora){ //se o numero no relogio do minuto for maior q o da hora
                angulo = (this.minuto - (this.hora * 5)) * 6; /* multiplica o numero da hora por 5 para saber quantos
                                                                minutos no relogio o ponteiro teria andado
                                                               depois diminue a quantidade de minutos, e por fim
                                                               multiplica por 6 que eh quantos graus existem entre
                                                               um minuto e o outro no relogio analogico */
                return angulo;
            }
            else if(dividido < (float) this.hora){//se o numero no relogio do minuto for menor q o da hora
                angulo = ((this.hora * 5) - this.minuto) * 6; /* mesmo processo, porem tira-se minutos da hora
                                                               (como se fosse girar o relogio no sentido
                                                               contrario, para utilizar a menor angulacao possivel entre os ponteiros) */
                return angulo;
            }

        }

        return 0; //retorna zero caso os ponteiros estejam sobrepostos

    }

    public static void main(String[] args) {
        Main call = new Main();
        GregorianCalendar calendario = new GregorianCalendar();
        System.out.println(call.retornaAnguloRelogio(calendario) + " graus");
    }

}
