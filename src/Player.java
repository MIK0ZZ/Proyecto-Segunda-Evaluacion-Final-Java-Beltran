public class Player {
    private String name;
    private int puntos;
    public Player() {
        
    }
    /** 
     * @param _name Nombre de usuario que va a jugar.
     * Escribe el nombre del usuario
     */
    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public void setPuntos(int _puntos) {
        this.puntos = _puntos;
    }

    public int getPuntos() {
        return this.puntos;
    }



}
