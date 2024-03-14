package main;
public class Player {
    private String name;
    private int puntos;

    public Player (String _name, int _score) {
        this.name = _name;
        this.puntos = _score;
    }



    /** 
     * @param _name Nombre de usuario que va a jugar.
     */
    public void setName(String _name) {
        this.name = _name;
    }

    /**
     * Devuelve el nombre
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param _puntos Escribe los puntos
     */
    public void setPuntos(int _puntos) {
        this.puntos = _puntos;
    }

    /**
     * Devuelve los puntos
     * @return
     */
    public int getPuntos() {
        return this.puntos;
    }




}
