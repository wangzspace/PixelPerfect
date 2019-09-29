import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PixelPerfect extends PApplet {

int scale = 20;
int cols, rows;
boolean game = false;
boolean menu = false;
int w = 1000;
int h = 1000;

String venusaur = "venusaur.png";
String charizard = "charizard.png";
String blastoise = "blastoise.png";
PImage ven, cha, bla;
boolean anx = false;

public void setup() {
  
  cols = width/scale;
  rows = height/scale;
  textSize(72);
  textAlign(CENTER, CENTER);
  fill(0);
  text("start", 500, 500);
  ven = loadImage(venusaur);
  cha = loadImage(charizard);
  bla = loadImage(blastoise);
}

public void draw() {
}

public void mousePressed() {
  if (menu) {
    if (mouseX > 100  && mouseX < 400 && mouseY > 200 && mouseY < 500) {
      launch(dataPath("venusaur.png"));
    } else if (mouseX > 600  && mouseX < 900 && mouseY > 200 && mouseY < 500) {
      launch(dataPath("charizard.png"));
    } else if (mouseX > 100  && mouseX < 400 && mouseY > 600 && mouseY < 900) {
      launch(dataPath("blastoise.png"));
    }
    createGame();
  } else if (game) {
    int x = floor(mouseX/20)*20;
    int y = floor(mouseY/20)*20;
    fill(random(255), random(255), random(255));
    rect(x, y, 20, 20);
    if (mouseButton == RIGHT) {
      fill(255);
      rect(x, y, 20, 20);
    }
  } else {
    if (mouseX < 620 && mouseX > 380 && mouseY < 530 && mouseY > 470) {
      createMenu();
    }
  }
}

public void keyPressed() {
  if (key == 'r') {
    createMenu();
  }
  if (key == 's' && game) {
    saveFrame("perfect.png");
  }
}

public void createMenu() {
  menu = true;
  game = false;
  fill(255);
  rect(0, 0, w, h);
  fill(0);
  textAlign(CENTER, CENTER);
  textSize(48);
  text("choose a starter", 500, 80);
  textSize(20);
  text("'r' to return to menu | 's' to save | right click to erase", 500, 140);
  image(ven, 100, 200, 300, 300);
  image(cha, 600, 200, 300, 300);
  image(bla, 100, 600, 300, 300);
  textSize(56);
  text("free draw!", 750, 750);
}

public void createGame() {
  game = true;
  menu = false;
  for (int i = 0; i < cols; i++) {
    for (int j = 0; j < rows; j++) {
      int x = i*scale;
      int y = j*scale;
      stroke(0);
      fill(255);
      rect(x, y, scale, scale);
    }
  }
}
  public void settings() {  size(1000, 1000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PixelPerfect" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
