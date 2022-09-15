package trainin.pluginm.calcs;

public interface Calculatable extends Sumable, Substragle {
    int calculate(int x, char operator, int y);
}
