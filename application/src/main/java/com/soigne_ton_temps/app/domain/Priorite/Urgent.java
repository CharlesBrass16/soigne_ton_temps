package com.soigne_ton_temps.app.domain.Priorite;

public class Urgent implements NiveauPriorite {

    public final int niveau = 3;

    public final float delai = 0.5F;

    @Override
    public int getNiveau(){
        return niveau;
    }

    @Override
    public float getDelai(){
        return delai;
    }
}
