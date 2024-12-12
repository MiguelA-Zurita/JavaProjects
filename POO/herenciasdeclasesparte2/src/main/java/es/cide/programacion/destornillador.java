package es.cide.programacion;
/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 12/12/2024
 * 
 */
public class destornillador extends eina{ //clase destornillador hereda de eina

    public destornillador(Double pes, String material){ //constructor de destornillador
        super(pes, material); //llama al constructor de eina
        super.setNom("Destornillador"); //Establece el nombre de la herramienta
    }
    @Override //sobreescribe el método utilitzar
    public void utilitzar(){ //método utilitzar
        System.out.println("Tornant cargols amb el destornillador"); 
    }
    
}
