package com.soigne_ton_temps.app.domain.Priorite;

import com.soigne_ton_temps.app.domain.Priorite.NiveauPriorite;

public class NonUrgent implements NiveauPriorite {

    public final int niveau = 5;

    public final float delai = 2F;

    @Override
    public int getNiveau(){
        return niveau;
    }

    @Override
    public float getDelai(){
        return delai;
    }


}
