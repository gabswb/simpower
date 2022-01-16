package main.java.view;

import main.java.model.Box;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Classe qui affiche les différentes cases de la Map.
 * Cette classe hérite de JPanel car elle peut contenir d'autres éléments graphiques comme des vues de bâtiment
 * Cette classe implémente l'interface BoxViewable pour implémenter toutes les méthodes nécessaires au bon affichage des cases
 */
public class BoxPanel extends JPanel implements BoxViewable{

    int positionX;//< abscisse de la vue
    int positionY;//< ordonnées de la vue

    BufferedImage image;//< icon de la vue
    BuildingViewable buildingView;//< Vue de du bâtiment que cette case contient

    BoxPanel(Box[][] boxes, int x, int y) {
        URL resource;

        //récupération du bon icon selon les caractéristiques de la Box dans le main.java.model
        if (boxes[x][y].getWater()!=0) {resource = getClass().getResource("/images/water.png");}
        else if (boxes[x][y].hasCoal() && boxes[x][y].getWind()<=15 && boxes[x][y].getSun()<=15) {resource = getClass().getResource("/images/coal.png");}
        else if (boxes[x][y].hasGas() && boxes[x][y].getWind()<=15 && boxes[x][y].getSun()<=15) {resource = getClass().getResource("/images/gas.png");}
        else if (boxes[x][y].hasUranium() && boxes[x][y].getWind()<=15 && boxes[x][y].getSun()<=15) {resource = getClass().getResource("/images/uranium.png");}

        else if (boxes[x][y].getWind()>15 && !boxes[x][y].hasCoal() && !boxes[x][y].hasGas() && !boxes[x][y].hasUranium()) {resource = getClass().getResource("/images/wind.png");}
        else if (boxes[x][y].getWind()>15 && boxes[x][y].hasCoal()) {resource = getClass().getResource("/images/coal_wind.png");}
        else if (boxes[x][y].getWind()>15 && boxes[x][y].hasGas()) {resource = getClass().getResource("/images/gas_wind.png");}
        else if (boxes[x][y].getWind()>15 && boxes[x][y].hasUranium()) {resource = getClass().getResource("/images/uranium_wind.png");}

        else if (boxes[x][y].getSun()>15 && !boxes[x][y].hasCoal() && !boxes[x][y].hasGas() && !boxes[x][y].hasUranium()) {resource = getClass().getResource("/images/sun.png");}
        else if (boxes[x][y].getSun()>15 && boxes[x][y].hasCoal()) {resource = getClass().getResource("/images/coal_sun.png");}
        else if (boxes[x][y].getSun()>15 && boxes[x][y].hasGas()) {resource = getClass().getResource("/images/gas_sun.png");}
        else if (boxes[x][y].getSun()>15 && boxes[x][y].hasUranium()) {resource = getClass().getResource("/images/uranium_sun.png");}
        else{resource = getClass().getResource("/images/grass.png");}

        try {
            assert resource != null;
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setLayout(new BorderLayout());
        this.positionX = x;
        this.positionY = y;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    /**
     * Ajoute la vue d'un bâtiment à la vue de la Box et actualise l'affichage de la vue
     * @param buildingView vue du bâtiment
     */
    public void addBuilding(BuildingViewable buildingView){
        this.buildingView = buildingView;
        this.add((BuildingView) buildingView);
        this.repaint();
    }

    /**
     * Retire la vue d'un bâtiment à la vue de la Box et actualise l'affichage de la vue
     * @param buildingView vue du bâtiment
     */
    public void removeBuilding(BuildingViewable buildingView){
        this.buildingView = null;
        this.remove((BuildingView) buildingView);
        this.repaint();
    }


    public BuildingViewable getBuildingView() {
        return buildingView;
    }
}
