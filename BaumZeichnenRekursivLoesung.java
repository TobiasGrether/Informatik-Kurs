public void zeichneBaum(double length, int steps){
        if(steps >0){
            move(length);
            turn(-45);
            zeichneBaum(length*0.7, steps-1);
           
            turn(90);
            zeichneBaum(length*0.7, steps-1);
            turn(-45);
            zeichneBaum(length*0.7, steps-1);
            penUp();
            move(-length);
            penDown();
        }
    }