package com.soigne_ton_temps.app.domain.Priorite;

public class Incertain implements NiveauPrioriteAvecJugement {

    public int niveau = 0;

    private boolean seemsMalade;

    public final float delai = 0.0F;

    public Incertain(boolean seemsMalade) {
        this.seemsMalade = seemsMalade;
        ajusterNiveau();
    }

    @Override
    public int getNiveau(){
        return niveau;
    }

    @Override
    public float getDelai(){
        return delai;
    }

    @Override
    public boolean isSeemsMalade() {
        return seemsMalade;
    }

    @Override
    public void setSeemsMalade(boolean seemsMalade) {
        this.seemsMalade = seemsMalade;
        ajusterNiveau();
    }

    private void ajusterNiveau(){
        if (seemsMalade) {
            this.niveau = 2;
        }
        else {
            this.niveau = 4;
        }
    }
}
