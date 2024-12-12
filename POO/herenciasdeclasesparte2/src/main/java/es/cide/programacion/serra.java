package es.cide.programacion;
/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 12/12/2024
 * 
 */
public class serra extends eina{ // Serra hereda de eina

    public serra(Double pes, String material){ // Constructor de serra
        super(pes, material); // Llama al constructor de eina
        super.setNom("Serra"); // Establece el nombre de la herramienta
    }
    @Override // Sobreescribe el método utilitzar
    public void utilitzar(){ // Método utilitzar
        System.out.println("Tallant amb la serra");
    } 
}
