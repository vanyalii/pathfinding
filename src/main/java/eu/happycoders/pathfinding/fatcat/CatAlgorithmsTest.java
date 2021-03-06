package eu.happycoders.pathfinding.fatcat;

import eu.happycoders.pathfinding.fatcat.algorithm.*;
import eu.happycoders.pathfinding.fatcat.common.*;

/**
 * Tests the 1990 and 2020 cat algorithms with random positions for cat and mouse.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class CatAlgorithmsTest {

  public static void main(String[] args) {
    testWith(new CatAlgorithmFrom1990());
    testWith(new CatAlgorithmFrom2020());
    testWith(new CatAlgorithmFrom2020Opt());
  }

  private static void testWith(CatAlgorithm algorithm) {
    System.out.printf("Algorithm: %s%n%n", algorithm.getClass().getSimpleName());

    GameState gameState = new GameState(LabFactory.createLab1()).withRandomCatMousePositions();

    System.out.printf("%nStep  0: catDir = null%n%n");
    gameState.printLab();

    int step = 0;
    while (!gameState.hasCatEatenMouse()) {
      gameState = algorithm.moveCat(gameState);
      System.out.printf("%nStep %2d: catDir = %s%n%n", ++step, gameState.getCatDir());
      gameState.printLab();
    }
  }
}
