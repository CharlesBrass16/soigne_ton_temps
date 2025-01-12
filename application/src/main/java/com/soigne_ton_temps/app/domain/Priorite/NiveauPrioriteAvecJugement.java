package com.soigne_ton_temps.app.domain.Priorite;

public interface NiveauPrioriteAvecJugement extends NiveauPriorite{

    boolean isSeemsMalade();
    void setSeemsMalade(boolean seemsMalade);

}
