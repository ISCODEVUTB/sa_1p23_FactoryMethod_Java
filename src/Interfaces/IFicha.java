package Interfaces;

import Characters.Characters;
import Characterizations.Characterizations;
import League.Leagues;

public interface IFicha {
    public void Add(Characterizations characterization);
    public void League(Leagues league);
    public void Enemy(Characters enemy);
}
