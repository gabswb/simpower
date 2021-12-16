package view;

import patterns.Observable;
import patterns.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InformationPanel extends JPanel implements Observer {

    public static final int INFO_PANEL_WHIDTH = 1024;
    public static final int INFO_PANEL_HEIGHT = 50;
    public static final int INFO_PANEL_COORD_X = 0;
    public static final int INFO_PANEL_COORD_Y = 0;

    private JLabel populationLabel;
    private JLabel populationAvailableLabel;
    private JLabel energyProducedLabel;
    private JLabel energyPriceLabel;
    private JLabel pollutionRateLabel;
    private JLabel userMoneyLabel;

    private List<JLabel> labelList;




    public InformationPanel(){

        this.setLayout(new FlowLayout());

        populationLabel = new JLabel();
        populationAvailableLabel = new JLabel();
        energyProducedLabel = new JLabel();
        energyPriceLabel = new JLabel();
        pollutionRateLabel = new JLabel();
        userMoneyLabel = new JLabel();

        this.add(populationLabel);
        this.add(populationAvailableLabel);
        this.add(energyProducedLabel);
        this.add(energyPriceLabel);
        this.add(pollutionRateLabel);
        this.add(userMoneyLabel);
    }


    /**
     * Lorsque l'on appel la method JFrame.pack(), celle-ci apelle la méthode getPreferredSize() de chacun de ses composants pour adapter au mieux sa taille
     * @return la Dimension du JPanel de la barre d'info que l'on souhaite
     */
    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(INFO_PANEL_WHIDTH, INFO_PANEL_HEIGHT));
    }




    /**
     * Methode de l'interface Observable, qui est appeleé par le model (La Map) qui hérité de la classe abstraite observable
     * Cette méthode est appelée pour actualiser les données affichées par la vues lorsque celles-ci sont modifiées dans le modèle
     * @param population nombre d'habitants de la map
     * @param populationAvailable nombre d'habitants potentiels mais qui n'ont pas de place (pas de Building de type Home) pour appartenir à la ville
     * @param populationMax nombre total d'hbts que peut acceuillir touts les Building de type Home de la Map
     * @param energyProduced somme des enregies produites par toutes les EnergySources
     * @param energyPrice ratio entre energyProduced et et population
     * @param pollutionRate ratio entre les source d'énergies fossiles et sources d'énergies renouvelables
     * @param userMoney argent du joueur
     */
    @Override
    public void update(int population, int populationAvailable, int populationMax, double energyProduced, double energyPrice, double pollutionRate, int userMoney) {
        populationLabel.setText(String.valueOf("Population : " + population)+"/"+String.valueOf(populationMax));
        populationAvailableLabel.setText(String.valueOf("Population available : "+populationAvailable));
        energyProducedLabel.setText(String.format("Energy produced : %.2f" ,energyProduced));
        energyPriceLabel.setText(String.format("Energy price : %.3f",energyPrice));
        pollutionRateLabel.setText(String.format("Pollution rate : %.2f",pollutionRate));//TODO mettre en rouge quand depasse les 75% par exemple
        userMoneyLabel.setText(String.valueOf("Ressources : "+userMoney));
    }
}
