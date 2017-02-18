package dev4;

import dev4.EnterText.EnterText;
import dev4.AddText.AddText;
import dev4.Spliter.Spliter;
import dev4.PrintInformation.*;

import java.util.List;
import java.util.Scanner;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point to work.
   */
  public static void main(String[] args) {
    final int MIN_ADDES_PIECE = 3;
    int cycleCounter = 0;
    int minAddCounter = 0;
    List<String> splitWordsList;
    Scanner in = new Scanner(System.in);
    String text = "";
    EnterText inputer = new EnterText();
    AddText adder = new AddText();
    Spliter spliter = new Spliter();
    PrintInformation printer = new PrintInformation();

    while (cycleCounter < 1) {
      if (minAddCounter < MIN_ADDES_PIECE) {
        System.out.println("Enter piece of text: ");
        text = adder.addText(inputer.enterText(), text);
        splitWordsList = spliter.splitStringIntoWords(text);
        printer.printInformation(splitWordsList);
        minAddCounter++;
      } else {
        System.out.println("Do you want to input text? y/n");
        String choose = in.nextLine();
        if (choose.equals("n")) {
          break;
        } else if (choose.equals("y")) {
          System.out.println("Enter piece of text: ");
          text = adder.addText(inputer.enterText(), text);
          splitWordsList = spliter.splitStringIntoWords(text);
          System.out.println(splitWordsList);
          printer.printInformation(splitWordsList);
        } else {
          System.out.println("You inter incorrect comand");
        }
      }
    }
  }
}