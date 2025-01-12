package com.soigne_ton_temps.app.domain.Priorite;

import com.soigne_ton_temps.app.domain.Priorite.NiveauPriorite;

public class MoinsUrgent implements NiveauPriorite {

    public final int niveau = 4;

    public final float delai = 1F;

    @Override
    public int getNiveau(){
        return niveau;
    }

    @Override
    public float getDelai(){
        return delai;
    }
}
