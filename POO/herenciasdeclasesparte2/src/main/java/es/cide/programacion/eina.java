package es.cide.programacion;
/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 12/12/2024
 * 
 */
public class eina { // Clase eina

    private Double pes; // Atributo pes
    private String material; // Atributo material
    private String nom; // Atributo nom

    public eina(Double pes, String material){ // Constructor de eina

        this.pes = pes; // Inicializa el atributo pes
        this.material = material; // Inicializa el atributo material
        this.nom = "Eina genèrica"; // Inicializa el atributo nom

    }

    public Double getPes(){ // Método getter de Pes
        return pes; // Devuelve el atributo pes
    }

    public String getMaterial(){ // Método getter de Material
        return material; // Devuelve el atributo material
    }

    public String getNom(){ // Método getter de Nom
        return nom; //Devuelve el atributo nom
    }

    public void setPes(Double pes){ // Método setter de Pes
        this.pes = pes; // Establece el atributo pes
    }

    public void setMaterial(String material){ // Método setter de Material
        this.material = material; // Establece el atributo material
    }
    
    public void setNom(String nom){ // Método setter de Nom
        this.nom = nom; // Establece el atributo nom
    }

    public void utilitzar(){ // Método utilitzar
        System.out.println("Utilitzant eina genèrica");
    }
}
