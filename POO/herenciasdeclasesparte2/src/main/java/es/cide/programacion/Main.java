package es.cide.programacion;
/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 12/12/2024
 * 
 */
public class Main {
    public static void mostrarEina(eina unaEina){
        unaEina.utilitzar();
        System.out.println("Eina: "+ unaEina.getNom() + ", Pes: " + unaEina.getPes() + " kg, Material: " + unaEina.getMaterial());
        System.out.println("----------------------------");
    }
    public static void main(String[] args) {
            eina martillo = new martell(1.5, "Metall");
            eina destornilladorPhilips = new destornillador(0.7, "Acer");
            eina sierra = new serra(2.3,"Fusta");
            Main.mostrarEina(martillo);
            Main.mostrarEina(destornilladorPhilips);
            Main.mostrarEina(sierra);
    }
}