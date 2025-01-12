package com.soigne_ton_temps.app.domain.Priorite;

public class Reanimation implements NiveauPriorite {

    private final int niveau = 1;

    private final float delai = 0.1F;

    @Override
    public int getNiveau() {
        return niveau;
    }

    @Override
    public float getDelai(){
        return delai;
    }
}
