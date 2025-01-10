package es.cide.dam.programacio.yaaz;

public class superZombie extends zombie{
    public superZombie(){
        super();
        super.setAtaque(getAtaque()*2);
        super.setSalut(getSalut()*3);
    }
}
