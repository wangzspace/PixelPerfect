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

void setup() {
  size(1000, 1000);
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

void draw() {
}

void mousePressed() {
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

void keyPressed() {
  if (key == 'r') {
    createMenu();
  }
  if (key == 's' && game) {
    saveFrame("perfect.png");
  }
}

void createMenu() {
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

void createGame() {
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