package es.cide.programacion;
/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 12/12/2024
 * 
 */
public class martell extends eina{ //clase martell hereda de eina

    public martell(Double pes, String material){ //constructor de martell
        super(pes, material); //llama al constructor de eina
        super.setNom("Martell");   //establece el nombre de la herramienta
    }
    @Override //sobreescribe el método utilitzar
    public void utilitzar(){ //método utilitzar
        System.out.println("Colpejant amb el martell");
    } 
}
