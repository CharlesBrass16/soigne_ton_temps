package com.soigne_ton_temps.app.domain.Priorite;

public class TresUrgent implements NiveauPriorite {

    public final int niveau = 2;

    public final float delai = 0.25F;

    @Override
    public int getNiveau(){
        return niveau;
    }

    @Override
    public float getDelai(){
        return delai;
    }


}
